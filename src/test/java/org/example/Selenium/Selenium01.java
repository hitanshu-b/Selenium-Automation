package org.example.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium01 {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://youtube.com");
        driver.quit();
    }
}
