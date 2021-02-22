package com.friday.test;

import com.friday.pages.SelectPreconditionPage;
import com.friday.utilities.BrowserUtils;
import com.friday.utilities.Driver;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;

public class SelectPreconditionTest extends TestBase {

    @Test
    public void TitleTest() {
        extentLogger = report.createTest("PageTitle Test");
        SelectPreconditionPage selectPreconditionPage= new SelectPreconditionPage();
        extentLogger.info("Verify page title");
        Assert.assertEquals(Driver.get().getTitle(),"FRIDAY Autoversicherung. In nur 90 Sekunden zu deinem Angebot!");
         extentLogger.pass("Page title test is passed");
    }
    @Test
    public void InsuredCarTest() {
        extentLogger = report.createTest("Car Insured Test");
        SelectPreconditionPage selectPreconditionPage = new SelectPreconditionPage();
        extentLogger.info(" Select 'Das Auto ist schon versichert' button");
        selectPreconditionPage.radiobtn1.click();
        extentLogger.info("Enter valid date:25.03.2021");
        selectPreconditionPage.datefield.sendKeys("25.03.2021");
        extentLogger.info("Verify the 'Weiter' button is clickable");
        Assert.assertTrue(selectPreconditionPage.contin.isEnabled());
        extentLogger.info("Click the 'Weiter'  button");
        selectPreconditionPage.contin.click();
        extentLogger.info("Verify the URL");
        Assert.assertEquals( Driver.get().getCurrentUrl(),"https://hello.friday.de/quote/selectRegisteredOwner");
        extentLogger.pass("Insured CarTest is passed");


    }
    @Test
    public void Re_registeredCarTest(){
        extentLogger = report.createTest("Re_registered CarTest");
        SelectPreconditionPage selectPreconditionPage = new SelectPreconditionPage();
        extentLogger.info("  Select 'Das Auto wird noch zugelassen oder umgemeldet' button");
        selectPreconditionPage.radiobtn2.click();
        extentLogger.info("Verify that text messages are displayed");
        Assert.assertTrue(selectPreconditionPage.helpText1.isDisplayed());
        Assert.assertTrue(selectPreconditionPage.helpText2.isDisplayed());
        extentLogger.info("Enter valid date:25.03.2021");
        selectPreconditionPage.datefield.sendKeys("25.03.2021");
        extentLogger.info("Verify the 'Weiter' button is clickable");
        Assert.assertTrue(selectPreconditionPage.contin.isEnabled());
        extentLogger.info("Click the 'Weiter'  button");
        selectPreconditionPage.contin.click();
        extentLogger.info("Verify the URL");
        Assert.assertEquals( Driver.get().getCurrentUrl(),"https://hello.friday.de/quote/selectRegisteredOwner");
        extentLogger.pass("Insured CarTest is passed");


    }

    @DataProvider
    public Object [][] testData(){
        String [][] data = new String[][]{
                {"31.09.1998"},
                {"31.11.2021"},
                {"28.0x.2021"},
                {"28.02.20xx"},
                {"02.11.20"},
                {"2020.11.02"},
                {"20.A.2021"},
                {"30.02.2021"},
                {"29.02.2022"},
                };

        return data;
    }


    @Test(dataProvider = "testData")
    public void InvalidDateTest(String date)  {
        extentLogger = report.createTest( "Invalid Insurance Start Date");
        SelectPreconditionPage selectPreconditionPage = new SelectPreconditionPage();
        selectPreconditionPage.datefield.clear();
        extentLogger.info("Enter invalid date:"+ date);
        selectPreconditionPage.datefield.sendKeys(date);
        BrowserUtils.waitFor(5);
        extentLogger.info("Verify 'Hups, das hat leider nicht funktioniert. Bitte überprüfe deine Eingabe' message should be displayed");
        Assert.assertTrue(selectPreconditionPage.valid_Label.isDisplayed());
        extentLogger.info("Verify that  'Weiter' button is not clickable");
        Assert.assertFalse(selectPreconditionPage.contin.isEnabled());
        extentLogger.pass("Insured CarTest is passed");

    }


    @Test
    public void EmptyDateTest(){
        extentLogger = report.createTest( "Empty Date");
        SelectPreconditionPage selectPreconditionPage = new SelectPreconditionPage();
        selectPreconditionPage.datefield.clear();
        extentLogger.info("Leave the date field empty");
        selectPreconditionPage.datefield.sendKeys("");
        extentLogger.info("Verify 'Erforderlich' message should be displayed");
        Assert.assertTrue(selectPreconditionPage.required.isDisplayed());
        extentLogger.pass("Empty Date Test is passed");

    }
    @Test
    public void EnterKeyTest(){
        extentLogger = report.createTest( "Enter Key Funcionality");
        SelectPreconditionPage selectPreconditionPage = new SelectPreconditionPage();
        selectPreconditionPage.datefield.clear();
        extentLogger.info("Enter valid date:31.03.2021");
        selectPreconditionPage.datefield.sendKeys("31.03.2021",Keys.ENTER);
        extentLogger.info("Verify the URL");
        Assert.assertEquals( Driver.get().getCurrentUrl(),"https://hello.friday.de/quote/selectRegisteredOwner");
        extentLogger.pass("Enter Key Test is passed");
    }
    @Test
    public void PopupTest1() throws InterruptedException {
        extentLogger = report.createTest( "Popup Test");
        SelectPreconditionPage selectPreconditionPage = new SelectPreconditionPage();
        extentLogger.info("Click the 'Friday' button");
        selectPreconditionPage.logo.click();
        extentLogger.info("Verify the URL");
        Assert.assertEquals(Driver.get().getCurrentUrl(),"https://hello.friday.de/redirectModal");
        extentLogger.info("Verify 'Zurück zur FRIDAY Homepage oder Berechnung neu starten: Was möchtest du tun?' message should be displayed");
        Assert.assertEquals(selectPreconditionPage.popupMsg.getText(),"Zurück zur FRIDAY Homepage oder Berechnung neu starten: Was möchtest du tun?");
        extentLogger.info("Click the 'Homepage' button");
        selectPreconditionPage.Homepage.click();
        extentLogger.info("Verify the URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.friday.de/");
        extentLogger.pass("Popup Test is passed");
    }
    @Test
    public void PopupTest2(){
        extentLogger = report.createTest( "Popup Test2");
        SelectPreconditionPage selectPreconditionPage = new SelectPreconditionPage();
        extentLogger.info("Click the 'Friday' button");
        selectPreconditionPage.logo.click();
        extentLogger.info("Verify the URL");
        Assert.assertEquals(Driver.get().getCurrentUrl(),"https://hello.friday.de/redirectModal");
        extentLogger.info("Click the 'restart' button");
        selectPreconditionPage.restart.click();
        extentLogger.info("Verify the URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://hello.friday.de/quote/selectPrecondition");
        extentLogger.pass("Popup Test2 is passed");
    }





}