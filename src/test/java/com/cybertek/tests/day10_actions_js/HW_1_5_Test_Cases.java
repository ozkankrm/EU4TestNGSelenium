package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HW_1_5_Test_Cases {
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

    @Test
    public void test1() throws InterruptedException {
        /*
        Test case #1
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter “wrong_dob” into date of birth inputbox.
Step 4. Verify that warning message is displayed: “The date of birth is not valid”
         */

        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        System.out.println(driver.getTitle());

        Thread.sleep(3000);

        //Step 2. Click on “Registration Form”
        WebElement clickRegistrationForm = driver.findElement(By.xpath("//a[.='Registration Form']"));
        clickRegistrationForm.click();

        //Step 3. Enter “wrong_dob” into date of birth inputbox.
        WebElement inputBox = driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']"));
        inputBox.sendKeys("wrong_dob");

        //Step 4. Verify that warning message is displayed: “The date of birth is not valid”
        String expectedResult = "The date of birth is not valid";
        String actualResult = driver.findElement(By.xpath("//*[. = 'The date of birth is not valid']")).getText();
        Assert.assertEquals(actualResult, expectedResult, "verify actual eguals expected");

        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);


    }
/*
Test case #2
Step 1. Go to “https://practicecybertekschool.
herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Verify that following options for
programming languages are displayed: c++, java,
JavaScript
 */

    @Test
    public void test2(){

        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. Click on “Registration Form”
        WebElement registrationForm = driver.findElement(By.xpath("//a[.='Registration Form']"));
        registrationForm.click();

        //Step 3. Verify that following options for
        //programming languages are displayed: c++, java,JavaScript
        List<WebElement> listLang = driver.findElements(By.xpath("(//div[@class = 'col-sm-5'])[11]"));

       // Assert.assertEquals(listLang.get(0).getText(),"C++")

        for (WebElement element : listLang) {
            Assert.assertTrue(element.isDisplayed(),"verify C++, Java, Java Script isDisplayed");
            System.out.println(element.getText());
        }

        /*

        WebElement c = driver.findElement(By.xpath("//*[.='C++']"));
        Assert.assertTrue(c.isDisplayed(),"verify C++ is displayed");

        WebElement java = driver.findElement(By.xpath("//*[.='Java']"));
        Assert.assertTrue(java.isDisplayed(),"verify java is displayed");

        WebElement JavaScript = driver.findElement(By.xpath("//*[.='JavaScript']"));
        Assert.assertTrue(JavaScript.isDisplayed(),"verify JavaScript is displayed");
       */

    }
    /*
    Test case #3
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter only one alphabetic character into first name input box.
Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
     */
    @Test
    public void test3(){
        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. Click on “Registration Form”
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        //Step 3. Enter only one alphabetic character into first name input box.
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("A");

        //Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
        //(//small[@class = 'help-block'])[2]
        String expected = "first name must be more than 2 and less than 64 characters long";
        String actual = driver.findElement(By.xpath("(//small[@class = 'help-block'])[2]")).getText();

        Assert.assertEquals(actual,expected);

        System.out.println("actual = " + actual);
        System.out.println("expected = " + expected);



    }
    /*
    Test case #4
Step 1. Go to https://practicecybertekschool.
herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter only one alphabetic character into last
name input box.
Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
     */

    @Test
    public void test4(){
        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. Click on “Registration Form”
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        //Step 3. Enter only one alphabetic character into lastname input box.
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("Z");

        //Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
        String expected = "The last name must be more than 2 and less than 64 characters long";
        String actual = driver.findElement(By.xpath("(//small[@class = 'help-block'])[6]")).getText();

        Assert.assertEquals(actual,expected);



    }
    /*
    Test case #5
Step 1. Go to “https://practicecybertekschool.
herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter any valid first name.
Step 4. Enter any valid last name.
Step 5. Enter any valid user name.
Step 6. Enter any valid password.
Step 7. Enter any valid phone number.
Step 8. Select gender.
Step 9. Enter any valid date of birth.
Step 10. Select any department.
Step 11. Enter any job title.
Step 12. Select java as a programming language.
Step 13. Click Sign up.
Step 14. Verify that following success message is displayed: “You've successfully completed registration!”
Note: for using dropdown, please refer to the documentation: https://selenium.dev/selenium/
docs/api/java/org/openqa/selenium/support/ui/Select.html or, please watch short video about dropdowns that is posted on canvas.
     */
    @Test
    public void test5(){
        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. Click on “Registration Form”
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        //Step 3. Enter any valid first name.
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("Mike");
        //Step 4. Enter any valid last name
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("Smith");
        //Step 5. Enter any valid user name.
        driver.findElement(By.cssSelector("[name='username']")).sendKeys("Msmith");
        // Enter any valid email
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("cybertek@gmail.com");
        //Step 6. Enter any valid password.
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("Cybertek");
        //Step 7. Enter any valid phone number.
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys("123-456-7890");
        //Step 8. Select gender.
        driver.findElement(By.cssSelector("[name='gender']")).click();
        //Step 9. Enter any valid date of birth.
        driver.findElement(By.cssSelector("[name='birthday']")).sendKeys("10/5/2020");
        //Step 10. Select any department.
      //  driver.findElement(By.cssSelector("[name='department'] > [value='DA']")).click();

        WebElement selectDepartment = driver.findElement(By.cssSelector("[name='department']"));

        Select departDropdown = new Select(selectDepartment);

        List<WebElement> options = departDropdown.getOptions();

        System.out.println("options.size() = " + options.size());

        for (WebElement option : options) {
            System.out.println(option.getText());

        }
        String expectedDepart = "Select your Department/Office";
        String actualDepart = departDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDepart,expectedDepart);

        departDropdown.selectByVisibleText("MCTC");

       // departDropdown.selectByIndex(1);
        //departDropdown.selectByValue("TO");

        //Step 11. Enter any job title.
        //driver.findElement(By.xpath("//select[@name='job_title']/option[5]")).click();

        WebElement selectJobTitle = driver.findElement(By.cssSelector("[name='job_title']"));
        Select jobTileDropdown = new Select(selectJobTitle);

        List<WebElement> options1 = jobTileDropdown.getOptions();
        System.out.println("options1.size() = " + options1.size());

        for (WebElement each : options1) {
            System.out.println(each.getText());
        }
        jobTileDropdown.selectByVisibleText("QA");


        //Step 12. Select java as a programming language.
        driver.findElement(By.cssSelector("#inlineCheckbox2")).click();
        //Step 13. Click Sign up.
        driver.findElement(By.id("wooden_spoon")).click();
        //Step 14. Verify that following success message is displayed: “You've successfully completed registration!”

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.cssSelector("div>p")).getText();
        Assert.assertEquals(actual,expected);

        System.out.println("actual = " + actual);
        System.out.println("expected = " + expected);
    }

}