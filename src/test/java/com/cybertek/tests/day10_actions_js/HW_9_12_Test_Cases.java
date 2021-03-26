package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HW_9_12_Test_Cases {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();

    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {

        Thread.sleep(3000);
        //driver.quit();
    }
    /*
    Test case #9
Step 1. Go to “https://practicecybertekschool.
herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “200”.
Step 4. Verify that following message is displayed: “This page returned a 200 status code”
     */
    @Test
    public void test9(){

        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        //Step 2. And click on “Status Codes”.

        //Step 3. Then click on “200”.
        driver.findElement(By.linkText("200")).click();
        //Step 4. Verify that following message is displayed: “This page returned a 200 status code”
        String msg = driver.findElement(By.tagName("p")).getText();
        boolean contains = msg.contains("This page returned a 200 status code");
        Assert.assertTrue(contains);

    }
    /*
    Test case #10
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “301”.
Step 4. Verify that following message is displayed: “This page returned a 301 status code”
     */
    @Test
    public void test10(){
        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        //Step 2. And click on “Status Codes”.
        //Step 3. Then click on “301”.
        driver.findElement(By.linkText("301")).click();
        //Step 4. Verify that following message is displayed: “This page returned a 301 status code”
        String msg = driver.findElement(By.cssSelector("div>p")).getText();
        boolean contains = msg.contains("This page returned a 301 status code");
        Assert.assertTrue(contains);
    }
    /*
    Test case #11
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 3. And click on “Status Codes”.
Step 4. Then click on “404”.
Step 5. Verify that following message is displayed: “This page returned a 404 status code”
     */
    @Test
    public void test11(){
        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        //Step 2. And click on “Status Codes”.
        //Step 4. Then click on “404”.
        driver.findElement(By.linkText("404")).click();
        //Step 5. Verify that following message is displayed: “This page returned a 404 status code”
        String msg = driver.findElement(By.cssSelector("div>p")).getText();
        boolean contains = msg.contains("This page returned a 404 status code");
        Assert.assertTrue(contains);
    }
    /*
    Test case #12
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 3. And click on “Status Codes”.
Step 4. Then click on “500”.
Step 5. Verify that following message is displayed: “This page returned a 500 status code
     */
    @Test
    public void test12(){
        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        //Step 2. And click on “Status Codes”.
        //Step 4. Then click on “500”.
        driver.findElement(By.linkText("500")).click();
        //Step 5. Verify that following message is displayed: “This page returned a 500 status code”
        String msg = driver.findElement(By.cssSelector("div>p")).getText();
        boolean contains = msg.contains("This page returned a 500 status code");
        Assert.assertTrue(contains);
    }

    @DataProvider
    public Object[][] getData(){

        Object[][] data = new Object[4][2];
        //first column => error code
        //second column => error message

        //test 9
        data[0][0] = "200";
        data[0][1] = "This page returned a 200 status code";

        //test 10
        data[0][0] = "301";
        data[0][1] = "This page returned a 301 status code";

        //test 11
        data[0][0] = "404";
        data[0][1] = "This page returned a 404 status code";

        //test 12
        data[0][0] = "500";
        data[0][1] = "This page returned a 500 status code";

        return data;
    }

}
