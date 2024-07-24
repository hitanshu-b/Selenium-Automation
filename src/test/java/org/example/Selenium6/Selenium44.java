package org.example.Selenium6;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Selenium44 {

    @Test
    @Description("Automating user registration for an E-commerce website")
    public void testUserReg(){
        WebDriver driver = new EdgeDriver();
//        WebDriver driver1 = new ChromeDriver();
        driver.get("https://www.amazon.in/");

        // //a[@id="nav-link-accountList"]
        WebElement hoverElement = driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]"));
        hoverElement.click();

        // //a[@id="createAccountSubmit"]
        WebElement createEle = driver.findElement(By.xpath("//a[@id=\"createAccountSubmit\"]"));
        createEle.click();

        // //input[@id="ap_customer_name"]
        WebElement nameEle = driver.findElement(By.xpath("//input[@id=\"ap_customer_name\"]"));
        nameEle.sendKeys("Temporary User");

        // //input[@id="ap_phone_number"]
        WebElement phoneEle = driver.findElement(By.xpath("//input[@id=\"ap_phone_number\"]"));
        phoneEle.sendKeys("9876543210");

        WebElement passwordEle = driver.findElement(By.xpath("//input[@id=\"ap_password\"]"));
        passwordEle.sendKeys("Qwerty@123");

    }
}
