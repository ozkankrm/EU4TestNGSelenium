package com.cybertek.tests.reviews.week2_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EtsyLocatorWithString {
    public static void main(String[] args) throws InterruptedException {
        /*
        go to etsy.com
create one locator to click Clothing & Shoes
then do string manipulation to separate your locator part and text
create one variable for menuName and change value to Home & Living
your locator should work for different menus, without changing xpath part.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://www.etsy.com");


        // aynı parent altında child ın text içeriği. Hangi child ulaşmak istersek onun textini Stringe atarız
        //ve böylece aşağıdaki koda dokunmayız.
        String menuName = "Home & Living";

        String xpathLocator = "//ul[@data-ui = 'mobile-top-catnav-container']//*[text()='" +menuName+"']";

        Thread.sleep(5000);

        // burayı değiştirmiyoruz
        WebElement menu = driver.findElement(By.xpath(xpathLocator));
        menu.click();


    }
}
