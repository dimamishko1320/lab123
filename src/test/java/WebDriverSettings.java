import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

//Класс настроек для Selenium-тестов
public class WebDriverSettings {
    ChromeDriver driver;
    WebDriverWait wait;
    JavascriptExecutor jse;


    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/dimam/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        jse = (JavascriptExecutor)driver;
    }

    public void authorize(){
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://suite8demo.suiteondemand.com/#/Login");
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginBtn()));
        loginPage.enterUsername("will");
        loginPage.enterPassword("will");
        loginPage.clickLogin();
        wait.until(ExpectedConditions.urlToBe("https://suite8demo.suiteondemand.com/#/home"));
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
