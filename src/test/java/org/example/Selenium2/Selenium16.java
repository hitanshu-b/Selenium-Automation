package org.example.Selenium2;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium16 {
    @Test
    @Description("Automating Katalon Website with Selenium")
    public void testKatalon() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        // <a
        // id="btn-make-appointment"
        // href="./profile.php#login"
        // class="btn btn-dark btn-lg">Make Appointment
        // </a>

        WebElement buttonID = driver.findElement(By.id("btn-make-appointment"));

        buttonID.click();

        Thread.sleep(2000);

        // Assert that it is going to this page https://katalon-demo-cura.herokuapp.com/profile.php#login
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");

        WebElement userName = driver.findElement(By.xpath("//input[@id=\"txt-username\"]"));
        userName.sendKeys("John Doe");

        WebElement passWord = driver.findElement(By.xpath("//input[@id=\"txt-password\"]"));
        passWord.sendKeys("ThisIsNotAPassword");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id=\"btn-login\"]"));
        loginButton.click();
    }
}
