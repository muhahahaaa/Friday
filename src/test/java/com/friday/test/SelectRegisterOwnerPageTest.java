package com.friday.test;

import com.friday.pages.SelectPreconditionPage;
import com.friday.pages.SelectRegisterOwnerPage;
import com.friday.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectRegisterOwnerPageTest extends TestBase {


    @Test
    public void Test() {
        extentLogger = report.createTest("Select Registered Owner Test");
        SelectRegisterOwnerPage selectRegisterOwnerPage = new SelectRegisterOwnerPage();
        extentLogger.info("Click the 'Weiter'  button");
       new SelectPreconditionPage().contin.click();
        extentLogger.info("Verify 'Du nutzt dein Auto gewerblich? Tut uns Leid, dann ist FRIDAY leider nichts für dich. Wir versichern nur Privatpersonen.' messages are displayed");
        Assert.assertTrue(selectRegisterOwnerPage.WizardTitle3.isDisplayed());
        extentLogger.info("Verify the 'Ja' button is clickable");
        Assert.assertTrue(selectRegisterOwnerPage.yes.isEnabled());
        extentLogger.info("Verify the 'Nein' button is clickable");
        Assert.assertTrue(selectRegisterOwnerPage.no.isEnabled());
        extentLogger.info("Verify the 'bei Kauf gebraucht' button is clickable");
        Assert.assertTrue(selectRegisterOwnerPage.used.isEnabled());
        extentLogger.info("Verify the 'bei Kauf neu' button is clickable");
        Assert.assertTrue(selectRegisterOwnerPage.brandNew.isEnabled());
        extentLogger.pass("Select Registered Owner Test passed");

    }
    @Test
    public void BackButtonTest(){
        extentLogger = report.createTest("Back Button Test");
        SelectRegisterOwnerPage selectRegisterOwnerPage = new SelectRegisterOwnerPage();
        extentLogger.info("Click the 'Weiter'  button");
        new SelectPreconditionPage().contin.click();
        extentLogger.info("Click the 'Zurück'  button");
        selectRegisterOwnerPage.back.click();
        extentLogger.info("Verify the URL");
        Assert.assertEquals(Driver.get().getCurrentUrl(),"https://hello.friday.de/quote/selectPrecondition");
        extentLogger.pass("Back Button Test passed");
    }


}