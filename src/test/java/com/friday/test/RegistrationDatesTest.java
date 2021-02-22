package com.friday.test;

import com.friday.pages.SelectVehiclePage;
import com.friday.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationDatesTest extends TestBase{
        @Test
    public void ValidDate() throws InterruptedException {
            extentLogger = report.createTest( "Enter valid registration date test");
        SelectVehiclePage selectVehiclePage = new SelectVehiclePage();
            extentLogger.info("Click the 'Weiter' button twice");
        selectVehiclePage.contin.click();
        selectVehiclePage.contin.click();
            extentLogger.info("Select vehicle: BMW,X1,Diesel,85 kW / 116 PS,X1 SDRIVE 16D'");
        Driver.get().findElement(By.xpath("//label[.='BMW']")).click();
        Driver.get().findElement(By.xpath("//label[.='X1']")).click();
        Driver.get().findElement(By.xpath("//label[.='Diesel']")).click();
        Driver.get().findElement(By.xpath("//label[.='85 kW / 116 PS']")).click();
        Driver.get().findElement(By.xpath("//label[.='X1 SDRIVE 16D']")).click();
        Thread.sleep(3);
            extentLogger.info("Enter valid date:02.2000");
       selectVehiclePage.FirstDate.sendKeys("02.2000");
            extentLogger.info("Click the 'Weiter' button ");
       selectVehiclePage.clickCont();
            extentLogger.info("Verify the 'Wann wurdest du geboren?' message");
       Assert.assertEquals(selectVehiclePage.birthTitle.getText(), "Wann wurdest du geboren?");
            extentLogger.info("Enter valid date:28.02.1980");
       selectVehiclePage.birthDate.sendKeys("28.02.1980");
       extentLogger.pass("Enter valid registration date is passed");
    }
    @Test
    public void InvalidRegistrationDate(){
        extentLogger = report.createTest( "Enter invalid registration date test");
        SelectVehiclePage selectVehiclePage = new SelectVehiclePage();
        extentLogger.info("Click the 'Weiter' button twice");
        selectVehiclePage.contin.click();
        selectVehiclePage.contin.click();
        extentLogger.info("Select vehicle: BMW,X1,Diesel,85 kW / 116 PS,X1 SDRIVE 16D'");
        Driver.get().findElement(By.xpath("//label[.='BMW']")).click();
        Driver.get().findElement(By.xpath("//label[.='X1']")).click();
        Driver.get().findElement(By.xpath("//label[.='Diesel']")).click();
        Driver.get().findElement(By.xpath("//label[.='85 kW / 116 PS']")).click();
        Driver.get().findElement(By.xpath("//label[.='X1 SDRIVE 16D']")).click();
        extentLogger.info("Enter valid date:13.2021");
        selectVehiclePage.FirstDate.sendKeys("13.2021", Keys.ENTER);
        extentLogger.info("Verify the 'Hups! Das klingt unwahrscheinlich. Bitte überprüfe deine Eingabe.' message");
      Assert.assertEquals(selectVehiclePage.Hups.getText(),"Hups! Das klingt unwahrscheinlich. Bitte überprüfe deine Eingabe.");
      selectVehiclePage.FirstDate.clear();
        extentLogger.info("Enter valid date:12.2025");
        selectVehiclePage.FirstDate.sendKeys("12.2025", Keys.ENTER);
        extentLogger.info("Verify the 'Hups! Dieses Datum liegt zu weit in der Zukunft. Bitte überprüfe deine Eingabe.");
        Assert.assertEquals(selectVehiclePage.futuremsg.getText(),"Hups! Dieses Datum liegt zu weit in der Zukunft. Bitte überprüfe deine Eingabe.");
        selectVehiclePage.FirstDate.clear();
        extentLogger.info("Enter valid date:01.1980");
        selectVehiclePage.FirstDate.sendKeys("01.1980", Keys.ENTER);
        extentLogger.info("Verify the 'Du kannst leider keine Fahrzeuge bei uns versichern, die älter als 40 Jahre sind.");
        Assert.assertEquals(selectVehiclePage.Year.getText(),"Du kannst leider keine Fahrzeuge bei uns versichern, die älter als 40 Jahre sind.");
        extentLogger.pass("Enter invalid registration date test is passed");
    }
    @Test
    public void BirthDateTest(){
        extentLogger = report.createTest( "Enter birth date test");
        SelectVehiclePage selectVehiclePage = new SelectVehiclePage();
        extentLogger.info("Click the 'Weiter' button twice");
        selectVehiclePage.contin.click();
        selectVehiclePage.contin.click();
        extentLogger.info("Select vehicle: BMW,X1,Diesel,85 kW / 116 PS,X1 SDRIVE 16D'");
        Driver.get().findElement(By.xpath("//label[.='BMW']")).click();
        Driver.get().findElement(By.xpath("//label[.='X1']")).click();
        Driver.get().findElement(By.xpath("//label[.='Diesel']")).click();
        Driver.get().findElement(By.xpath("//label[.='85 kW / 116 PS']")).click();
        Driver.get().findElement(By.xpath("//label[.='X1 SDRIVE 16D']")).click();
        extentLogger.info("Enter valid date:02.2000");
        selectVehiclePage.FirstDate.sendKeys("02.2000", Keys.ENTER);
        extentLogger.info("Click the 'Weiter' button");
        selectVehiclePage.contin.click();
        extentLogger.info("Enter valid date:28.02.1980");
        selectVehiclePage.birthDate.sendKeys("28.02.1980");
        extentLogger.info("Verify that 'Weiter' is clickable");
        Assert.assertTrue(selectVehiclePage.contin.isEnabled());
        selectVehiclePage.birthDate.clear();
        extentLogger.info("Enter invalid date:28.02.1900");
        selectVehiclePage.birthDate.sendKeys("28.02.1900");
        extentLogger.info("Verify the 'Hups! Das klingt unwahrscheinlich. Bitte überprüfe deine Eingabe.");
        Assert.assertEquals(selectVehiclePage.Hups.getText(),"Hups! Das klingt unwahrscheinlich. Bitte überprüfe deine Eingabe.");
        selectVehiclePage.birthDate.clear();
        extentLogger.info("Enter invalid date:28.02.2025");
        selectVehiclePage.birthDate.sendKeys("28.02.2025");
        extentLogger.info("Verify the 'Das Geburtsdatum liegt in der Zukunft.");
        Assert.assertEquals(selectVehiclePage.futuremsg.getText(),"Das Geburtsdatum liegt in der Zukunft.");
        extentLogger.pass("Enter birth date test is passed");



    }
}
