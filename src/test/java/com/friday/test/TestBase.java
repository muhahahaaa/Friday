package com.friday.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.friday.pages.SelectPreconditionPage;
import com.friday.utilities.BrowserUtils;
import com.friday.utilities.ConfigurationReader;
import com.friday.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected static ExtentReports report;

    protected static ExtentHtmlReporter htmlReporter;

    protected static ExtentTest extentLogger;
    private TestBase InitializeWebDriver;

    @BeforeTest
    public void setUpTest(){

        report = new ExtentReports();


        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";


        htmlReporter = new ExtentHtmlReporter(path);


        report.attachReporter(htmlReporter);


        htmlReporter.config().setReportName("Friday Test");


        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));

    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        Thread.sleep(3);
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
       driver.get(ConfigurationReader.get("url"));
       new SelectPreconditionPage().accept.click();


    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws InterruptedException, IOException {

        if (result.getStatus()==ITestResult.FAILURE){
            extentLogger.fail(result.getName());
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());

            extentLogger.addScreenCaptureFromPath(screenShotPath);

            extentLogger.fail(result.getThrowable());

        }
        //close driver
        Thread.sleep(2000);
        Driver.closeDriver();
    }

    @AfterTest
    public void tearDownTest(){

        report.flush();



    }
}
