package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.apache.hc.core5.http.nio.AsyncServerExchangeHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class HoverTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
       // driver.quit();
    }
    /*
    hover over each image in the website
    verify each name: user text is displayed
     */

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));

        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(img1).perform();

        WebElement text1 = driver.findElement(By.xpath("//h5[.='name: user1']"));

        Assert.assertTrue(text1.isDisplayed(), "verfiy text 1 is displayed");

      //  Assert.assertEquals(text1.isDisplayed(), true);

    }
    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");

        //for ile dynamic hale getirdik ve i kullanarak
        for (int i = 1; i <= 3; i++) {

            String xpathImg = "(//img)["+i+"]";
            WebElement img = driver.findElement(By.xpath(xpathImg));

            System.out.println(xpathImg);
            //(//img)[1]
            //(//img)[2]
            //(//img)[3]

            Actions actions = new  Actions(driver);
            Thread.sleep(2000);
            actions.moveToElement(img).perform();

            String textXpath = "//h5[.='name: user"+1+"']";
            WebElement textImg = driver.findElement(By.xpath(textXpath));
            System.out.println(textXpath);
            Assert.assertTrue(textImg.isDisplayed(), "verfiy text" +i+" is displayed");

        }


        /*
        Actions actions = new  Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(img1).perform();

        WebElement text1 = driver.findElement(By.xpath("//h5[.='name: user1']"));

        Assert.assertTrue(text1.isDisplayed(), "verfiy text 1 is displayed");

        List<WebElement> list = (List<WebElement>) driver.findElement(By.tagName("h5"));

        for (WebElement webElement : list) {

            System.out.println(webElement.getText());

        }
        */
    }
}
