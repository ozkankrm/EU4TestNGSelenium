package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class RepeatOptionsTests extends TestBase {

     /*VERIFY RADIO BUTTONS
    Open Chrome browser
    Login as driver
    Go to Activities->Calendar Events
    Click on create calendar events
    Click on repeat
    Verify that repeat every days is checked
    verify that repeat weekday is not checked
    * */

    @Test
    public void test1(){
         //TestBase eextends ettik ve orda @Before @After methodları burda çalıştı
        //o yüzden burda driver ile ilgili herhangi birşey yapmıyoruz

        LoginPage loginPage = new LoginPage();
        // Login as driver
        loginPage.loginDriver();

        DashboardPage dashboardPage = new DashboardPage();
        //Go to Activities->Calendar Events
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        // Click on create calendar events
        BrowserUtils.waitFor(4);//sayfanın yüklenmesi için wait koyduk yoksa elemente ulaşamıyor
        //calendarEventsPage.waitUntilLoaderScreenDisappear();-->bunu da kullanabilirsin
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        //Click on repeat
        createCalendarEventsPage.repeat.click();

        // Verify that repeat every days is checked
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"verify repeat days is selected");

        //verify that repeat weekday is not checked
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"verify weekday is not selected");


    }
     /*
     VERIFY REPEAT OPTIONS
        Open Chrome browser
        Login as driver
        Go to Activities->Calendar Events
        Click on create calendar events button
        Click on repeat checkbox
        Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
     */
    @Test
    public void test2(){

        LoginPage loginPage = new LoginPage();
        // Login as driver
        loginPage.loginDriver();

        DashboardPage dashboardPage = new DashboardPage();
        //Go to Activities->Calendar Events
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        // Click on create calendar events
        BrowserUtils.waitFor(8);//sayfanın yüklenmesi için wait koyduk yoksa elemente ulaşamıyor
        //calendarEventsPage.waitUntilLoaderScreenDisappear();-->bunu da kullanabilirsin
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        //Click on repeat
        createCalendarEventsPage.repeat.click();

        Select repeatDropdown = createCalendarEventsPage.repeatOptionsList();

        // Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
        List<String> expectedList = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");//

        //boş bir list oluşturduk ve elementleri bunun içine koyacağız
        //sonra expected ile karşılaştıracağız
        List<String> actualList = new ArrayList<>();

        List<WebElement> actualOptions = repeatDropdown.getOptions();
        for (WebElement option : actualOptions) {
            //get text of each element and add to actual List
            actualList.add(option.getText());//actualList boştu ve burda ona elementleri ekledik
        }

        //yukardaki işlemi tek satırda yaptık
        //getElementsText()-->method ile
        List<String> actualList2 = BrowserUtils.getElementsText(actualOptions);

        // Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
        Assert.assertEquals(actualList, expectedList, "verify daily weekly monthly yearly");


    }
}
