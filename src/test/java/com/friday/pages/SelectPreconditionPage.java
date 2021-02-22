package com.friday.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectPreconditionPage extends BasePage{
    @FindBy(css="a .Logo__logo--3FuI0")
    public WebElement logo;
    @FindBy(css="[value='keepingCar']")
    public WebElement radiobtn1;
    @FindBy(css="[value='buyingCar']")
    public WebElement radiobtn2;
    @FindBy(xpath = "//span[contains(text(),'In 90')]")
    public WebElement WizardTitle1;
    @FindBy(xpath = "//span[contains(text(),'eVB-Nummer')]")
    public WebElement helpText1;
    @FindBy(xpath = "//span[contains(text(),'3 Monate')]")
    public WebElement helpText2;
    @FindBy(xpath = "//span[contains(text(),'soll deine')]")
    public WebElement WizardTitle2;
    @FindBy(name = "inceptionDate")
    public WebElement datefield;
    @FindBy(xpath = "//span[contains(text(),'Eingabe')]")
    public WebElement valid_Label;
    @FindBy(xpath = "//span[.='Erforderlich']")
    public WebElement required;
    @FindBy(xpath = "//span[contains(text(),'Berechnung')]")
    public WebElement popupMsg;

    @FindBy(xpath = "//span[contains(text(),'Kunden mit')]")
    public WebElement title;
    @FindBy(xpath = "//a/span[contains(text(),'Neustart')]")
    public WebElement restart;




    @FindBy(xpath = "//span[contains(text(),'Alle Hersteller')]")
    public WebElement groupTitle2;
    @FindBy(xpath = "//span[contains(text(),'Probiere')]")
    public WebElement helpText4;
    @FindBy(xpath = "//span[contains(text(),'nur PKW')]")
    public WebElement helpText5;
    @FindBy(xpath = "//button[contains(text(),'Akzeptieren')]")
    public WebElement accept;










}
