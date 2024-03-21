package org.example.Selenium1;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium13 {

    @Test
    @Description("To Check all the tag names")
    public void testByTag(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");

        // Question: Print all the anchor tags present in app.vwo.com source code
        List <WebElement> allAnchorTags = driver.findElements(By.tagName("a"));
        // if we want to click the 1st link of all the available links
        //allAnchorTags.get(0).click(); // start a free trail
        allAnchorTags.get(1).click(); // VWO Insights
        for(WebElement element : allAnchorTags){
            System.out.println(element.getText());
        }

        driver.close();
    }

}
