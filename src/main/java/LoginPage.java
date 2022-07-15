import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    private By loginInput = By.xpath("//input[@aria-label='Username']");
    private By passwordInput = By.xpath("//input[@aria-label='Password']");
    private By loginBtn = By.id("login-button");

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
