package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPassword(){

        //driver.get(ConfigurationReader.get("url"));>>After todays class since we r gonna open the same project page, we put this line into TestBase Note: if you copy from GitHub you will not see this line there, BE CAREFUL!
        //aşağıdakini TestBase koyarız ve testlerimize yazmıyoruz sadece TetBase calssı extends yapıyruz
        //ve driver kullanıyoruz
        //  driver.get(ConfigurationReader.get("url"));

        //name of the test
        extentLogger = report.createTest("Wrong Password Test");

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("User1");
        extentLogger.info("Enter username: User1");

        loginPage.passwordIput.sendKeys("somepassword");
        extentLogger.info("Enter password: somepassword");

        loginPage.loginButton.click();
        extentLogger.info("Click login button");

        extentLogger.info("Verify page URL");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");
        extentLogger.pass("Wrong Password Test is Passed");

    }
    @Test
    public void wrongUsername(){

        //name of the test
        extentLogger = report.createTest("Wrong Username Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter usrname: someusername");
        loginPage.usernameInput.sendKeys("someusername");

        extentLogger.info("Enter password: UserUser123");
        loginPage.passwordIput.sendKeys("UserUser123");

        extentLogger.info("Click login button");
        loginPage.loginButton.click();

        extentLogger.info("Verify page url");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");
        extentLogger.pass("PASSED");
    }
}
