package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    public LoginPage() { //constructor

        //iniliaze
        //Driver.get()-->responsible which browser we use
        PageFactory.initElements(Driver.get(), this);
    }

    /*
    //iki koşuldaan biri sağlarsa return element yapar
    @FindAll({
            @FindBy(id= "value"),
            @FindBy(name = "value")
    })

    // iki koşulunda sağlarsa return element
    // eğer iki koşulda sağlamazsa return element yapmaz
    @FindBys({
            @FindBy(id= "prependedInput"),
            @FindBy(name = "value")
    })
    */

    //driver.findElement(By.id("prependedInput"));
    @FindBy(id = "prependedInput")  //reperesent find Element
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordIput;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    //birden fazla elementi listeledik
//    @FindBy(css = ".btn.btn-primary")
  //  public List<WebElement> buttons;

    public void login(String username, String password){

        usernameInput.sendKeys(username);
        passwordIput.sendKeys(password);
        loginButton.click();
    }

    public void loginAsStoreManager(){

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        usernameInput.sendKeys(username);
        passwordIput.sendKeys(password);
        loginButton.click();
    }
    public void loginDriver(){

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        usernameInput.sendKeys(username);
        passwordIput.sendKeys(password);
        loginButton.click();
    }
    public void loginAsSalesmanager(){
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        usernameInput.sendKeys(username);
        passwordIput.sendKeys(password);
        loginButton.click();

    }
    public void loginAsStoremanager(){
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        usernameInput.sendKeys(username);
        passwordIput.sendKeys(password);
        loginButton.click();

    }


}