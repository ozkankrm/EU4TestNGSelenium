package com.cybertek.exercise;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MT_Check {
    //Test case 2
    //Go to Ebay
    //search Selenium
    //click on search button
    //verify title contains Selenium
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://www.ebay.com");

        Thread.sleep(2000);

        WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
        search.sendKeys("selenium");

        WebElement searchBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        searchBtn.click();

        String title = driver.getTitle().toLowerCase();

        System.out.println("title = " + title);

        String verifySelenium = "selenium";

        if(title.contains(verifySelenium.toLowerCase())){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        Thread.sleep(2000);
        driver.quit();


    }
}
