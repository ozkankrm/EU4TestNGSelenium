package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginAsDriver(){

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordIput.sendKeys(password);
        loginPage.loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");

    }

    @Test
    public void loginAsStoremanager(){

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        /*
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordIput.sendKeys(password);
        loginPage.loginButton.click();
        */

        //yurdaki 3 line tek line indirdik--> yukardali 3 line LoginPage de method oluşturduk ve içine koyduk
        //burda o methodu çağırdık
        loginPage.login(username,password);

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");

    }
    @Test
    public void loginAsStoreManager2(){

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsStoreManager();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }
    @Test
    public void loginAsDriver2(){

        LoginPage login = new LoginPage();
        login.loginDriver();

    }


}
