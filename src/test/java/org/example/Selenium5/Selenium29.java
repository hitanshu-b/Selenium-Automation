package org.example.Selenium5;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium29 {

    EdgeDriver driver;

    @BeforeTest
    @Description("Open the web browser")
    public void testBrowser(){
        driver = new EdgeDriver();

    }

    @Test
    @Description("SVG Demo")
    public void svgDemo() throws InterruptedException {
        driver.get("https://www.flipkart.com");
        // xpath --> //*[local-name()='svg']/*[local-name()='path']
        // xpath1 --> //*local-name()='svg'][1]
        driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("iphone15");

        List<WebElement> svgElements = driver.findElements(By.xpath("//*[local-name()='svg']"));
        svgElements.get(0).click();
//        for(WebElement element : svgElements){
//            System.out.println(element.getText());
//        }
    }

    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.close();
    }

}
