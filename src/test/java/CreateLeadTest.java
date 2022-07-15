import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateLeadTest extends WebDriverSettings{

    /*
    Проверка заполнения обязательных полей
      Переходим на страниц создания предварительного контакта
      Нажимаем кнопку Save
      Видим, что не происходит создание контакта
     */
    @Test
    public void validateData(){
        CreateLeadPage createLeadPage = new CreateLeadPage(driver);
        authorizate();
        driver.get("https://suite8demo.suiteondemand.com/#/leads/edit?return_module=Leads&return_action=DetailView");
        wait.until(ExpectedConditions.elementToBeClickable(createLeadPage.getSaveBtn()));
        createLeadPage.clickSave();
        //Проверка отстуствия перехода на новую страницу
        Assert.assertEquals(driver.getCurrentUrl(), "https://suite8demo.suiteondemand.com/#/leads/edit?return_module=Leads&return_action=DetailView");
    }

    /*
    Проверка корректности создания нового предварительного контакта
      Переходим на страниц создания контакта
      Заполняем phone и name
      Нажимаем кнопку save и переходим на страницу контакта
      Сравниванием изначально поданные значения с тем, что отображается на данной странице
     */
    @Test
    public void createContact(){
        CreateLeadPage createLeadPage = new CreateLeadPage(driver);
        authorizate();
        driver.get("https://suite8demo.suiteondemand.com/#/leads/edit?return_module=Leads&return_action=DetailView");
        wait.until(ExpectedConditions.elementToBeClickable(createLeadPage.getSaveBtn()));
        String name = "Dima";
        String officePhone = "89088888820";
        createLeadPage.enterName(name);
        createLeadPage.enterPhone(officePhone);
        createLeadPage.clickSave();
        wait.until(ExpectedConditions.urlContains("https://suite8demo.suiteondemand.com/#/leads/record/"));
        LeadPage leadPage = new LeadPage(driver);
        Assert.assertEquals(leadPage.getPhoneText(), officePhone);
        Assert.assertEquals(leadPage.getNameText(), name);
    }
}
