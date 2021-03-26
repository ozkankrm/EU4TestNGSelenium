package com.cybertek.tests.reviews.week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Review1 {

    public static void main(String[] args) {

        //to navigate cybertekschool.com with chrome
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        //driver->represent browser
        //driver objesi ile browsera ulaşıyoruz.

        driver.get("https://www.cybertekschool.com");


    }
}
