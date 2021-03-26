package com.cybertek.tests.reviews.week2_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MoreXpath {

        @Test
        public void test1() throws InterruptedException {
            WebDriver driver = WebDriverFactory.getDriver("chrome");

            driver.get("https://www.amazon.com");
            driver.manage().window().maximize();

            // elementin addresini Stringe atadık ve stringi aşağıda xpath de kullandık
            //Aynı parent altındaki chillerda parent sabit kalıp child larda text xpath yoluyla dynamic hale getirdik
      //      String xpathLocator = "//div[@id='nav-xshop']/*[. ='Gift Cards & Top Up']";

            //burda istediğimiz child ulaşmak için text yazıyororuz. Aşağıya dokunmuyoruz
            String menuName = "Best Sellers";

            String xpathLocator = "//div[@id='nav-xshop']/*[. ='"+menuName+"']";

            //burasını sabitledik ve String de yapılan değişikler buraya otomatikmen yansıyacak
            WebElement menu = driver.findElement(By.xpath(xpathLocator));

        //    WebElement menu = driver.findElement(By.xpath("//div[@id='nav-xshop']//*[. ='Gift Cards & Top Up']"));

            menu.click();
    }
}
