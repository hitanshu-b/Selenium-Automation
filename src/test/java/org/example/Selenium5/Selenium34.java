package org.example.Selenium5;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium34 {

    EdgeDriver driver;

    @BeforeTest
    @Description("Open the web browser")
    public void testBrowser(){
        driver = new EdgeDriver();

    }

    @Test
    @Description("Action Class Demo")
    public void actionClassDemo() throws InterruptedException {
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        Thread.sleep(4000);

        WebElement element = driver.findElement(By.id("fromCity"));
        Actions action = new Actions(driver);
        action.moveToElement(element).click().sendKeys("New Delhi").build().perform();

        List<WebElement> autoComplete = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));

        for(WebElement e : autoComplete){
            if(e.getText().contains("New Delhi")){
                e.click();
                break;
            }
        }
        Thread.sleep(12000);
    }

    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.close();
    }

}
