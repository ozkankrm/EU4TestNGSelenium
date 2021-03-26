package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW_SeleniumEasy_CheckBox_Verify {

    /*
    TC #2: SeleniumEasy Checkbox Verification – Section 1
1. Open Chrome browser
2. Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
3. Verify “Success – Check box is checked” message is NOT displayed.
4. Click to checkbox under “Single Checkbox Demo” section
5. Verify “Success – Check box is checked” message is displayed.
     */

    @Test
    public void test1() throws InterruptedException {

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        //2. Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //3. Verify “Success – Check box is checked” message is NOT displayed.
        WebElement checkBox = driver.findElement(By.xpath("//div/label/input[@id='isAgeSelected']"));
        Assert.assertFalse(checkBox.isSelected(), "verify Success – Check box is checked, NOT displayed");
        System.out.println("checkBox.isSelected() = " + checkBox.isSelected());

        //4. Click to checkbox under “Single Checkbox Demo” section
        checkBox.click();

        //5. Verify “Success – Check box is checked” message is displayed.
        Assert.assertTrue(checkBox.isSelected(), "verify Success – Check box is checked, is displayed");

        WebElement displayTextCheck = driver.findElement(By.xpath("//div[@id='txtAge']"));
        System.out.println("displayTextCheck.getAttribute(\"id\") = " + displayTextCheck.getAttribute("id"));
        System.out.println(displayTextCheck.getAttribute("innerHTML"));


        Thread.sleep(3000);
        driver.quit();
    }

    /*
    TC #3: SeleniumEasy Checkbox Verification – Section 2
1. Open Chrome browser
2. Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
3. Verify “Check All” button text is “Check All”
4. Click to “Check All” button
5. Verify all check boxes are checked
6. Verify button text changed to “Uncheck All”
     */

    @Test
    public void test2() throws InterruptedException {
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        // 2. Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkAllBoxBtn = driver.findElement(By.id("check1"));

        //3. Verify “Check All” button text is “Check All”
        String expectedCheckBox = "Check All";
    //    System.out.println("expectedCheckBox = " + expectedCheckBox);

        String actualCheckBox =checkAllBoxBtn.getAttribute("value");
   //     System.out.println("actualCheckBox = " + actualCheckBox);

        Assert.assertEquals(actualCheckBox,expectedCheckBox,"Verify “Check All” button text is “Check All ");

        //4. Click to “Check All” button
        checkAllBoxBtn.click();

        //5. Verify all check boxes are checked
        WebElement checkOption1 = driver.findElement(By.xpath("//*[text()='Option 1']"));
        Assert.assertTrue(checkOption1.isSelected());

        WebElement checkOption2 = driver.findElement(By.xpath("//*[text()='Option 2']"));
        Assert.assertTrue(checkOption2.isSelected());

        WebElement checkOption3 = driver.findElement(By.xpath("//*[text()='Option 3']"));
        Assert.assertTrue(checkOption3.isSelected());

        WebElement checkOption4 = driver.findElement(By.xpath("//*[text()='Option 4']"));
        Assert.assertTrue(checkOption4.isSelected());


        //6. Verify button text changed to “Uncheck All”
        expectedCheckBox = "Uncheck All";
        actualCheckBox = checkAllBoxBtn.getAttribute("value");

        System.out.println("actualCheckBox = " + actualCheckBox);
        System.out.println("expectedCheckBox = " + expectedCheckBox);
        Assert.assertEquals(actualCheckBox,expectedCheckBox,"Verify button text changed to “Uncheck All”");



        Thread.sleep(3000);
        //driver.quit();

    }
}
