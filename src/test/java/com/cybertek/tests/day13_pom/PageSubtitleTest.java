package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /**
     * Test case
     * Open Chrome browser
     * Login as a Driver
     * Verify that page subtitle is Quick Launchpad
     * Go to Activities -> Calendar Events
     * verify that page subtitle is Calendar Events
     */

    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();
        loginPage.loginDriver();

        String expectedSubtitle = "Quick Launchpad";

        //subclasstan obje oluşturduk ve BasePage methodlarına ulaştık
        DashboardPage dashboardPage = new DashboardPage();
        String actualSubtitle = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubtitle,expectedSubtitle,"Verify subtitle");

        //Go to Activities -> Calendar Events
        dashboardPage.navigateToModule("Activities","Calendar Events");

        //create object from CalendarEventsPage
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitFor(2);//sayfanın yüklenmesi için bu waiti koyduk yoksa hata veriyor

        //verify
        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events", "verify subtitle");




    }
}
