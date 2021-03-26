package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Ebay2_Test {

    /*
    Test case 2

    Go to Ebay
    search Selenium
    click on search button
    verify title contains Selenium
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com");

        driver.manage().window().maximize();

        WebElement searchSelenium = driver.findElement(By.xpath("//*[@id='gh-ac']"));
        searchSelenium.sendKeys("selenium");

        driver.findElement(By.xpath("//input[@value='Search']")).click();
        driver.getTitle();

        System.out.println(driver.getTitle());

        if (driver.getTitle().toLowerCase().contains("selenium")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println(driver.getTitle());
        }


    }

}