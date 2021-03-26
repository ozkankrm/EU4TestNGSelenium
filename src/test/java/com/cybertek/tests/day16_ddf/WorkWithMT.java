package com.cybertek.tests.day16_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WorkWithMT {

    @Test
    public void test1(){

        ExcelUtil excelUtil = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        System.out.println();
        System.out.println("excelUtil.rowCount() = " + excelUtil.rowCount());

        System.out.println();
        System.out.println("excelUtil.columnCount() = " + excelUtil.columnCount());

        System.out.println();
        System.out.println("excelUtil.getColumnsNames() = " + excelUtil.getColumnsNames());

        System.out.println();
        System.out.println("excelUtil.getCellData(0,0) = " + excelUtil.getCellData(0, 0));

        System.out.println();
        excelUtil.setCellData("usssss", 0,0);

        System.out.println("excelUtil.getCellData(0,0) = " + excelUtil.getCellData(0, 0));

        String [][] dataArray = excelUtil.getDataArray();

        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray));

        List<Map<String, String>> dataList = excelUtil.getDataList();

        for (Map<String, String> onerow : dataList) {
            System.out.println(onerow);

        }
    }
}
