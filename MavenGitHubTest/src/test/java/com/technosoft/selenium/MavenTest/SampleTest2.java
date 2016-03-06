package com.technosoft.selenium.MavenTest;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingScreen;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SampleTest2 extends AbstractTest {

	private ExtentReports extentReport = null;
	private ExtentTest extentTest = null;
	private String reportPath = "D:\\All Selenium Output\\MavenTest\\report.html";
	public String localFilePath = "D:\\All Selenium Output\\MavenTest\\";
	
//	private String localFilePath = "screenshot/";

	@BeforeSuite
	public void beforeSuite() {
		getInstance();
	}

	@BeforeClass
	public void beforeClassExecution() {
		getDriver();
//		getUrl();
	}
	
	@BeforeMethod
	public void beforeEachTestCase() {
		getUrl();
	}

	@Test(priority = 1)
	public void testMaven() {
		extentTest = extentReport.startTest("Login Verification");
		LandingScreen landingScreen = new LandingScreen(driver);
		
		landingScreen.enterUserName("Mohammad");
		extentTest.log(LogStatus.INFO, "Entered username as Mohammad");
		
		landingScreen.enterPassword("Test1234");
		extentTest.log(LogStatus.INFO, "Entered Password as Test1234");
		
		landingScreen.clickOnLoginButton();
		extentTest.log(LogStatus.INFO, "Clicked on login button");
		
		extentTest.log(LogStatus.PASS, "Login Verification Successful !");
		
		extentReport.endTest(extentTest);
	}
	
	@Test(priority = 2)
	public void testDemo() {
		extentTest = extentReport.startTest("Verify Demo Functions");
		System.out.println("Sample one");
		extentTest.log(LogStatus.PASS, "Step one: Sample one verified");
		System.out.println("Sample two");
		extentTest.log(LogStatus.WARNING, "Step two: unable to verify Sample two ");
		extentTest.log(LogStatus.PASS, "Completed test for Verify Demo Functions");
		extentReport.endTest(extentTest);
	}
	@Test(priority = 2)
	public void TitleTest() {
		extentTest = extentReport.startTest("Verify Application Title");
		LandingScreen landingScreen = new LandingScreen(driver);
		
		landingScreen.verifyTitle("Facebook");
		
		extentTest.log(LogStatus.PASS, "Application Title is verified successfully.");
		
		extentReport.endTest(extentTest);
	}

	@AfterMethod(enabled = true)
	public void handleScreenShot(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshot_path = captureScreenShot(driver, result.getName());
			String image = extentTest.addScreenCapture(screenshot_path);
			extentTest.log(LogStatus.FAIL,
					"Failed Method Name: " + result.getName(), image);
			extentReport.endTest(extentTest);
		}
		getUrl();
	}

	@AfterClass
	public void close() {
		cleanUP();
	}

	@AfterSuite
	public void finalCleanUp() {
		extentReport.flush();
		extentReport.close();
		driver.get(reportPath);
	}

	public String captureScreenShot(WebDriver driver, String screenShotName) {

		try {

			TakesScreenshot screenShot = (TakesScreenshot) driver;
			File source = screenShot.getScreenshotAs(OutputType.FILE);
			String dest = localFilePath + screenShotName + ".png";
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot Taken");
			return dest;
		} catch (Exception e) {
			System.out.println("Exception while taking Screenshot "
					+ e.getMessage());
			return e.getMessage();

		}

	}

	private ExtentReports getInstance() {
		extentReport = new ExtentReports(reportPath, true);
		extentReport.config().documentTitle("Automation Report")
				.reportName("Regression Result")
				.reportHeadline("Report for build #101");
		return extentReport;
	}
}
