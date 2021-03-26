package com.cybertek.exercise;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TypeOfElement {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
/*
        driver.get("https://www.flashscore.com.tr/");

        driver.findElement(By.xpath("//div[text() = 'Basketbol'][1]")).click();

        Thread.sleep(4000);

        driver.findElement(By.xpath("//*[@id=\"my-leagues-list\"]/li[7]/a")).click();

        driver.quit();
        */

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement footballBox = driver.findElement(By.id("football"));

        footballBox.isSelected();

        //verify footballBox not selected
        Assert.assertFalse(footballBox.isSelected(),"verfy footballbox is not selected");

        footballBox.click();

        Assert.assertTrue(footballBox.isSelected(), "verfiy footballbox is selected");
        System.out.println("footballBox = " + footballBox.isSelected());

        driver.findElement(By.cssSelector("#water_polo")).click();


        Thread.sleep(3000);

        driver.quit();


    }
}
