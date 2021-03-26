package com.cybertek.tests.day16_ddf;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MyselfExcercise  {

    @Test
    public void testExcel(){

        ExcelUtil excelUtil = new ExcelUtil("C:/Users/win10/Desktop/Vytrack1.xlsx", "Sayfa1");

        System.out.println();
        System.out.println("excelUtil.getColumnsNames() = " + excelUtil.getColumnsNames());

        System.out.println();
        System.out.println("excelUtil.getCellData(0,0) = " + excelUtil.getCellData(0, 0));

        System.out.println();
        List<Map<String, String>> dataList = excelUtil.getDataList();

        for (Map<String, String> eachRow : dataList) {
            System.out.println(eachRow.get("firstname"));

        }
        System.out.println("dataList.get(0).get(\"password\") = " + dataList.get(0).get("password"));

        System.out.println();
        System.out.println("excelUtil.columnCount() = " + excelUtil.columnCount());

        System.out.println();
        System.out.println("excelUtil.rowCount() = " + excelUtil.rowCount());

        System.out.println();
        String [][] dataArray = excelUtil.getDataArray();
        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray));

        System.out.println();
        excelUtil.setCellData("UserUser111",0,0);

        System.out.println();
        System.out.println("excelUtil.getCellData(0,0) = " + excelUtil.getCellData(0, 0));
    }

}
