package org.example.Selenium1;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium11 {
    @Test(groups = "QA")
    @Description("Verfiy the current URl, title of VWO app")
    public void testVWOLogin(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

        // <input type="email" class="text-input W(100%)" name="username" id="login-username" data-qa="hocewoqisi">
        WebElement emailInput = driver.findElement(By.id("login-username"));
        emailInput.sendKeys("admin@admin.com");

        // <input type="password" class="text-input W(100%)" name="password" id="login-password" data-qa="jobodapuxe">
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("admin");

        // <button type="submit" id="js-login-btn" class="btn btn--positive btn--inverted W(100%) H(48px) Fz(16px)"
        // onclick="login.login(event)"
        // data-qa="sibequkica">
        driver.findElement(By.id("js-login-btn")).click();

        // hold the program as it is not passing the test case due to fast execution
        // this is not the good practice
        // we will replace it with selenium wait()
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // <div class="notification-box-description"
        // id="js-notification-box-msg" data-qa="rixawilomi">
        // Your email, password, IP address or location did not match</div>
        WebElement errorMsg = driver.findElement(By.className("notification-box-description"));
        String error_msg = errorMsg.getText();
        Assert.assertEquals(error_msg, "Your email, password, IP address or location did not match");

        driver.quit();


    }
}
