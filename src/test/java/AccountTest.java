import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

public class AccountTest extends WebDriverSettings {

    /*
    Проверка создания контрагента, преобразованного из предконтакта,
    проверка наличие привязки к контакту и предконтакту в соответствующих субпанелях
     */
    @Test
    public void createAccount(){
        String contactID = "270004e9-a806-f118-68c9-625443eafad9";
        String leadID;
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
        leadID = Arrays.stream(driver.getCurrentUrl().split("/")).reduce((x,y)->y).get();
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
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.field-link[href*='accounts/record']"))).click();
        AccountPage accountPage = new AccountPage(driver, jse, wait);
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.getContactsSubs()));
        accountPage.closeAllTables();
        accountPage.openContact();
        List<WebElement> linksContacts = accountPage.getAllLinkContact();
        Assert.assertTrue(isAttributeContain(linksContacts, "href", contactID ));
        accountPage.closeAllTables();
        accountPage.openLead();
        List<WebElement> linkLeads = accountPage.getAllLinkLead();
        Assert.assertTrue(isAttributeContain(linkLeads, "href", leadID ));
    }

    private boolean isAttributeContain(List<WebElement> element, String attribute, String key ) {
        for (WebElement el:
             element) {
            try {
                String value = el.getAttribute(attribute);
                if (value != null){
                    if(value.contains(key)) {
                        return true;
                    }
                }
            } catch (Exception e) {}
        }
        return false;
    }
}
