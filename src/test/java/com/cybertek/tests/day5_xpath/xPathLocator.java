package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class xPathLocator {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

      // WebElement findButton1 = driver.findElement(By.xpath("//*[@onclick='button1()']")).click();
        //findButton1.click();

        // go to button 1 and click
        driver.findElement(By.xpath("//button[@onclick='button1()']")).click();

        Thread.sleep(4000);

        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//img[@id='image']")).click();

       // driver.quit();
    }
}
