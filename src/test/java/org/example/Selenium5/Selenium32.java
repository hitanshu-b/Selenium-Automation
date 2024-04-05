package org.example.Selenium5;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium32 {

    EdgeDriver driver;

    @BeforeTest
    @Description("Open the web browser")
    public void testBrowser(){
        driver = new EdgeDriver();

    }

    @Test
    @Description("shadowDOM Demo")
    public void shadowDOM() throws InterruptedException {

        driver.get("https://awesomeqa.com/practice.html");
        driver.manage().window().maximize();
//        driver.findElement(By.name("firstname")).sendKeys("Cristiano");

        WebElement firstName = driver.findElement(By.name("firstname"));

        Actions action = new Actions(driver);
        action.keyDown(Keys.SHIFT)
                .sendKeys(firstName, "Cristiano")
                .keyUp(Keys.SHIFT).build().perform();

        WebElement link = driver.findElement(By.xpath("//a[contains(text(),\"Click here\")]"));
        action.contextClick(link).build().perform();
    }

    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.close();
    }

}
