package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class linkTextAndPartialLinkText {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://practice.cybertekschool.com/dynamic_loading");

        //linkin tıklanacak yerdeği değeri alıyoruz ve değerin hepsini alıyoruz
        WebElement link1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));

        //link1.click();

        //partialLİnkText te linkin unique olacak şekilde bir parçasını alıyoruz
        WebElement link4 = driver.findElement(By.partialLinkText("Example 4"));
        link4.click();
    }
}
