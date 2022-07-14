package ru.lab123;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverSettings {
    ChromeDriver driver;
    WebDriverWait wait;
    JavascriptExecutor javascriptExecutor;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/dimam/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        javascriptExecutor = (JavascriptExecutor)driver;
    }

    public void authorizate(){
        driver.get("https://suite8demo.suiteondemand.com/#/Login");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        WebElement loginInput = driver.findElement(By.xpath("//input[@aria-label='Username']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@aria-label='Password']"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginInput.sendKeys("will");
        passwordInput.sendKeys("will");
        loginBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://suite8demo.suiteondemand.com/#/home"));
    }

//    @After
//    public void close(){
//        driver.quit();
//    }
}
