package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleepExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");

        //Thread-->java ile ilgilidir. Ve testimizi execution etmez içine yazılan süre kadar
        //bazı sayfalar açılırken bekler 3,4,7,1, vs  saniye bekler. Bu durumda testimizi çalıştırısak
        //elementi bulamaz ve işlemi yapmamaz ve test fail olur. Öncesinde thread.sleep koyarsak sayfa
        //açılana kadar bekler ve açıldıktan sonra codu çalıştırır ve elementi bulup ilemleri yapar
        Thread.sleep(6000);

        driver.findElement(By.id("username")).sendKeys("MikeSmith");
    }
}
