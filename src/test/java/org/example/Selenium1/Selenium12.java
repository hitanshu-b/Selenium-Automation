package org.example.Selenium1;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium12 {
    // link text
    // partial link text

    @Test(groups = "QA")
    @Description("Verify the Sign IN via URL is working")
    public void testURL(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");

        // <a href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
        // class="text-link"
        // data-qa="bericafeqo">Start a free trial</a>

        // By link Text
        //WebElement getLinkText = driver.findElement(By.linkText("Start a free trial"));

        // By Partial Link Text
        WebElement getPartialLink = driver.findElement(By.partialLinkText("Start a free"));
        getPartialLink.click();

        System.out.println(getPartialLink.getAttribute("href"));
        getPartialLink.click();

        driver.close();
    }

}
