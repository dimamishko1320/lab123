import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountPage {
    private By contactsSubs = By.cssSelector("#collapseShowSubPanels > div > div:nth-child(9)");
    private By closeButtons = By.cssSelector("button.close-button");
    WebDriver driver;

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void openContact(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", contactsSubs);
        jse.executeScript("document.querySelector('#collapseShowSubPanels > div > div:nth-child(9)').click()");
    }

    public By getContactsSubs() {
        return contactsSubs;
    }

    public void closeAllTables(){

        List<WebElement> closeButtons = driver.findElements(By.cssSelector("button.close-button"));

        for (WebElement btn:
             closeButtons) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
            btn.click();
        }
    }

    public By getCloseButtons() {
        return closeButtons;
    }
}
