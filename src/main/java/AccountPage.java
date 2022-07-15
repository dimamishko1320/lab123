import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class AccountPage {
    private final By contactsSubs = By.xpath("//*[@id='collapseShowSubPanels']/div/div[9]");
    private final By leadSubs = By.xpath("//*[@id='collapseShowSubPanels']/div/div[12]");
    private final By closeButtons = By.cssSelector("button.close-button");
    private final By linkContact = By.cssSelector("a.field-link[href*='contacts/record']");
    private final WebDriver driver;
    JavascriptExecutor jse ;
    WebDriverWait wait;

    public AccountPage(WebDriver driver, JavascriptExecutor js, WebDriverWait webDriverWait){
        this.driver = driver;
        this.wait = webDriverWait;
        this.jse=js;
    }

    public void openContact(){
        WebElement element = driver.findElement(contactsSubs);
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
        jse.executeScript("document.querySelector('#collapseShowSubPanels > div > div:nth-child(9)').click()");
    }

    public void openLead(){
        WebElement element = driver.findElement(leadSubs);
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
        jse.executeScript("document.querySelector('#collapseShowSubPanels > div > div:nth-child(12)').click()");
    }

    public void closeAllTables(){
        try{
            WebElement btn = driver.findElement(By.cssSelector("button.close-button"));
            jse.executeScript("arguments[0].scrollIntoView(true);", btn);
            wait.until(ExpectedConditions.elementToBeClickable(btn));
            jse.executeScript("document.querySelector('button.close-button').click()");
            closeAllTables();
        }catch (StaleElementReferenceException e) {
            closeAllTables();
        }catch (NoSuchElementException e){
            return;
        }

    }

    public List<WebElement> getAllLinkContact(){
        return driver.findElements(By.cssSelector("a.field-link[href*='contacts/record']"));
    }

    public List<WebElement> getAllLinkLead(){
        return driver.findElements(By.cssSelector("a.field-link[href*='leads/record']"));
    }

    public By getContactsSubs() {
        return contactsSubs;
    }

    public By getCloseButtons() {
        return closeButtons;
    }

    public By getLeadSubs() {
        return leadSubs;
    }

    public By getLinkContact() {
        return linkContact;
    }
}
