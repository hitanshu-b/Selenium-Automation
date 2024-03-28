package org.example.Selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium17 {
    // CSS Selectors

    @Test
    public void testCssSelector() throws InterruptedException {

//        EdgeOptions options = new EdgeOptions();
//        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.ebay.com/b/PC-Desktops-All-In-One-Computers/179/bn_661752");

        Thread.sleep(3000);

        WebElement element = driver.findElement(By.cssSelector("input[type='text']"));
        element.sendKeys("mac");

        WebElement element1 = driver.findElement(By.cssSelector("input[type='submit']"));
        element1.click();

        Thread.sleep(2000);

        List<WebElement> elementList = driver.findElements(By.cssSelector("span[role='heading']"));
        for(int i=0; i<elementList.size() ;i++){
            System.out.println(elementList.get(i).getText());
        }

        driver.quit();
    }
}
