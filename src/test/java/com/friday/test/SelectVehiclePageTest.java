package com.friday.test;

import com.friday.pages.SelectModelPage;
import com.friday.pages.SelectPreconditionPage;
import com.friday.pages.SelectRegisterOwnerPage;
import com.friday.pages.SelectVehiclePage;
import com.friday.utilities.BrowserUtils;
import com.friday.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectVehiclePageTest extends TestBase {

    @Test
    public void PopularManufacturersTest() {
        extentLogger = report.createTest("Popular Manufacturers Test");
        SelectVehiclePage selectVehiclePage = new SelectVehiclePage();
        extentLogger.info("Click the 'Weiter' button twice");
        selectVehiclePage.contin.click();
        selectVehiclePage.contin.click();
        List<String> popularManufacturersText = BrowserUtils.getElementsText(selectVehiclePage.popularManufacturers);
        List<String> actualManufacturersText = new ArrayList<String>(Arrays.asList("VW", "OPEL", "BMW", "FORD", "AUDI", "MERCEDES-BENZ"));
        extentLogger.info("Verify the popular manufacturers");
        Assert.assertEquals(popularManufacturersText, actualManufacturersText);
        for (WebElement s : selectVehiclePage.popularManufacturers) {
            extentLogger.info("Verify that 'Brands' are clickable");
            Assert.assertTrue(s.isEnabled());

        }
        extentLogger.pass("Popular Manufacturers Test is passed");

    }

    @DataProvider
    public Object[][] validData() {
        String[][] data = new String[][]{
                {"a"},
                {"B"},
                {"Op"},
                {"AUDI"},
        };

        return data;
    }

    @Test(dataProvider = "validData")
    public void ValidFilterSelectionTest(String data) {
        extentLogger = report.createTest("Filter Selection With Valid Inputs Test");
        SelectVehiclePage selectVehiclePage = new SelectVehiclePage();
        extentLogger.info("Click the 'Weiter' button twice");
        selectVehiclePage.contin.click();
        selectVehiclePage.contin.click();
        extentLogger.info("Enter valid input:"+ data);
        selectVehiclePage.filter.sendKeys(data);
        List<String> elementsText = BrowserUtils.getElementsText(selectVehiclePage.filteredManufacturers);
        for (String brands : elementsText) {
            data = data.toUpperCase();
            extentLogger.info("Verify the filtered car models include "+ data);
            Assert.assertTrue(brands.contains(data));
        }
        extentLogger.pass("Filter Selection With Valid Inputs Test is passed");
    }

    @DataProvider
    public Object[][] invalidData() {
        String[][] data = new String[][]{
                {"$"},
                {"@"},
                {"9"},
                {"["},
                {"B M"},
                {"Opelx"}
        };

        return data;
    }

    @Test(dataProvider = "invalidData")
    public void InvalidFilterSelectionTest(String data) {
        extentLogger = report.createTest("Filter Selection With Invalid Inputs Test");
        SelectVehiclePage selectVehiclePage = new SelectVehiclePage();
        extentLogger.info("Click the 'Weiter' button twice");
        selectVehiclePage.contin.click();
        selectVehiclePage.contin.click();
        extentLogger.info("Enter invalid input:"+ data);
        selectVehiclePage.filter.sendKeys(data);
        extentLogger.info("Verify 'Diese Marke ist uns nicht bekannt. Bitte überprüfe deine Eingabe' message");
        Assert.assertEquals(selectVehiclePage.Eingabe.getText(), "Diese Marke ist uns nicht bekannt. Bitte überprüfe deine Eingabe.");
        extentLogger.pass("Filter Selection With Invalid Inputs Test is passed");
    }

    @Test
    public void AllManufacturersTest() {
        extentLogger = report.createTest("All Manufacturers Test");
        SelectVehiclePage selectVehiclePage = new SelectVehiclePage();
        extentLogger.info("Click the 'Weiter' button twice");
        selectVehiclePage.contin.click();
        selectVehiclePage.contin.click();
        List<String> allManufacturersText = BrowserUtils.getElementsText(selectVehiclePage.allManufacturers);
        List<String> actualAllManufacturersText = new ArrayList<String>(Arrays.asList("ALFA ROMEO", "ALPINA", "AUDI", "AUSTIN", "BARKAS", "BMW", "CADILLAC", "CHEVROLET", "CHRYSLER", "CITROEN", "CORVETTE", "CUPRA", "DACIA", "DAEWOO", "DAF", "DAIHATSU", "DODGE", "FIAT", "FORD", "HDPIC", "HONDA", "HYUNDAI", "INFINITI", "ISUZU", "IVECO", "JAGUAR", "JEEP", "KIA", "LADA", "LANCIA", "LAND ROVER", "LANDWIND", "LDV", "LEXUS", "MASERATI", "MAZDA", "MERCEDES-BENZ", "MG", "MINI (BMW)", "MINI (ROVER)", "MITSUBISHI", "NISSAN", "OPEL", "PEUGEOT", "POLESTAR", "PONTIAC", "PORSCHE", "PROTON", "RENAULT", "ROVER", "SAAB", "SEAT", "SKODA", "SMART", "SSANGYONG", "SUBARU", "SUZUKI", "TALBOT", "TESLA", "TOYOTA", "VOLVO", "VW"));
        extentLogger.info("Verify the all manufacturers");
        Assert.assertEquals(allManufacturersText, actualAllManufacturersText);
        extentLogger.pass("All Manufacturers Test is passed");
    }


    @DataProvider
    public Object[][] carData() {
        String[][] data = new String[][]{
                {"BMW", "X1", "Diesel", "85 kW / 116 PS", "X1 SDRIVE 16D"},
                {"BMW", "X2", "Benzin", "100 kW / 136 PS", "X2 18I SDRIVE"},
                {"BMW", "X3", "Diesel", "130 kW / 177 PS", "X3 2.0D"},
                {"VW", "Tiguan", "Diesel", "81 kW / 110 PS", "TIGUAN 2.0 TDI"},
                {"VW", "Touran", "Gas", "80 kW / 109 PS", "TOURAN 2.0 ECO FUEL"},
                {"VW", "Sharan", "Diesel", "110 kW / 150 PS", "SHARAN 1.9 TDI"},
                {"JEEP", "Renegade", "Diesel", "103 kW / 140 PS", "JEEP RENEGADE 2.0 D AWD"},
                {"JEEP", "Compass", "Benzin", "115 kW / 156 PS", "JEEP COMPASS 2.0"},
                {"JEEP", "Patriot", "Diesel", "103 kW / 140 PS", "JEEP COMPASS/PATRIOT 2.0 CRD"}

        };
        return data;
    }

    @Test(dataProvider = "carData")
    public void SelectingCarTest(String brand, String model, String fuelType, String enginePower, String engine) throws InterruptedException {
        extentLogger = report.createTest("Select Vehicle Test");
        SelectVehiclePage selectVehiclePage = new SelectVehiclePage();
        extentLogger.info("Click the 'Weiter' button twice");
        selectVehiclePage.contin.click();
        selectVehiclePage.contin.click();
        extentLogger.info("Select brand:"+ brand);
        Driver.get().findElement(By.xpath("//label[.='" + brand + "']")).click();
        extentLogger.info("Select model:"+ model);
        Driver.get().findElement(By.xpath("//label[.='" + model + "']")).click();
        extentLogger.info("Select fuelType:"+ fuelType);
        Driver.get().findElement(By.xpath("//label[.='" + fuelType + "']")).click();
        extentLogger.info("Select enginePower:"+ enginePower);
        Driver.get().findElement(By.xpath("//label[.='" + enginePower + "']")).click();
        extentLogger.info("Select engine:"+ engine);
        Driver.get().findElement(By.xpath("//label[.='" + engine + "']")).click();
        Thread.sleep(3);
        extentLogger.info("Verify the 'Wann war die Erstzulassung?' message");
        Assert.assertEquals(selectVehiclePage.WizardTitle10.getText(), "Wann war die Erstzulassung?");
        extentLogger.pass("Select Vehicle Test is passed");
    }
    }



