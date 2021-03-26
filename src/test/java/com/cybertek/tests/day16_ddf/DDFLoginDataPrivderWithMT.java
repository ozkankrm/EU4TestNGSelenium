package com.cybertek.tests.day16_ddf;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginDataPrivderWithMT extends TestBase {

    @DataProvider
    public Object[][] userLogin(){

        ExcelUtil excelUtil = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        String [][] dataArray = excelUtil.getDataArrayWithoutFirstRow();

        return dataArray;

    }
    @Test(dataProvider = "userLogin")
    public void login(String username, String password, String first, String last){

        extentLogger = report.createTest("Test " + first + " " + last);
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();

        String actualFullName = dashboardPage.getUserName();
        String expectedFullName = first + " " + last;

        Assert.assertEquals(actualFullName, expectedFullName,"verify full name");
        extentLogger.pass("PASS");
    }




}
