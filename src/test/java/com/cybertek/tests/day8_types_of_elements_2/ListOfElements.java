package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }




    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //çoklu elementte findElements kullan
        //save our web elements inside the list
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        //how many button inside the list// use size() method
        System.out.println("buttons.size() = " + buttons.size());

        //verfiy button size  (actual, expected)
        Assert.assertEquals(buttons.size(),6, "verfiy buttons size");

        //listteki elementlerden bir tanesine ulaşmak için get(indexNumber) kullanılır
        buttons.get(0); // get() içindeki 0 index numarasıdır. arraylistteki gibi index sıfır(0) dan başlar

        //listteki tüm elementlere ulaşmak için for each loop kullanıllır
        //iter yaz sonra enter hit yap last elementin for each formülünü verir
        for (WebElement button : buttons) {

          //  System.out.println(button.getText());//her elementin textini yazdırır

            //verify all elements displayed
            System.out.println("button.isDisplayed() = " + button.isDisplayed());
            Assert.assertTrue(button.isDisplayed(),"verify buttons are displayed");

        }

        //click second button//index start zero (0)
        buttons.get(1).click();

        

    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //regular findElement metod will throw NSE if locator does not exist
       // driver.findElement(By.tagName("buttonsmkkf"));

        //passing locator which does not exist, it will not throw NoSuchElement
        //eğer locators adressi yanlışsa ve elementleri  bulamazsa hata vermez
        //ALT+enter then one more enter for yoour shortcut
        List<WebElement> buttons = driver.findElements(By.tagName("buttonbbbb"));

        //hata vermedği için size a bakarız. hiçbirşey bulamadığı için size sıfır olur
        //ve size dan assertEquals yaparız
        System.out.println("buttons.size() = " + buttons.size());


    }
}
