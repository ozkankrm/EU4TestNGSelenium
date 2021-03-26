package com.cybertek.tests.reviews;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderReview {

    @DataProvider
    public Object [][] movieData(){
        String [][] data = {

                {"Chernobyl", "9" },
                {"See", "8"},
                {"Dark", "9"},
                {"Akbar show", "10" },
                {"OOP with Ozzy", "10" },

        };
        return data;
    }
    //connection dataProvider with test
    //                  method name
    @Test(dataProvider = "movieData")
    //parametre sayısınıa göre methoda parametre atayabilirsin
    //bu case de yukardaki string de iki parametre olduğu için bu methoda iki parametre atadık
    public void test1(String tvshow, String rating){
        System.out.println("Tv show: " + tvshow + " rating: " + rating);

    }
}

