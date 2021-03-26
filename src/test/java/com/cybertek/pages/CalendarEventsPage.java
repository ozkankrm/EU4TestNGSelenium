package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(css = "[type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "(//div/button[@data-toggle='dropdown'])[1]")
    public WebElement viewPerPage;

    @FindBy(xpath = "//button/input[@type='checkbox']")
    public WebElement checkBox;

    @FindBy(xpath = "(//div[@data-toggle = 'dropdown'])[2]")
    public WebElement options;

}
