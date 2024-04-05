package org.example.Selenium5;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium33 {

    EdgeDriver driver;

    @BeforeTest
    @Description("Open the web browser")
    public void testBrowser(){
        driver = new EdgeDriver();

    }

    @Test
    @Description("SpiceJet Demo")
    public void spicejetDemo() throws InterruptedException {
        driver.get("https://www.spicejet.com/");
        // xpath --> //div[@data-testid='to-testID-origin']/div/div/input
        WebElement src = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div/input"));

        Actions actions = new Actions(driver);
        actions.moveToElement(src).perform();
        actions.moveToElement(src).click().sendKeys("DEL");
    }

    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.close();
    }

}
