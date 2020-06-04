package com.hds.qa.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hds.qa.base.TestBase;
import com.hds.qa.pages.EventCalendarPage;
import com.hds.qa.pages.HomePage;
import com.hds.qa.pages.MotorcyclesPage;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTest extends TestBase{
	
	HomePage homePageObj;
	public ExtentTest extentTest;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		extentTest = new ExtentTest("","");		

		homePageObj = new HomePage();
	}
	
	@Test(priority=1,groups="pageValidation")
	public void homePageTitleTest() {
		
		String actualTitle = homePageObj.homePageTitle();
		assertEquals(actualTitle, "HarleyDavidson India");
	}
	
	@Test(priority=2,groups="pageValidation")
	public void homePageLogoTest() {

		Boolean logo = homePageObj.homePageLogo();
		assertTrue(logo);
	}
	
	@Test(priority=3,groups="pageNavigation")
	public void goToEventCalendarPageTest() {

		EventCalendarPage eventCalendarPageObj = homePageObj.goToEventCalendarPage();
	}
	
	@Test(priority=4,groups="pageNavigation")
	public void goToMotorcyclesPage() {

		MotorcyclesPage motorcyclesPageObj = homePageObj.goToMotorcyclesPage();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
	
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			//String screenshotPath = FreeCRMTest.getScreenshot(driver, result.getName());
			
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File sourceFile = ts.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + result.getName() + dateName
					+ ".png";
			File destinationFile = new File(destination);
			FileUtils.copyFile(sourceFile, destinationFile);
			
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(destination)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}
				
		driver.quit();
	}

}
