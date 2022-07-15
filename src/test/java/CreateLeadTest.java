import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreateLeadTest extends WebDriverSettings{

    /*
    Проверка заполнения обязательных полей на страницы создания предварительного контакта
     */
    @Test
    public void validateData(){
        CreateLeadPage createLeadPage = new CreateLeadPage(driver);
        authorize();
        driver.get("https://suite8demo.suiteondemand.com/#/leads/edit?return_module=Leads&return_action=DetailView");
        wait.until(ExpectedConditions.elementToBeClickable(createLeadPage.getSaveBtn()));
        createLeadPage.clickSave();
        //Проверка отстуствия перехода на новую страницу
        Assert.assertEquals(driver.getCurrentUrl(), "https://suite8demo.suiteondemand.com/#/leads/edit?return_module=Leads&return_action=DetailView");
    }

    /*
    Проверка корректности создания нового предварительного контакта
     */
    @Test
    public void createContact(){
        CreateLeadPage createLeadPage = new CreateLeadPage(driver);
        authorize();
        driver.get("https://suite8demo.suiteondemand.com/#/leads/edit?return_module=Leads&return_action=DetailView");
        wait.until(ExpectedConditions.elementToBeClickable(createLeadPage.getSaveBtn()));
        String name = "Dima";
        String officePhone = "89088888820";
        createLeadPage.enterName(name);
        createLeadPage.enterPhone(officePhone);
        createLeadPage.clickSave();
        LeadPage leadPage = new LeadPage(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(leadPage.getPhoneSaved()));
        Assert.assertEquals(leadPage.getPhoneText(), officePhone);
        Assert.assertEquals(leadPage.getNameText(), name);
    }
}
