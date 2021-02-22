package com.friday.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectRegisterOwnerPage extends BasePage{
    @FindBy(xpath = "//span[contains(text(),'Wird das Auto')]")
    public WebElement WizardTitle3;
    @FindBy(xpath = "//button[@*='Yes']")
    public WebElement yes;
    @FindBy(xpath = "//button[@*='No']")
    public WebElement no;
    @FindBy(xpath = "//span[contains(text(),'Du nutzt')]")
    public WebElement helpText3;
    @FindBy(xpath = "//span[contains(text(),'Das Auto')]")
    public WebElement WizardTitle4;
    @FindBy(xpath = "//button[@*='used']")
    public WebElement used;
    @FindBy(xpath = "//button[@*='brandNew']")
    public WebElement brandNew;

}
