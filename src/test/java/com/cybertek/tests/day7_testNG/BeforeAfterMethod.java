package com.cybertek.tests.day7_testNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass
    public void setUpClass(){
        System.out.println("--BEFORE CLASS--");
    }
    @Test
    public void test1(){
        System.out.println("First test case");
    }

    @Ignore // bu testng yi görmezden gelir ve run etmez
    @Test
    public void test2(){
        System.out.println("Second test case");
    }

    @BeforeMethod // Her Testten önce bu method çalışır
    public void setUp(){
        System.out.println("--before each method--");
        System.out.println("WebDriver, Opening Browser");
    }

    @AfterMethod // Her Testten sonra bu method çalışır
    public void tearDown(){
        System.out.println("--after each method--");
        System.out.println("Closing Browser, Quit");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("--AFTER CLASS--");

    }

}
