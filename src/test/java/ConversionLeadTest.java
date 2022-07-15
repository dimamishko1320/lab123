import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ConversionLeadTest extends WebDriverSettings{
    /*
    Проверка преобразования предварительного контакта
    Проверка правильности заполненных из предконтакта полей для создания Контрагента
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
        wait.until(ExpectedConditions.urlContains("https://suite8demo.suiteondemand.com/#/leads/record/"));
        LeadPage leadPage = new LeadPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(leadPage.getActionBtn()));
        leadPage.clickAction();
        leadPage.clickConvertLead();

        ConvertLeadPage convertLeadPage = new ConvertLeadPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(convertLeadPage.getFrame()));
        WebElement frame = driver.findElement(convertLeadPage.getFrame());
        driver.switchTo().frame(frame);
        wait.until(ExpectedConditions.elementToBeClickable(convertLeadPage.getCreateCheckbox()));
        convertLeadPage.clickCreateCheckbox();
        convertLeadPage.clickSelectContact();
        String parentHandle = driver.getWindowHandle();
        for(String childHandle : driver.getWindowHandles()){
            if (!childHandle.equals(parentHandle)){
                driver.switchTo().window(childHandle);
            }
        }
        driver.findElement(By.xpath(" //*[@id='search_form_clear']")).click();
        driver.findElement(By.xpath(" //*[@id='lead_source_advanced']/option[2]")).click();
        driver.findElement(By.xpath("  //*[@id='search_form_submit']")).click();
        driver.findElement(By.xpath("/html/body/table[4]/tbody/tr[1]/td[1]/a")).click();
        driver.switchTo().window(parentHandle);
        driver.switchTo().frame(frame);
        convertLeadPage.enterAccountName("Dimaaaa");
        convertLeadPage.clickSaveBtn();
        if(driver.getPageSource().contains("account record that already exists")){
            driver.findElement(By.xpath("//*[@id='dupAccounts']/table[2]/tbody/tr[1]/td/table/tbody/tr/td/input")).click();
        }
        driver.findElement(By.xpath("//*[@id='pagecontent']/div/ul/li[1]/a")).click();
        driver.switchTo().window(parentHandle);
        WebElement checkName = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form.detail scrm-dynamic-field.dynamic-field-name-account_name >a[href*='accounts/rec']")));
        Assert.assertEquals(checkName.getText(), "Dimaaaa");
    }
}
