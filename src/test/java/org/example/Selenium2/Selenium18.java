package org.example.Selenium2;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium18 {
    EdgeDriver driver;

    @BeforeTest
    @Description("Script to open the browser")
    public void testBrowser(){
        driver = new EdgeDriver();
    }
    @Test
    @Description("Positive TC for Login with Valid Inputs")
    public void testDemo(){
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
    }
    @Test
    @Description("Negative TC for login with Invalid Inputs")
    public void testDemo1(){
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
    }
    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.close();
    }
}
