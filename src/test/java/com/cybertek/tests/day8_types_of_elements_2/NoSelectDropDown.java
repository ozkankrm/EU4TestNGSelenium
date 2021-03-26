package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropDown {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
          driver.quit();
    }

    @Test
    public void test1(){
        driver.get(" http://practice.cybertekschool.com/dropdown");

        //1.locate your dropdown just like only any other webElement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("dropdownMenuLink"));

        //click the dropdown to see available options
        dropdownElement.click();

        //get the options with findElements method and finding common locator between them
        List<WebElement> dropdownOptions = dropdownElement.findElements(By.cssSelector("dropdown-item"));

        System.out.println("dropdownOptions.size() = " + dropdownOptions.size());
        Assert.assertEquals(dropdownOptions.size(),5,"verify size of options");

        //print them one by one
        for (WebElement option : dropdownOptions){
            System.out.println(option.getText());
        }

        //click yahoo
        dropdownOptions.get(2).click();

    }

}
