package org.example.Selenium3;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium22 {
    // waits
    EdgeDriver driver;

    @BeforeTest
    @Description("Open the web browser")
    public void testBrowser(){
        driver = new EdgeDriver();
    }

//    @Test
//    @Description("Implicit waits")
//    public void testWaits(){
//        driver.get("https://app.vwo.com");
//        driver.manage().window().maximize();
////         Implicit waits
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }

    @Test
    @Description("Fluent waits")
    public void testWaits2() throws InterruptedException {
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("hitanshu.developement@gmail.com");
        driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("Qwerty@123");
        driver.findElement(By.xpath("//button[@id='js-login-btn']")).click();

        Wait<EdgeDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }

    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.close();
    }


}
