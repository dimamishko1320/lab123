import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final By loginInput = By.xpath("//input[@aria-label='Username']");
    private final By passwordInput = By.xpath("//input[@aria-label='Password']");
    private final By loginBtn = By.id("login-button");

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(loginInput).sendKeys(username);
    }

    public void enterPassword(String pass) {
        driver.findElement(passwordInput).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public By getLoginInput() {
        return loginInput;
    }

    public By getPasswordInput() {
        return passwordInput;
    }

    public By getLoginBtn() {
        return loginBtn;
    }
}
