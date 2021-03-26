package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Ebay1_Test {
    /*

Go to Ebay
enter search term
click on search button
print number of results
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.ebay.com");

        WebElement findSearchButton = driver.findElement(By.xpath("//*[@id='gh-ac-box2']/input[@type='text']"));

        findSearchButton.sendKeys("term");
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
        System.out.println(driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']")).getText());


    }
}
