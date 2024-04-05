package org.example.Selenium5;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium31 {

    EdgeDriver driver;

    @BeforeTest
    @Description("Open the web browser")
    public void testBrowser(){
        driver = new EdgeDriver();

    }

    @Test
    @Description("shadowDOM Demo")
    public void shadowDOM() throws InterruptedException {

        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();
        // document.querySelector("div#userName").shadowRoot.querySelector("div").shadowRoot.querySelector("input#pizza")

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // For Scrolling
        WebElement divScroll = driver.findElement(By.xpath("//div[@id='userName']"));
        js.executeScript("arguments[0].scrollIntoView(true);",divScroll);

        Thread.sleep(3000);

        WebElement e = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div\").shadowRoot.querySelector(\"input#pizza\")");
        e.sendKeys("PeppyPaneer");
    }

    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.close();
    }

}
