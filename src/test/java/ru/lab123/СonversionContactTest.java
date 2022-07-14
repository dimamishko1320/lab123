package ru.lab123;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

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
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("scrm-phone-detail")));
        WebElement phoneSaved = driver.findElement(By.cssSelector("scrm-phone-detail"));
        Assert.assertEquals(phoneSaved.getText(), officePhone);
        WebElement nameSaved = driver.findElement(By.className("dynamic-field-name-last_name"));
        Assert.assertEquals(nameSaved.getText(), name);
        WebElement actionBtn = driver.findElement(By.cssSelector("scrm-dropdown-button > div > button"));
        actionBtn.click();
        WebElement convertLeadBtn = driver.findElement(By.cssSelector(" a:nth-child(5) > div > div"));
        convertLeadBtn.click();
        WebElement frame = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/scrm-classic-view-ui/div/iframe")));
        driver.switchTo().frame(frame);
        WebElement createCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='newContacts']")));
        createCheckbox.click();

        WebElement selectContact = driver.findElement(By.xpath("//*[@id='btn_report_to_name']"));
        selectContact.click();
        String parentHandle = driver.getWindowHandle();
        for(String childHandle : driver.getWindowHandles()){
            if (!childHandle.equals(parentHandle)){
                driver.switchTo().window(childHandle);
            }
        }
        driver.findElement(By.xpath(" //*[@id='search_form_clear']")).click();
        driver.findElement(By.xpath(" //*[@id='lead_source_advanced']/option[2]")).click();
        driver.findElement(By.xpath("  //*[@id='search_form_submit']")).click();
        driver.findElement(By.xpath("/html/body/table[4]/tbody/tr[1]/td[1]/a")).click();
        driver.switchTo().window(parentHandle);
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//*[@id='Accountsname']")).sendKeys("Dimaaaa");
        driver.findElement(By.xpath("//*[@id='SAVE_HEADER']")).click();
        if(driver.getPageSource().contains("account record that already exists")){
            driver.findElement(By.xpath("//*[@id='dupAccounts']/table[2]/tbody/tr[1]/td/table/tbody/tr/td/input")).click();
        }
        driver.findElement(By.xpath("//*[@id='pagecontent']/div/ul/li[1]/a")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement checkName = driver.findElement(By.cssSelector("a[href*='accounts/record']"));
                 //div/scrm-field-layout/form/div[6]/div/div[2]/div[1]/scrm-field/scrm-dynamic-field/a/scrm-relate-detail
        Assert.assertEquals(checkName.getText(), "Dimaaa");




    }
}
