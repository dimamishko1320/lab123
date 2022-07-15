import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConvertLeadPage {
    private final By frame = By.xpath("/html/body/app-root/div/scrm-classic-view-ui/div/iframe");
    private final By createCheckbox = By.xpath("//*[@id='newContacts']");
    private final By selectContact = By.xpath("//*[@id='btn_report_to_name']");
    private final By accountNameArea = By.xpath("//*[@id='Accountsname']");
    private final By saveBtn = By.xpath("//*[@id='SAVE_HEADER']");
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
