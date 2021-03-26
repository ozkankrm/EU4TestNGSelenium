package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest {
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
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));

        //Actions class that contains all the user interactions
        //how to create actions object-->passing driver as a constructor
        Actions actions = new Actions(driver);

        //perform()--> perform the action
        //moveToElement()-->move you mouse to webelement(hover over)
        Thread.sleep(3000);
        actions.moveToElement(img1).perform();

        WebElement viewLink = driver.findElement(By.linkText("View profile"));
        Assert.assertTrue(viewLink.isDisplayed(),"verify viewLink displayed");

    }
    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("http://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));//drag ve drop yapılacak element
        WebElement target = driver.findElement(By.id("droptarget"));

        //if you see "accept and close" message use this
        driver.findElement(By.xpath("//*[.='Accept and Close']")).click();
        Thread.sleep(2000);
        actions.dragAndDrop(source,target).perform();//iki paramaeter alır; source, target


    }
    @Test
    public  void dragAndDropChaining() throws InterruptedException {

        driver.get("http://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));//drag ve drop yapılacak element
        WebElement target = driver.findElement(By.id("droptarget"));

        //if you see "accept and close" message use this
        driver.findElement(By.xpath("//*[.='Accept and Close']")).click();
        Thread.sleep(2000);

        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();
    }

}
