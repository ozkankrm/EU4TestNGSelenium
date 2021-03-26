package com.cybertek.tests.day7_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_Assertion_Demo {

    @Test
    public  void test1(){

        System.out.println("First Assertion");
        Assert.assertEquals("title","title");


        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");

    }

    @Test
    public void test2(){
        //assetEquals metdouna açıklama ekleyebiliyoruz
        Assert.assertEquals("title2","title2", "verify title");
        System.out.println("hello");
    }

    @Test
    public void test3(){

        //actualTitle ın Cyb ile başladığını doğrulama
        String expectedTitle = "Cyb";
        String actualTitle = "Cybertek";

        //assertTrue methodu string withstart ile kullandık
        // ve sonuna açıklama ekleyebiliyoruz.
        // doğru ise konsolda birşey görünmez
        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "verify title starts with Cyb");
    }

    @Test
    public void test4(){
        //verify email contains @ sign

        // assert lerde eğer doğruysa console da birşey çıkmaz
        String expectedEmail = "ornek@gmail.com ";
        Assert.assertTrue(expectedEmail.contains("@"),"verify email contains @");
    }

    @Test
    public  void teste5(){

        //0>1 false ve testimiz doğru ve console da birşey çıkmaz
        //negatif koşul sağlanıyorsa yani testimiz geçmiş olur
        Assert.assertFalse(0>1,"verify that 0 is not greater than 1 ");
    }

    @Test
    public void teste6(){
        Assert.assertNotEquals("one","two");
    }



}
