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

public class Selenium37 {

    EdgeDriver driver;

    @BeforeTest
    @Description("Open the web browser")
    public void testBrowser(){
        driver = new EdgeDriver();

    }

    @Test
    @Description("Action Class Demo")
    public void actionClassDemo() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
//        driver.manage().window().maximize();

        Actions action = new Actions(driver);
        WebElement fromA = driver.findElement(By.id("column-a"));
        WebElement toB = driver.findElement(By.id("column-b"));

//        action.dragAndDrop(fromA,toB).perform();

        // Alternate Way
        action.clickAndHold(fromA).moveToElement(toB).release(toB).build().perform();
        Thread.sleep(4000);

    }

    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.close();
    }

}
