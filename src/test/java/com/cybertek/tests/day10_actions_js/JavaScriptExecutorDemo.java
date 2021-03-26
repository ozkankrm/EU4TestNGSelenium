package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.xml.dom.ParentSetter;

public class JavaScriptExecutorDemo {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }
    @Test
    public void clickWithJS(){

        driver.get("http://practice.cybertekschool.com/");

        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click;", dropdownLink);
    }

    @Test
    public void typeWithJS(){

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        //down-casting ile obje oluşturduk
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //inputBox a göndereceğimiz text
        String text = "Hello Disabled Input";
                                                                                    //webelement
        jse.executeScript("arguments[0].setAttribute('value', '" + text + "')", inputBox);

    }

@Test
public void ScrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //scroll down--> 250
    //for daki koşulu değiştirebilirsin
    for (int i = 0; i < 10; i++) {
        Thread.sleep(1000); //zorunlu değil
        jse.executeScript("window.scrollBy(0,250)");

    }

    //scroll Up--> -250
    //for daki koşulu değiştirebilirsin
    for (int i = 0; i < 10; i++) {
        Thread.sleep(1000);//nor mandatory
        jse.executeScript("window.scrollBy(0,-250)");

    }

    }
    @Test
    public void scrollToElement(){

       JavascriptExecutor jse =  (JavascriptExecutor) driver;
    }

}
