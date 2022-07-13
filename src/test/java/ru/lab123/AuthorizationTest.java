package ru.lab123;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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


}
