package org.example.Selenium;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Selenium05 {
    public static void main(String[] args) {
        EdgeOptions edgeOptions = new EdgeOptions();
        //edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--window-size=800,600");
        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
        edgeDriver.get("https://youtube.com");
        System.out.println(edgeDriver.getTitle());

        // Another way to maximize
        edgeDriver.manage().window().maximize();
        edgeDriver.quit();
    }
}
