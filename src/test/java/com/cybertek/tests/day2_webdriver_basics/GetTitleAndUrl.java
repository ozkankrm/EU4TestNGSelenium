package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {

        //Task open chrome and navigate to https://practice.cybertekschool.com

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        // getting title with selenium

        // title önemli test te title çok kullanılır
        // if( title==facebook)
        //shorcut for creating variable
        //option or Alt+enter enter
        //getTitle()-->get you the tiel of the page
        String title = driver.getTitle();

        //print title
        //soutv + enter-->print variable name and value
        System.out.println("title = " + title);

        //getcurrentUrl--> get the url from browser
        driver.getCurrentUrl();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //getPageSource()--> gets the source of the page
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);
    }
}
