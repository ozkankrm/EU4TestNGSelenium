package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Wikipedia_Test {
    /*
    Test case 3

Go to wikipedia.org (Links to an external site.)
enter search term `selenium webdriver`
click on search button
click on search result `Selenium (software)`
verify url ends with `Selenium_(software)'
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://en.wikipedia.org");

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("selenium webdriver");
        driver.findElement(By.id("searchButton")).click();
        driver.findElement(By.xpath("//html/body/div[3]/div[3]/div[4]/div[3]/ul/li[1]/div[1]/a")).click();

        String currentUrl = driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());

        String expectedUrl = "https://en.wikipedia.org/wiki/Selenium_(software)";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        if (currentUrl.endsWith("Selenium_(software)")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println(driver.getCurrentUrl());
        }

    }
}
