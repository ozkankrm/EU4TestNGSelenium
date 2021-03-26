package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");


        WebElement usernameInput = driver.findElement(By.cssSelector("#username"));

       // usernameInput.sendKeys("hello");// displayed elemente bir şey gönderemezsin

        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());

        //TASK
        //verify username inputbox is not displayed on the screen
        Assert.assertFalse(usernameInput.isDisplayed(),"verify inputbox is NOT displayed");
        //find start button and click start button
        driver.findElement(By.cssSelector("#start>button")).click();
        Thread.sleep(6000);
        //verify username displayed on the screen
        Assert.assertTrue(usernameInput.isDisplayed(),"verify username inputbox is displayed");
        Thread.sleep(3000);
        driver.quit();


    }



}
