package com.friday.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SelectVehiclePage extends BasePage{

    @FindBy(xpath = "//span[contains(text(),'Wähle dein')]")
    public WebElement WizardTitle5;
    @FindBy(name = "list")
    public WebElement AusList;
    @FindBy(name = "hsnTsn")
    public WebElement HsnTsn;
    @FindBy(name = "makeFilter")
    public WebElement filter;

    @FindBy(xpath = "//span[contains(text(),'Beliebte')]")
    public WebElement groupTitle1;
    @FindBy(xpath = "(//label[.='BMW'])[1]")
    public WebElement BMW;
   @FindBy(xpath = "//span[contains(text(),'Automodell')]")
    public WebElement WizardTitle6;
  @FindBy(xpath = "//span[contains(text(),'gewählte Modelle')]")
    public WebElement groupTitle2;
  @FindBy(xpath = "//label[.='X5']")
    public WebElement X5;
   @FindBy(xpath = "//span[contains(text(),'tankst')]")
    public WebElement WizardTitle7;
   @FindBy(xpath = "//label[.='Diesel']")
    public WebElement Diesel;
   @FindBy(xpath = "//span[contains(text(),'PS')]")
    public WebElement WizardTitle8;
   @FindBy(xpath = "//label[contains(text(),'160')]")
    public WebElement kW;
    @FindBy(xpath = "//span[contains(text(),'dabei')]")
     public WebElement WizardTitle9;
    @FindBy(xpath = "//label[contains(text(),'XDRIVE')]")
    public WebElement XDRIVE;
    @FindBy(xpath = "//span[contains(text(),'die Erstzulassung?')]")
    public WebElement WizardTitle10;
    @FindBy(name = "monthYearFirstRegistered")
    public WebElement register;
    @FindBy(xpath = "//*[@class='SingleClickListField__optionGroup--MNnWx'][1]//button")
    public List<WebElement> popularManufacturers;
    @FindBy(xpath = "//*[@class='SingleClickListField__optionGroup--MNnWx'][2]//button")
    public List<WebElement> allManufacturers;
    @FindBy(css = ".SingleClickListField__container--2_K04 button")
    public List<WebElement> filteredManufacturers;
    @FindBy(xpath = "//span[contains(text(),'Eingabe')]")
    public WebElement Eingabe;
    @FindBy(name = "monthYearFirstRegistered")
    public WebElement FirstDate;
    @FindBy(name = "birthDate")
    public WebElement birthDate;
    @FindBy(xpath = "//div[contains(text(),'geboren?')]")
    public WebElement birthTitle;
    @FindBy (xpath = "//span[contains(text(),'unwahrscheinlich')]")
    public WebElement Hups;
    @FindBy(xpath = "//span[contains(text(),'der Zukunft')]")
    public WebElement futuremsg;
    @FindBy(xpath = "//span[contains(text(),'Jahre sind')]")
    public WebElement Year;
    @FindBy(xpath = "//span[contains(text(),' Zukunft')]")
    public WebElement futurebirth;

}
