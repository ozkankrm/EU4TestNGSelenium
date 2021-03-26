package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //locating radio buttons
        WebElement blueRadioBtn = driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioBtn = driver.findElement(By.cssSelector("#red"));

        // how to check radio button is selected?
        System.out.println("blueRadioBtn.isSelected() = " + blueRadioBtn.isSelected());
        System.out.println("redRadioBtn.isSelected() = " + redRadioBtn.isSelected());

        //verify blue is selected red is not selected
        //blue-->true
        Assert.assertTrue(blueRadioBtn.isSelected(),"verify blue is selected");
        //red-->
        Assert.assertFalse(redRadioBtn.isSelected(), "verify red is NOT selected");

        //how to click radio button
        driver.findElement(By.cssSelector("#yellow")).click();
        Thread.sleep(3000);
        redRadioBtn.click();

        //radio button seçildikten sonra seçilip seçilmediğinden emin olmak için ayı adımı bir daha uyguluyoruz
        //red click yaptıktan sonra casemiz de değişti blue-->false, red-->true olacak
        //blue-->false
        Assert.assertFalse(blueRadioBtn.isSelected(),"verify blue is selected");
        //red-->true
        Assert.assertTrue(redRadioBtn.isSelected(), "verfiy red is NOT selected");

        Thread.sleep(3000);
        driver.quit();

    }
}
