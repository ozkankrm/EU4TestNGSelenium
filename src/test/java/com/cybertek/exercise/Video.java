package com.cybertek.exercise;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Video {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");
        Thread.sleep(5000);

        WebElement searchButton = driver.findElement(By.xpath("//form/div/div/input"));
        searchButton.sendKeys("ingilizce bilen köy");

        WebElement clickButton = driver.findElement(By.cssSelector("form button yt-icon"));
        clickButton.click();
        WebElement clickVideo = driver.findElement(By.xpath("(//*[contains(text(), 'İngilizce Bilen Köy')])[1]"));
        clickVideo.click();

    }
}
