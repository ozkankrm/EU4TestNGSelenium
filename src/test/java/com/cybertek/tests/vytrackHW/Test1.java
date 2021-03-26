package com.cybertek.tests.vytrackHW;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Test1 extends TestBase {

    /*
    Test case #1
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Verify that page subtitle "Options" is displayed
     */
    @Test
    public void test1() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        Thread.sleep(3000);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        Assert.assertTrue(calendarEventsPage.options.isDisplayed());
        System.out.println(calendarEventsPage.options.getText());
    }
    /*
    Test case #2
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Verify that page number is equals to "1"
     */
    @Test
    public void test2() throws InterruptedException {
        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();
        //3. Navigate to “Activities -> Calendar Events”
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        Thread.sleep(3000);
        //4. Verify that page number is equals to "1"
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertEquals(calendarEventsPage.pageNumber.getAttribute("value"),"1", "verify page number");

        System.out.println(calendarEventsPage.pageNumber.getAttribute("value"));
    }
    /*
    Test case #3
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Verify that view per page number is equals to "25"
     */
    @Test
    public void test3() throws InterruptedException {
        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();
        //3. Navigate to “Activities -> Calendar Events”
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        Thread.sleep(3000);
        //4. Verify that view per page number is equals to "25"
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertEquals(calendarEventsPage.viewPerPage.getText(), "25", "verify view per page");
    }
    /*
    Test case #4
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Verify that number of calendar events (rows in the table) is equals to number of records
Hint: In HTML, <table> tag represents table,
<thread> - table header, <tr> tag represents table
row element, <th> table header cell and <td> table data.
Css selector: table > tr
     */
    @Test
    public void test4() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        Thread.sleep(3000);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        //4. Verify that number of calendar events (rows in the table) is equals to number of records
    }

    /*
    Test Case #5
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Click on the top checkbox to select all
5. Verify that all calendar events were selected
     */
    @Test
    public void test5() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        Thread.sleep(3000);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        //4. Click on the top checkbox to select all
        calendarEventsPage.checkBox.click();

        //5. Verify that all calendar events were selected
        Assert.assertTrue(calendarEventsPage.checkBox.isSelected());
    }
    /*
    Test Case #6
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Select “Testers meeting”
5. Verify that following data is displayed:
     */
    @Test
    public void test6() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        Thread.sleep(3000);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();


    }
}
