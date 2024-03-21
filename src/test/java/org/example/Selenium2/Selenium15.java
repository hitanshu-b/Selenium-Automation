package org.example.Selenium2;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium15 {

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

//        WebElement buttonID = driver.findElement(By.id("btn-make-appointment"));
//
//        WebElement buttonClass = driver.findElement(By.className("btn.btn-dark.btn-lg"));
//
//        WebElement buttonPartialLink = driver.findElement(By.partialLinkText("Make"));
//
//        WebElement buttonLink = driver.findElement(By.linkText("Make Appointment"));

        WebElement buttonXpath = driver.findElement(By.xpath("//a[@href='./profile.php#login']"));
        buttonXpath.click();

        Thread.sleep(2000);

        // Assert that it is going to this page https://katalon-demo-cura.herokuapp.com/profile.php#login
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");

        // To fill in the details in the input box

        // <input type="text"
        // class="form-control"
        // id="txt-username"
        // name="username"
        // placeholder="Username"
        // value=""
        // autocomplete="off">

        WebElement userName = driver.findElement(By.xpath("//input[@id=\"txt-username\"]"));
        userName.sendKeys("John Doe");

        // <input type="password"
        // class="form-control"
        // id="txt-password"
        // name="password"
        // placeholder="Password"
        // value=""
        // autocomplete="off">

        WebElement passWord = driver.findElement(By.xpath("//input[@id=\"txt-password\"]"));
        passWord.sendKeys("ThisIsNotAPassword");

        // <button id="btn-login" type="submit" class="btn btn-default">Login</button>

        WebElement loginButton = driver.findElement(By.xpath("//button[@id=\"btn-login\"]"));
        loginButton.click();

    }
}
