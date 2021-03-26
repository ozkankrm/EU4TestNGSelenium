package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        // driver.quit();
    }

    @Test
    public void printTable(){

        //print all table
        WebElement table = driver.findElement(By.xpath("//*[@id='table1']"));
        System.out.println(table.getText());


        //verify mail contain or not
        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));
    }

    @Test
    public void getAllHeaders(){

        //WebElement allHeader = driver.findElement(By.xpath("//thead[1]"));
        //System.out.println(allHeader.getText());

        //how many columns we have
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        //print each header
        for (WebElement header : headers) {
            System.out.println(header.getText());

        }
    }
    @Test
    public void printTableSize(){
        //how many columns we have
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        //number of rows with header
        List<WebElement> rowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("rowsWithHeader.size() = " + rowsWithHeader.size());

        //number of rows without header (we prefer this)
        //Birden fazla element oldğu için findElements kullandık
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("rows.size() = " + rows.size());


    }
    @Test
    public void getRow(){
        //print the second row information
        // bir element olduğu için findElement kullandık
        WebElement row2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println("row2 = " + row2.getText());

        //get all  rows dynamically
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        for (int i = 1; i <=rows.size(); i++) {
            WebElement allrows = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            System.out.println("row"+i+" = " + allrows.getText());

        }

    }
    @Test
    public void getAllCellInOneRow(){
        List<WebElement> allcellInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[3]/td"));

        //print each cell in one row
        for (WebElement eachCell : allcellInOneRow) {
            System.out.println(eachCell.getText());
        }

    }
    @Test
    public void getSingleCellByIndex(){
        List<WebElement> allcellInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]/td"));
        //use --->get(index)
        System.out.println(allcellInOneRow.get(2).getText());

        //or directly find locator then print
    }
    @Test
    public void printAllCellsByIndex(){

        int rowNumber = getNumberOfRows();
        int colNumber = getNumberOfColumns();

        for (int i = 1; i <=rowNumber; i++) {

            for (int j = 1; j <=colNumber; j++) {
            String cellXpath  = "//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]";
                System.out.println(cellXpath);

                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.println(cell.getText());

            }
        }

    }
    @Test
    public void getCellInRelationToAnotherCellSameRow(){
        // //table[@id='table1']//td[.='John']/../td[3]

      //  String firstName = "Jason";
        String xpath = "//table[@id='table1']//td[.='John']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());

        //dynamic
        String firstName = "Jason";
        //xpath deki ismi yukardki string ile dynamic hale getirdik
        String xpath1 = "//table[@id='table1']//td[.='"+firstName+"']/../td[3]";



    }

    private int getNumberOfColumns() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return  headers.size();
    }

    private int getNumberOfRows() {
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return  allRowsWithoutHeader.size();
    }

}

