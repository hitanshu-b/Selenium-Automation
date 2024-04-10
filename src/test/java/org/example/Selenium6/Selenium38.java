package org.example.Selenium6;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium38 {

    EdgeDriver driver;

    @BeforeTest
    @Description("Open the web browser")
    public void testBrowser(){
        driver = new EdgeDriver();

    }

    @Test
    @Description("File Upload Demo")
    public void fileUploadDemo() throws InterruptedException {
        driver.get("https://awesomeqa.com/selenium/upload.html");
//        driver.manage().window().maximize();
        WebElement uploadFile = driver.findElement(By.id("fileToUpload"));
        String dir = System.getProperty("user.dir");
        uploadFile.sendKeys(dir+"\\src\\test\\java\\org\\example\\Selenium6\\abc.txt");
        driver.findElement(By.name("submit")).click();

        // Download File
        // Can be checked via ChromeOptions
        // Problem : Download a file and check in the dir if that is present
        // ChromeOptions --> dir(Doc)
        // Check if file exists

    }

    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.close();
    }

}
