package org.example.Selenium6;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Selenium42 {

    EdgeDriver driver;

    @BeforeTest
    @Description("Open the web browser")
    public void testBrowser(){
        driver = new EdgeDriver();

    }

    @Test
    @Description("Relative Locators")
    public void relativeLocatorsDemo() throws InterruptedException {
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");

        Thread.sleep(10000);

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search_city']"));
        searchBox.sendKeys("India"+ Keys.ENTER);
        List<WebElement> tableData = driver.findElements(By.xpath("//table[@id='example']/tbody/tr[3]/td[2]"));
        for (WebElement e : tableData){
            String s1 = driver.findElement(with(By.tagName("p")).toRightOf(e)).getText();
            String s2 = driver.findElement(with(By.tagName("p")).toLeftOf(e)).getText();
            String s3 = driver.findElement(with(By.tagName("p")).below(e)).getText();
            String s4 = driver.findElement(with(By.tagName("p")).above(e)).getText();
            System.out.println(e.getText() +"-->" + s1 + "-->" +s2);
            System.out.println(e.getText() +"-->" + s3 + "-->" +s4);
        }

        Thread.sleep(10000);
    }

    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.quit();  
    }

}
