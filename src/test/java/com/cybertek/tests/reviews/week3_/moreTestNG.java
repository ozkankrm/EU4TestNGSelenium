package com.cybertek.tests.reviews.week3_;

import org.testng.annotations.Test;

public class moreTestNG {

    //aşağıdaki testleri run ettiğimizde alfabetik sıraya göre run eder. şağıdaki sırası önemli değil
    //eğer rakam olursa 1-9 şeklinde sıraya göre run eder
    @Test
    public void B(){
        System.out.println("My second test case");
    }
    @Test
    public void C(){
        System.out.println("My third test case");
    }
    @Test
    public void A(){
        System.out.println("My first test case");
    }

    //How ı can run my test, ı want my order
    //@Test(priority = 1)-->@Test in yanına parentezin içine (priority=1) hangi testimizi önce run etmesini istersek
    //ona 1 rakamını ve sonraki ordera göre rakamlar atarak run edebiliriz
    @Test(priority = 1)
    public void D(){
        System.out.println("My second test case");
    }
    @Test(priority = 2)
    public void F(){
        System.out.println("My third test case");
    }
    @Test(priority = 3)
    public void E(){
        System.out.println("My first test case");
    }

}
