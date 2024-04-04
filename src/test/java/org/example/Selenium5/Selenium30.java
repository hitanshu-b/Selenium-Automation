package org.example.Selenium5;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium30 {

    EdgeDriver driver;

    @BeforeTest
    @Description("Open the web browser")
    public void testBrowser(){
        driver = new EdgeDriver();

    }

    @Test
    @Description("SVG Demo")
    public void svgDemo() throws InterruptedException {
        driver.get("https://www.amcharts.com/svg-maps/?map=india");
        // xpath --> //*[local-name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path'] --> 36 states

        List<WebElement> states = driver.findElements(By.xpath("//*[local-name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));
        for(WebElement s : states){
            System.out.println(s.getAttribute("aria-label"));
            if(s.getAttribute("aria-label").contains("Tripura")){
                s.click();
            }
        }
        Thread.sleep(30000);

    }

    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.close();
    }

}
