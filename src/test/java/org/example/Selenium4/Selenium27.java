package org.example.Selenium4;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium27 {

    EdgeDriver driver;

    @BeforeTest
    @Description("Open the web browser")
    public void testBrowser(){
        driver = new EdgeDriver();

    }

    @Test
    @Description("Webtables")
    public void testWebtables() throws InterruptedException {
        driver.get("https://awesomeqa.com/webtable.html");
        // xpath --> //*[@id="customers"]/tbody/tr[5]/td[2] --> Halen Bennette
        // /following-sibling::td - country she belongs to

        // P.S : Print all the data in the table and if name is Halen = provide country name
        String first = "//*[@id=\"customers\"]/tbody/tr[";
        String second = "]/td[";
        String third = "]";

        int row = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[2]/td")).size();

        for (int i = 2; i < row; i++) {
            for (int j = 1; j < col; j++) {
                String dynamicPath = first+i+second+j+third;
                String data = driver.findElement(By.xpath(dynamicPath)).getText();
                System.out.println(data);
                if(data.contains("Helen Bennett")){
                    String countryPath = dynamicPath+"/following-sibling::td";
                    String countryText = driver.findElement(By.xpath(countryPath)).getText();
                    System.out.println("Helen Bennett is in " +countryText);
                }
            }
        }
    }

    @AfterTest
    @Description("Close the browser")
    public void closeBrowser(){
        driver.close();
    }

}
