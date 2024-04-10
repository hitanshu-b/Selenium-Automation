package org.example.Selenium6;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class Selenium39 {

    EdgeDriver driver;

    @BeforeTest
    @Description("Open the web browser")
    public void testBrowser(){
        driver = new EdgeDriver();

    }

    @Test
    @Description("Windows Demo")
    public void windowDemo() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        String windowHandle = driver.getWindowHandle();
        System.out.println("Before: "+windowHandle);
        // xpath => //a[@href="/windows/new"]
        // we can simply use link text for the same
        // By.linkText("Click Here")
        WebElement clickLink = driver.findElement(By.linkText("Click Here"));
        clickLink.click();
        Set<String> windowSet = driver.getWindowHandles();
        // It will give all the windows tab with unique name
        for(String e : windowSet){
            driver.switchTo().window(e);
            System.out.println(e);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("Passed");
            }
        }

        driver.switchTo().window(windowHandle);
        Thread.sleep(2000);
    }

    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.quit();
    }

}
