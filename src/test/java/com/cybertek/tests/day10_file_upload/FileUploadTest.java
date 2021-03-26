package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/upload");

        //locating "choose file" button
        WebElement chooseFile = driver.findElement(By.cssSelector("[name ='file']"));

       // chooseFile.sendKeys("C:/Users/win10/Desktop/file.txt");

        //dynamic path
        String projectPath = System.getProperty("user.dir");//dynamic olan
        String filePath = "src/test/resources/textfile.txt";//static olan
        String fullPath = projectPath+"/"+filePath;

        chooseFile.sendKeys(fullPath);

        driver.findElement(By.id("file-submit")).click();

        // getting the file name from browser
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();

        //verify file name is file.txt
        Assert.assertEquals(actualFileName,"textfile.txt");
    }



}
