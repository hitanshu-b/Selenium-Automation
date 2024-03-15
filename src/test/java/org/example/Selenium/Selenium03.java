package org.example.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class Selenium03 {

    @Test
    public void testMethod(){
        EdgeOptions edgeOptions = new EdgeOptions();
        //edgeOptions.addExtensions(new File(""));
        edgeOptions.addArguments("--headless");
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.youtube.com");
    }
}
