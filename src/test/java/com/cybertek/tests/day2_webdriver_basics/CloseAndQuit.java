package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        Thread.sleep(2000);

        //close current tab
        // en son açılan sayfayı kapatır
        // sayfa yukarda 2 saniye beklesin sonra kapansın dedik
        //close() ile kapattık
        driver.close(); // burda kapattık. ve açık olmadığı için yeni sayfayı açmaz
                        // ancak obje açılırsa yeniden açılabilir

        // giving new browser tab
        driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        //close all tabs-->tüm tabları kapatır
        driver.quit();

    }
}
