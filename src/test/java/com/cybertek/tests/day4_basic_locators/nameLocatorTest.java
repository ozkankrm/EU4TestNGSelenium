package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.http.W3CHttpCommandCodec;

public class nameLocatorTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //make browser fullscreen
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInput = driver.findElement(By.name("full_name"));
        fullNameInput.sendKeys("Mike Smith");

        //task:
        //put some email and click sign up button

        WebElement inputEmail = driver.findElement(By.name("email"));
        inputEmail.sendKeys("osmith@gmail.com");

        /*
        //lazy way
        driver.findElement(By.name("email")).sendKeys("osmith@gmail.com");
        */
        WebElement signUp = driver.findElement(By.name("wooden_spoon"));
        signUp.click();

        //lazy way
        //driver.findElement(By.name("wooden_spoon")).click();




    }
}
