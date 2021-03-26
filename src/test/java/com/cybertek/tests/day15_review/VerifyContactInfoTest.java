package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyContactInfoTest extends TestBase {

    /*
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com--> make dynamic
     * verify that full name is Mariam Brackstone--> make dynamic
     * verify that email is mbrackstone9@example.com--> make dynamic
     * verify that phone number is +18982323434--> make dynamic
     */

    @Test
    public void contactDetailsTest(){

        extentLogger = report.createTest("Contact Info Verification");


        // * open the chrome
        //   * go to qa1.vytrack
        //->yukardaki 2 adımı TestBase yaptık ve TestBase buraya extends ettik

        // * login as a sales manager
        LoginPage loginPage = new LoginPage();
        extentLogger.info("username: " );
        extentLogger.info("password:");
        extentLogger.info("Login as a sales manager");
        loginPage.loginAsSalesmanager();//Loginpage de loginAsSalesmanager() methodu oluşturduk.

        //* navigate to customers ->contacts
        DashboardPage dashboardPage = new DashboardPage();
        //navigateToModule() methodu BasePage de ve bu class abstract ve obje oluşturamıyoruz.Bunun yerine DashboardPage
        //den obje oluşturduk ve onu kullandık Öünkü DashboardPage BasePage extends etmişti.
        extentLogger.info("Navigate to-->Customers Contacts");
        dashboardPage.navigateToModule("Customers","Contacts");

         //eğer bir kere navigate edeceksen aşağıdaki kısa yol ve kullanabilirsin
        //new DashboardPage().navigateToModule();

        //click on email mbrackstone9@example.com
        ContactsPage contactsPage = new ContactsPage();

        extentLogger.info("Click on mbrackstone9@example.com");
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        //* verify that full name is Mariam Brackstone--> make dynamic
        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String expectedFullName = "Mariam Brackstone";
        String actualFullName = contactInfoPage.fullName.getText();

        extentLogger.info("Verify Full Name is " + expectedFullName);
        Assert.assertEquals(actualFullName,expectedFullName);

        //* verify that email is mbrackstone9@example.com--> make dynamic
        String expectedEmail = "mbrackstone9@example.com";
        String actualEmail = contactInfoPage.email.getText();
        extentLogger.info("Verify Email is mbrackstone9@example.com");
        Assert.assertEquals(actualEmail,expectedEmail);

        //* verify that phone number is +18982323434--> make dynamic
        String expectedPhone = "+18982323434";
        String actualPhone = contactInfoPage.phone.getText();
        extentLogger.info("Verify phone number is +18982323434");
        Assert.assertEquals(actualPhone,expectedPhone);
        extentLogger.pass("PASSED");

        // one line
       // Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434", "verify phone");

    }
}
