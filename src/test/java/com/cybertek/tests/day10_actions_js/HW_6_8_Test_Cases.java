package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class HW_6_8_Test_Cases {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {

        Thread.sleep(3000);
        //driver.quit();
    }
        /*
Step 1. Go to "https://www.tempmailaddress.com/"
Step 2. Copy and save email as a string.
Step 3. Then go to “https://practicecybertekschool.herokuapp.com”
Step 4. And click on “Sign Up For Mailing List".
Step 5. Enter any valid name.
Step 6. Enter email from the Step 2.
Step 7. Click Sign Up
Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to
return to the home page.”
Step 9. Navigate back to the “https://www.tempmailaddress.com/”
Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
Step 11. Click on that email to open it.
Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
         */
    @Ignore
    @Test
    public void teste6(){
        //Step 1. Go to "https://www.tempmailaddress.com/"
        driver.get("https://www.tempmailaddress.com/");
        //Step 2. Copy and save email as a string.
        String email = driver.findElement(By.cssSelector(".animace")).getText();
        //Step 3. Then go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 4. And click on “Sign Up For Mailing List".
        driver.findElement(By.xpath("//a[text()='Sign Up For Mailing List']")).click();
        //Step 5. Enter any valid name.
        driver.findElement(By.cssSelector("[name='full_name']")).sendKeys("Luko Doncic");
        //Step 6. Enter email from the Step 2.
        driver.findElement(By.cssSelector("[name='email']")).sendKeys(email);
        //Step 7. Click Sign Up
        driver.findElement(By.cssSelector(".radius")).click();
        //Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to
        //return to the home page.”
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        String actualMessage = driver.findElement(By.cssSelector(".subheader")).getText();
        Assert.assertEquals(actualMessage,expectedMessage,"verify message");
        //Step 9. Navigate back to the “https://www.tempmailaddress.com/”
        driver.navigate().to("https://www.tempmailaddress.com/");
        //Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
        String expectedEmail = "";
        String actualEmail = driver.findElement(By.xpath("//*[.='do-not-reply@practice.cybertekschool.com']")).getText();
        Assert.assertEquals(actualEmail,expectedEmail,"verify email");
        //Step 11. Click on that email to open it.
        driver.findElement(By.cssSelector("[data-href='2']")).click();
        //Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
        String expectedResult = "do-not-reply@practice.cybertekschool.com";
        String actualResult = driver.findElement(By.cssSelector("#odesilatel")).getText();
        Assert.assertEquals(actualResult,expectedResult, "verify message");
        //Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        String actualSubject = driver.findElement(By.cssSelector("#predmet")).getText();
        Assert.assertEquals(actualSubject,expectedSubject, "verify subject");

    }
    /*
    Test case #7
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. And click on “File Upload".
Step 3. Upload any file with .txt extension from your computer.
Step 4. Click “Upload” button.
Step 5. Verify that subject is: “File Uploaded!”
Step 6. Verify that uploaded file name is displayed.
Note: use element.sendKeys(“/file/path”) with
specifying path to the file for uploading. Run this
method against “Choose File” button.
     */

    @Test
    public void test7(){
        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 2. And click on “File Upload".
        driver.findElement(By.cssSelector("a[href='/upload']")).click();
        //Step 3. Upload any file with .txt extension from your computer.
         driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\win10\\Desktop\\someinformation.txt");
         //Step 4. Click “Upload” button.
        driver.findElement(By.id("file-submit")).click();
        //Step 5. Verify that subject is: “File Uploaded!”
        Assert.assertEquals(driver.findElement(By.cssSelector("div > h3")).getText(),"File Uploaded!", "verify");
        //Step 6. Verify that uploaded file name is displayed.
        Assert.assertTrue(driver.findElement(By.id("uploaded-files")).isDisplayed());


    }
    /*
    Test case #8
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. And click on “Autocomplete”.
Step 3. Enter “United States of America” into country input box.
Step 4. Verify that following message is displayed: “You selected: United States of America”
Optional: If you want to to be a real selenium hero, use @DataProvider for for tests cases from 9
through 12.
Please use following documentation: https://
testng.org/doc/documentationmain.html#parameters-dataproviders
     */

    @Test
    public void test8(){
        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 2. And click on “Autocomplete”.
        driver.findElement(By.cssSelector("[href='/autocomplete']")).click();
        //Step 3. Enter “United States of America” into country input box.
        driver.findElement(By.cssSelector("#myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("form > input")).click();
        //Step 4. Verify that following message is displayed: “You selected: United States of America”
        Assert.assertTrue(driver.findElement(By.cssSelector("#result")).isDisplayed());

    }
}
