package com.cybertek.exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FindElement {

    public static void main(String[] args) {

       WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        /*
        WebDriverManager.edgedriver().setup();

        WebDriver driver = new EdgeDriver();
    */


        driver.get("https://www.cybertekschool.com");

        WebElement programs = driver.findElement(By.id("menu-item-34"));

        programs.click();
        programs.click();

    }

}
