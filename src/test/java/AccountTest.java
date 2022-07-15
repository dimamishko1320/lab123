import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AccountTest extends WebDriverSettings {

    @Test
    public void createContact(){
        final String contactID = "270004e9-a806-f118-68c9-625443eafad9";
        final String leadID = "e9811411-8013-8436-2036-62d11e2fa995";
        AccountPage accountPage = new AccountPage(driver, jse, wait);
        authorizate();
        wait.until(ExpectedConditions.urlToBe("https://suite8demo.suiteondemand.com/#/home"));
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.get("https://suite8demo.suiteondemand.com/#/accounts/record/4c43bbc7-81ae-d013-357f-62d11e73fc21");
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
