package com.hds.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hds.qa.base.TestBase;
import com.hds.qa.pages.EventCalendarPage;
import com.hds.qa.pages.HomePage;

public class EventCalenderPageTest extends TestBase{
	
	HomePage homePageObj;
	EventCalendarPage eventCalendarPageObj;
		
	
	public EventCalenderPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homePageObj = new HomePage();
	}
	

	@Test
	public void findEvents() {
		eventCalendarPageObj = homePageObj.goToEventCalendarPage();
		eventCalendarPageObj.findEvents();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
