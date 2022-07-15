import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConvertLeadPage {
    private By frame = By.xpath("/html/body/app-root/div/scrm-classic-view-ui/div/iframe");
    private By createCheckbox = By.xpath("//*[@id='newContacts']");
    private By selectContact = By.xpath("//*[@id='btn_report_to_name']");
    private By accountNameArea = By.xpath("//*[@id='Accountsname']");
    private By saveBtn = By.xpath("//*[@id='SAVE_HEADER']");
    WebDriver driver;

    public ConvertLeadPage(WebDriver driver){
        this.driver=driver;
    }

    public void enterAccountName(String accountName) {
        driver.findElement(accountNameArea).sendKeys(accountName);
    }

    public void clickSaveBtn(){
        driver.findElement(saveBtn).click();
    }

    public void clickCreateCheckbox(){
        driver.findElement(createCheckbox).click();
    }

    public void clickSelectContact(){
        driver.findElement(selectContact).click();
    }

    public By getFrame() {
        return frame;
    }

    public By getCreateCheckbox() {
        return createCheckbox;
    }

    public By getSelectContact() {
        return selectContact;
    }
}
