package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPassword(){

        //driver.get(ConfigurationReader.get("url"));>>After todays class since we r gonna open the same project page, we put this line into TestBase Note: if you copy from GitHub you will not see this line there, BE CAREFUL!
        //aşağıdakini TestBase koyarız ve testlerimize yazmıyoruz sadece TetBase calssı extends yapıyruz
        //ve driver kullanıyoruz
        //  driver.get(ConfigurationReader.get("url"));


        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("User1");
        loginPage.passwordIput.sendKeys("somepassword");
        loginPage.loginButton.click();

      //  loginPage.login("User1","somepassword");


        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

    }
    @Test
    public void wrongUsername(){

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        loginPage.passwordIput.sendKeys("UserUser123");
        loginPage.loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");
    }

}
