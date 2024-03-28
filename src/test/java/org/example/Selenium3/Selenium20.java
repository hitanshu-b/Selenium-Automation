package org.example.Selenium3;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Selenium20 {
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
    @Description("Explicit waits")
    public void testWaits2() throws InterruptedException {
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("hitanshu.developement@gmail.com");
        driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("qwerty@123");
        driver.findElement(By.xpath("//button[@id='js-login-btn']")).click();

//        Thread.sleep(3000);
        WebElement errorMsg = driver.findElement(By.xpath("//div[@id='js-notification-box-msg']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.textToBePresentInElement(errorMsg,"Your email, password, IP address or location did not match"));

        // Error Message
        System.out.println(errorMsg.getText());
    }

    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.close();
    }


}
