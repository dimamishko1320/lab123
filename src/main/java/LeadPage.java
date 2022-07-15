import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeadPage {
    private final By phoneSaved = By.cssSelector("scrm-phone-detail");
    private final By nameSaved = By.className("dynamic-field-name-last_name");
    private final By actionBtn = By.cssSelector("scrm-dropdown-button > div > button");
    private final By convertLeadBtn = By.cssSelector(" a:nth-child(5) > div > div");

    WebDriver driver;

    public LeadPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPhoneText() {
        return driver.findElement(phoneSaved).getText();
    }

    public void clickAction() {
        driver.findElement(actionBtn).click();
    }

    public void clickConvertLead() {
        driver.findElement(convertLeadBtn).click();
    }

    public String getNameText() {
         return driver.findElement(nameSaved).getText();
    }

    public By getPhoneSaved() {
        return phoneSaved;
    }

    public By getNameSaved() {
        return nameSaved;
    }

    public By getActionBtn() {
        return actionBtn;
    }

    public By getConvertLeadBtn() {
        return convertLeadBtn;
    }
}
