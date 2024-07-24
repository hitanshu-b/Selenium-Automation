package org.example.Selenium6;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium45 {

    @Test
    @Description("Automating user registration for an E-commerce website")
    public void testUserReg(){
        WebDriver driver = new EdgeDriver();
//        WebDriver driver1 = new ChromeDriver();
        driver.get("https://www.ebay.com/");

        WebElement clickReg = driver.findElement(By.linkText("register"));
        clickReg.click();

        WebElement clickPersonal = driver.findElement(By.xpath("//label[@for=\"personalaccount-radio\"]"));
        clickPersonal.click();

        WebElement enterFirst = driver.findElement(By.xpath("//input[@id=\"firstname\"]"));
        enterFirst.sendKeys("Temp");

        WebElement enterLastName = driver.findElement(By.xpath("//input[@id=\"lastname\"]"));
        enterLastName.sendKeys("User");

        WebElement enterEmail = driver.findElement(By.xpath("//input[@id=\"Email\"]"));
        enterEmail.sendKeys("tempuser@gmail.com");

        WebElement enterpassword = driver.findElement(By.xpath("//input[@id=\"password\"]"));
        enterpassword.sendKeys("Qwerty@123");

        WebElement clickAction = driver.findElement(By.xpath("//button[@id=\"EMAIL_REG_FORM_SUBMIT\"]"));
        clickAction.click();

        driver.close();

    }
}

