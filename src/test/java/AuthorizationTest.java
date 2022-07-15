import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class AuthorizationTest extends WebDriverSettings{

    /*
    Проверка авторизации и перенаправления на домашнюю страницу
     */
    @Test
    public void authorization(){
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://suite8demo.suiteondemand.com/#/Login");
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginBtn()));
        loginPage.enterUsername("will");
        loginPage.enterPassword("will");
        loginPage.clickLogin();
        wait.until(ExpectedConditions.urlToBe("https://suite8demo.suiteondemand.com/#/home"));

    }


}
