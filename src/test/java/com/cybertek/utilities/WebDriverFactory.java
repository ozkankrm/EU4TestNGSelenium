package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class WebDriverFactory {

    //Task:
    //write a static method that takes a string parameter name: browserType
    //based on the value of parameter
    //it will setup the browser and
    //the method will return chromedriver or firefoxdriver object.
    //name of the method: getDriver

    public static WebDriver getDriver(String browserType){//ctrl basıp getdriver tıklarsan methoda gider

        WebDriver driver = null;

        //Chrome, CHROME,chrome
        switch (browserType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "safar":
                driver = null;
                break;
        }
        return driver;
    }


}
