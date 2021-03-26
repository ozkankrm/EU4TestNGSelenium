package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IDLocatorTest {

    public static void main(String[] args) {

        //http://practice.cybertekschool.com/multiple_buttons

        WebDriver deriver = WebDriverFactory.getDriver("chrome");

        deriver.get("http://practice.cybertekschool.com/multiple_buttons");

        //click don't click button
        WebElement dontClickButton = deriver.findElement(By.id("disappearing_button"));

        dontClickButton.click();

        deriver.quit();
    }
}
