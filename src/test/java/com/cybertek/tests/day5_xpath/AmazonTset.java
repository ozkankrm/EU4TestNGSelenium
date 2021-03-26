package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTset {
    /*
    TASK
    go to amazon.com
    search for selenium
    click search button
    print 1-48 of 304 results for "selenium"
    verify 1-48 of 304 results for "selenium"
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.com");

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("selenium");

        //click sear button
        driver.findElement(By.xpath("//*[@id='nav-search-submit-text']/input")).click();
                                                                            // static part
        WebElement result =driver.findElement(By.xpath("//span[contains(text(), 'results for')]"));
        String resultText = result.getText();
        System.out.println("resultText = " + resultText);

        String expectedResult = "1-48 of 132 results for";

        if (expectedResult.equals(resultText)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expectedResult = " + expectedResult);
            System.out.println("resultText = " + resultText);
        }



    }
}
