import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AuthorizationTest extends WebDriverSettings{

    /*
    Проверка авторизации и перенаправления
        Переходим на страницу авторизации
        Вводим в поле логин и пароль will/will
        Кликаем на кнопку Log in
        Дожидаемся пока нас перекинет на страницу home
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
