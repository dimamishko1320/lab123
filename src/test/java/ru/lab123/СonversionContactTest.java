package ru.lab123;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class СonversionContactTest extends WebDriverSettings{

    @Test
    public void createContact(){
        authorizate();
        driver.get("https://suite8demo.suiteondemand.com/#/leads/edit?return_module=Leads&return_action=DetailView");
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//scrm-button-group/div/scrm-button[1]/button"))));
        WebElement nameInput = driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div[1]/scrm-field/scrm-dynamic-field/scrm-group-field/div/div[3]/span[2]/scrm-dynamic-field/scrm-varchar-edit/input"));
        WebElement phoneInput = driver.findElement(By.xpath("//scrm-field-layout/form/div[1]/div[2]/div[2]/div[1]/scrm-field/scrm-dynamic-field/scrm-varchar-edit/input"));
        WebElement saveBtn = driver.findElement(By.xpath("//scrm-button-group/div/scrm-button[1]/button"));
        String name = "Dima";
        String officePhone = "89088888820";
        nameInput.sendKeys(name);
        phoneInput.sendKeys(officePhone);
        saveBtn.click();
        wait.until(ExpectedConditions.urlContains("https://suite8demo.suiteondemand.com/#/leads/record/"));
        WebElement phoneSaved = driver.findElement(By.cssSelector("scrm-phone-detail"));
        Assert.assertEquals(phoneSaved.getText(), officePhone);
        WebElement nameSaved = driver.findElement(By.className("dynamic-field-name-last_name"));
        Assert.assertEquals(nameSaved.getText(), name);
    }
}
