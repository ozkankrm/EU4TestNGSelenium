package com.cybertek.tests.day16_ddf;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {

    //dataProvider annotation ile aynı test case de farklı dataları run edebiliriz

    @DataProvider
    public Object[][] userData(){

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "QA3-short");

        //exceldeki ilk satırda usernam/password/firstname/lastname var ve bunları buraya almıyoruz
        // o yüzden getDataArrayWithoutFirstRow()--> methodunu kullandık
        String [][] dataArray = qa3short.getDataArrayWithoutFirstRow();

        return dataArray;
    }
    @Test(dataProvider = "userData")
    public void test1(String username, String password, String firstname, String lastname){
        //excelde 4 tane column var ve column sayısında paratre atadık

        extentLogger = report.createTest("Test " + firstname+ " "+ lastname);

        //LoginPage den obje oluşturduk
        LoginPage loginPage = new LoginPage();

        //exceldeki username ve password buraya çağıracak
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualFullName = dashboardPage.getUserName();
        String expectedFullName = firstname +" " + lastname;

        Assert.assertEquals(actualFullName,expectedFullName, "verify full name");
        extentLogger.pass("PASSED");

    }



}
