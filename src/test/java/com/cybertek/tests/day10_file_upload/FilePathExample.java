package com.cybertek.tests.day10_file_upload;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FilePathExample {





    @Test
    public void test1(){

        // file in full path yolu
        //  C:\Users\win10\IdeaProjects\EU4TestNGSelenium\src\test\resources\textfile.txt

        //file in local path yolu--> bilgisayardan bilgisayara göre değişir-->bunu dynamic yapmak lazım
        //C:\Users\win10\IdeaProjects\EU4TestNGSelenium

        //sabit olan path parçası
        //src\test\resources\textfile.txt

        //getProperty("user.dir)-->local project path ini verir.
        System.out.println(System.getProperty("user.dir"));//C:\Users\win10\IdeaProjects\EU4TestNGSelenium

        String projectPath = System.getProperty("user.dir");//dynamic olan
        String filePath = "src/test/resources/textfile.txt";//static olan

        String fullPath = projectPath+"/"+filePath;
        System.out.println(fullPath);


    }

}
