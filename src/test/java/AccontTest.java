import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AccontTest extends WebDriverSettings {

    @Test
    public void createContact(){
        AccountPage accountPage = new AccountPage(driver);
        authorizate();
        driver.get("https://suite8demo.suiteondemand.com/#/accounts/record/4c43bbc7-81ae-d013-357f-62d11e73fc21");
        //wait.until(ExpectedConditions.elementToBeClickable(accountPage.getCloseButtons()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountPage.openContact();

        //accountPage.closeAllTables();


    }
}
