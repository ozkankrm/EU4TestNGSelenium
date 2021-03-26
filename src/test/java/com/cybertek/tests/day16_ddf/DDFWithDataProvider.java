package com.cybertek.tests.day16_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {

    @DataProvider
    public Object[][] testData(){

        String[][] data = {
                {"Breaking Bad", "10" },
                { "Prison Break", "10"},
                {"Friends", "9" },
                {"Sherlock", "8" },
                {"Gotham", "8" },
                {"The office", "8" },
                {"Big Bang", "7" }

        };
        return data;
    }

    @Test(dataProvider = "testData")
    public void test1(String tvshow, String rating){
        System.out.println("Tv show: " + tvshow+ "has rating " + rating);
    }

}
