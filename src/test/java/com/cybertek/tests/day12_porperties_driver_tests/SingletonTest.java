package com.cybertek.tests.day12_porperties_driver_tests;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.xml.dom.ParentSetter;

public class SingletonTest {

   // @Test---> yoruma alınca çalışmaz
    public void test(){
        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }
    @Test
    public void test2() throws InterruptedException {
        //önceki
      //  WebDriver driver = WebDriverFactory.getDriver("chrome");
       // driver.get("https://www.google.com");

        //yeni
        WebDriver driver1 = Driver.get();
        Thread.sleep(3000);
        driver1.get("https://www.google.com");

        //Driver.closeDriver();-->burda close kullanmazsak aşağıdaki testte aynı pencere açılır
        //eğer bunu kullanırsak aşağıdaki testte yeni chrome açılır.
    }
    @Test
    public void test3(){
        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.com");

        //yukarıdakinin kısa yolu ama yukardaki formatı kullanmak daha iyi ve kullanışlı
       // Driver.get().get("https://www.amazon.com");
    }
}
