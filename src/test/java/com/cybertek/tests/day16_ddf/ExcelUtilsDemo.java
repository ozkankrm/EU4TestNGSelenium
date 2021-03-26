package com.cybertek.tests.day16_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

        //create an object from ExcelUtil
        //it accept two argument
        //argument 1: location of the file(path)
        //argument 2: sheet that we want to open(sheetName)

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        System.out.println(qa3short.getCellData(1, 0));

        //rowCount()-->how many rows in the sheet
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());

        //columnCount()-->how many columns in the sheet
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());

        //getColumnNames()-->get all column names
        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());

        //get all data in list of maps
        List<Map<String, String>> dataList = qa3short.getDataList();
        for (Map<String, String> onerow : dataList) {
            System.out.println(onerow);

        }
        //get Nona as a value
        //get(index)-->index start ZERO
        System.out.println(dataList.get(2).get("firstname"));

        //get Harber
        System.out.println(dataList.get(8).get("lastname"));

        //get all data in 2D array
        String [][] dataArray = qa3short.getDataArray();

        //print 2D array
        System.out.println(Arrays.deepToString(dataArray));


    }

}
