package org.example.Selenium6;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium46 {

    EdgeDriver driver;

    @BeforeTest
    @Description("Open Browser")
    public void openBrowser(){
        driver = new EdgeDriver();
    }

    @Test
    @Description("Test login in OrangeHRM")
    public void testLogin() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(10000);
        WebElement emailInput = driver.findElement(By.xpath("//input[@name='username']"));
        emailInput.sendKeys("Admin");

        Thread.sleep(10000);
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys("admin123");

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        Thread.sleep(10000);

        
    }

    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.quit();
    }


}
