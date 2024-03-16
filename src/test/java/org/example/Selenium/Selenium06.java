package org.example.Selenium;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Selenium06 {
    public static void main(String[] args) {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("121.40.185.42:1080");
        edgeOptions.setCapability("proxy", proxy);

        WebDriver driver = new EdgeDriver();
        driver.get("https://youtube.com");
    }
}
