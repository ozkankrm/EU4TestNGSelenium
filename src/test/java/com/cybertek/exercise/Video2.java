package com.cybertek.exercise;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Video2 {

    public static void main(String[] args) {

        WebDriverManager.operadriver().setup();

        WebDriver driver = new OperaDriver();

        driver.get("https://www.bbc.com");

    }
}
