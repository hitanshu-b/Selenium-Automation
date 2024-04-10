package org.example.Selenium6;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium36 {

    EdgeDriver driver;

    @BeforeTest
    @Description("Open the web browser")
    public void testBrowser(){
        driver = new EdgeDriver();

    }

    @Test
    @Description("Action Class Demo")
    public void actionClassDemo() throws InterruptedException {
        driver.get("https://www.makemytrip.com/");

        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();

    }

    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.close();
    }

}
