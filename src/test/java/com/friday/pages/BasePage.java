package com.friday.pages;

import com.friday.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class  BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);


    }

    @FindBy(xpath = "//span[contains(text(),'Weiter')]")
    public WebElement contin;

    public void clickCont() {
        contin.click();
    }

    @FindBy(partialLinkText = "Support")
    public WebElement support;


    @FindBy(css = "a .Logo__logo--3FuI0")
    public WebElement logo;

    @FindBy (xpath = "//span[contains(text(),'Zurück')]")
    public WebElement back;
    @FindBy(xpath = "//a/ span[contains(text(),'Homepage')]")
    public WebElement Homepage;






}


