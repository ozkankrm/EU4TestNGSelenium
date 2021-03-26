package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XpathPractice {
    /*
    Locator HW2
XPATH PRACTICES
DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_passwordHarici bir siteye bağlantılar.
3. Locate all the WebElements on the page using XPATH locator only (total of 6)
   a. “Home” link
   b. “Forgot password” header
   c. “E-mail” text
   d. E-mail input box
   e. “Retrieve password” button
4.Print text of a,b,c,e and put some email to d
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        driver.manage().window().maximize();

        //a-->locate home link and print
        System.out.println(driver.findElement(By.xpath("//ul[@class='navbar-nav']/li/a")).getText());

        //b-->locate forgot password header and print
        System.out.println(driver.findElement(By.xpath("//h2")).getText());

        //c-->locate E-mail and print
        System.out.println(driver.findElement(By.xpath("//div/label")).getText());

        //d-->locate E-öail input box and put some email
        driver.findElement(By.xpath("//div/input[@type='text']")).sendKeys("example@gmail.com");

        //e-->locate Retrieve password and print
        System.out.println(driver.findElement(By.xpath("//button[@id='form_submit']/i")).getText());


    }
}
