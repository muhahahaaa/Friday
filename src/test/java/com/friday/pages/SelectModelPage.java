package com.friday.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectModelPage extends BasePage {
    @FindBy(name = "makeFilter")
    public WebElement filter;

}
