package com.cybertek.tests.day7_testNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FirstTestNG_Test { //burdan çalıştırırsan classtaki tüm test caseler run etmiş olursun

    @Ignore
    @Test  // bu satırı yoruma alırssam method run olmaz
    public void test1(){
        System.out.println("My first test case");
    }
    @Test
    public void test2(){
        System.out.println("My second test case");
    }
}
