package org.example.Selenium6;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Selenium41 {

    EdgeDriver driver;

    @BeforeTest
    @Description("Open the web browser")
    public void testBrowser(){
        driver = new EdgeDriver();

    }

    @Test
    @Description("Relative Locators")
    public void relativeLocatorsDemo() throws InterruptedException {
        driver.get("https://awesomeqa.com/practice.html");
        // xpath --> //span[.='Years of Experience']
        WebElement spanElement = driver.findElement(By.xpath("//span[.='Years of Experience']"));
        driver.findElement(with(By.id("exp-0")).toRightOf(spanElement)).click();

        Thread.sleep(5000);

    }

    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.quit();  
    }

}
