package com.cybertek.tests.reviews.week3_;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;

public class moreDropdown {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //  driver.quit();
    }


    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dropdown");

        //locate the dropdown with name
        WebElement dropdownElement = driver.findElement(By.cssSelector("[name = 'Languages']"));

        //2. create Select object
        Select langDropdown = new Select(dropdownElement);

        //get the default selection
       // System.out.println("Selected: " +langDropdown.getFirstSelectedOption().getText());


        //selected second
        langDropdown.selectByIndex(1);
        System.out.println("Selected: " +langDropdown.getFirstSelectedOption().getText());

        //which programing languages do you know? gibi birden çok select yapılacak dropdownlarda aynı anda birden falza
        //seçenek işarelenebilir. Bunu 3 yolla seçebiliriz.1 selectByIndex() 2.selectByValue() 3.selectByVisibleText()

        langDropdown.selectByIndex(0);
        langDropdown.selectByIndex(3);
        langDropdown.selectByIndex(4);

        //get all selected options-->getAllSelectedOptions()
        List<WebElement> allSelectedOptions =langDropdown.getAllSelectedOptions();
        for (WebElement option : allSelectedOptions) {
            System.out.println(option.getText());
        }

        //deselectAll()--> seçilmiş seçenekleri kaldırır.
       // langDropdown.deselectAll();










    }
}
