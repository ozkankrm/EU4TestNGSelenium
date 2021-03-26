package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {

    public static void main(String[] args) {
    //we have to enter this line every time we want to open chrome
    // hey webDriverManager, can you make chrome ready for me for automation
        WebDriverManager.chromedriver().setup();

        //WebDriver reperesent the browseer
        //we are creating driver (object) for chrome browser
        // new ChromeDriver() --> this part will open chrome browser
        // default and now empty
        WebDriver driver = new ChromeDriver();

        // here we call get method
        //.get(url) method used for navigation to page
    //    driver.get("https://cybertekschool.com");

        //this line allow selenium to automate firefox browser
       // WebDriverManager.firefoxdriver().setup();

      //  WebDriver driver = new FirefoxDriver();

       driver.get("https://www.bbc.com");



    }


}
