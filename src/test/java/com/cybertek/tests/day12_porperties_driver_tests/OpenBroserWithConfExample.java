package com.cybertek.tests.day12_porperties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class OpenBroserWithConfExample {

    @Test
    public void openBrowserWithConf(){

        //open browser with CpnfigurationReader from configuration.properties
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));

        //dynamic url with configuration.properties and ConfigurationReader class
        driver.get(ConfigurationReader.get("url"));


        //static // input something by senddKeys but this way static
        driver.findElement(By.id("prependedInput")).sendKeys("User1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);

        //input something dynamic--> with Configuration properties
       String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password + Keys.ENTER);

        //second way
        driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.get("driver_username"));

    }
}
