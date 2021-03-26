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

public class SelectDropDownTest {

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
        driver.get(" http://practice.cybertekschool.com/dropdown");

        //1.locate your dropdown just like only any other webElement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //2.create Select object by passing that elemetn as a constructor
        //arguman olarak webelementi içine pass ettik
        Select stateDropdown = new Select(dropdownElement);

        //tüm seçenekleri listte depoladı
        //getOptions()-->return all the available options from the dropdown
        List<WebElement> options = stateDropdown.getOptions();

        //listte kaç tane seçenek olduğunu bulmak için size() methodunu kullandık
        //print size of the options
        System.out.println("options.size() = " + options.size());

        // print options one by one
        for(WebElement option : options){
            System.out.println(option.getText());
        }
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get(" http://practice.cybertekschool.com/dropdown");

        //1.locate your dropdown just like only any other webElement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //2.create Select object by passing that elemetn as a constructor
        //arguman olarak webelementi içine pass ettik
        Select stateDropdown = new Select(dropdownElement);

        //verify that first selection is select a state
        String expectedOption = "Select a State";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption, "verify first selection");

        Thread.sleep(3000);
        //HOW TO SELECT OPTIONS FROM DROPDOWN?
        //1. SELECT USİNG VISIBLE TEXT
        stateDropdown.selectByVisibleText("Virginia");

        //verify option selected or not
        expectedOption = "Virgina";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption, "verify first selection");

        //2.SELECT USING INDEX
        Thread.sleep(3000);
        stateDropdown.selectByIndex(51);

        expectedOption = "Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption, "verify first selection");

        //3. SELECT BY VALUE
        stateDropdown.selectByValue("TX");

        expectedOption = "Texas";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption, "verify first selection");






    }
}
