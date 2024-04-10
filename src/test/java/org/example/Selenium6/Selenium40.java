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

public class Selenium40 {

    EdgeDriver driver;

    @BeforeTest
    @Description("Open the web browser")
    public void testBrowser(){
        driver = new EdgeDriver();

    }

    @Test
    @Description("Windows Demo")
    public void windowDemo() throws InterruptedException {
        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");

        String windowHandle = driver.getWindowHandle();
        System.out.println("Before: "+windowHandle);

        Actions ac = new Actions(driver);
        ac.moveToElement(driver.findElement(By.xpath("//div[@data-qa=\"meqeqiwiwe\"]"))).click();

        Set<String> windowManager = driver.getWindowHandles();
        System.out.println(windowManager);

        for(String e : windowManager){
            driver.switchTo().window(e);
            System.out.println(e);
        }
        if(driver.getPageSource().contains("New Window")){
            System.out.println("Passed");
        }
        driver.switchTo().window(windowHandle);
        Thread.sleep(4000);

    }

    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.quit();  
    }

}
