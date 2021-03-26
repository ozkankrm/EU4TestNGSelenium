package com.cybertek.tests.day12_porperties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void test(){

        String browserType = ConfigurationReader.get("browser");

        WebDriver driver = WebDriverFactory.getDriver(browserType);

        WebDriver driver1 = WebDriverFactory.getDriver( ConfigurationReader.get("browser"));

        // configuration.properties deki browserın value sunu verir.
        System.out.println("browserType = " + browserType);

        String url = ConfigurationReader.get("url");

    }
}
