package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestCase02 {

    @Test
    @Description("Verify title of app.vwo.com")
    public void vwoLogin(){
        WebDriver driver = new EdgeDriver();
//        WebDriver driver1 = new ChromeDriver();

        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
    }
}
