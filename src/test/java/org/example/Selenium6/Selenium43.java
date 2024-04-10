package org.example.Selenium6;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Selenium43 {

    EdgeDriver driver;

    @BeforeTest
    @Description("Open the web browser")
    public void testBrowser(){
        driver = new EdgeDriver();

    }

    @Test
    @Description("iFrame Demo")
    public void iframeDemo() throws InterruptedException {
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");

        Thread.sleep(5000);

        // iframe
        driver.switchTo().frame("result");
        WebElement submitButton = driver.findElement(By.xpath("//form[@id='form']/button"));
        submitButton.click();

        WebElement userInputElement = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement errorElement = driver.findElement(with(By.tagName("small")).below(userInputElement));
        String errorText = errorElement.getText();
        Assert.assertEquals(errorText,"Username must be at least 3 characters");

        Thread.sleep(10000);
    }

    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.quit();  
    }

}
