package org.example.Selenium4;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium28 {

    EdgeDriver driver;

    @BeforeTest
    @Description("Open the web browser")
    public void testBrowser(){
        driver = new EdgeDriver();

    }

    @Test
    @Description("Webtables1")
    public void testWebtables() throws InterruptedException {
        driver.get("https://awesomeqa.com/webtable1.html");
        WebElement element = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));
        List<WebElement> rows = element.findElements(By.tagName("tr"));
        System.out.println(rows.size());

        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            for(WebElement e : cols){
                System.out.println(e.getText());
            }
        }
    }

    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.close();
    }

}
