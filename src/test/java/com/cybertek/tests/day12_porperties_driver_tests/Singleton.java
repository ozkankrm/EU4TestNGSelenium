package com.cybertek.tests.day12_porperties_driver_tests;

public class Singleton {

    //singleton class will have privatee constructor
    //it means other classes cannot create object of this class

    private Singleton(){}

    private static String str;

    public static String getInstance(){

        //if str has no value, initialize it and return it
        if(str==null){
            System.out.println("str is null. assigning value it");
            str = "somevalue"; // str a burda assign ettik ve string static olduğu için bu yeni value tüm
                              // tüm variablara aktarılır
        }else{
            //if it has value just return it
            System.out.println("it has value, just returning it");
        }
        return str;

    }
}
