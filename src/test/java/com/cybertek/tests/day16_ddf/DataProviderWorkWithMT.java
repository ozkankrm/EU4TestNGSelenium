package com.cybertek.tests.day16_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWorkWithMT {


    @DataProvider
    public Object[][] userData(){

        String[][] dataArray = {
                {"username", "user1" },
                {"password", "UserUser123" },
                { "Firstname", "John"},
        };


        return dataArray;
    }

    @Test(dataProvider = "userData")
    public void test1(String user, String name) {

        System.out.println("user: " + user + " name: " + name);
    }
}
