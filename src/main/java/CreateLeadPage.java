import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateLeadPage {

    private By saveBtn = By.xpath("//scrm-button-group/div/scrm-button[1]/button");
    private By nameInput = By.xpath("//div[1]/div[1]/div[2]/div[1]/scrm-field/scrm-dynamic-field/scrm-group-field/div/div[3]/span[2]/scrm-dynamic-field/scrm-varchar-edit/input");
    private By phoneInput = By.xpath("//scrm-field-layout/form/div[1]/div[2]/div[2]/div[1]/scrm-field/scrm-dynamic-field/scrm-varchar-edit/input");

    WebDriver driver;

    public CreateLeadPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSave() {
        driver.findElement(saveBtn).click();
    }

    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public By getSaveBtn() {
        return saveBtn;
    }

    public By getNameInput() {
        return nameInput;
    }

    public By getPhoneInput() {
        return phoneInput;
    }
}
