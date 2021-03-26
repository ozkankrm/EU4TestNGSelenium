package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotChanged {


    public static void main(String[] args) throws InterruptedException {
        /*
      Verify URL not changed
        -open chrome browser
        -go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        -click on Retrieve password
        -verify that url did not change
         */

        //open chrome browser-->(this line give us empty chrome)
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // save expected url before clicking button
        String expectedUrl = driver.getCurrentUrl();

        //click on Retrieve password       //html den elementin ıd sinin value sini bulduk ve ordan elemente ulaştkk
       //WebElement -->Interface that represent elements on the webpage
        //findElement--> method use to find element on a page
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //save actual url after clicking button
        // which webpage open?
        String actUalUrl = driver.getCurrentUrl();

        //verify that url did not change
        if(expectedUrl.equals(actUalUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }


       // Thread.sleep(3000);

        //close your browser
       // driver.quit();








    }
}
