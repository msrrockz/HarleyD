package com.hds.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hds.qa.base.TestBase;
import com.hds.qa.pages.HomePage;
import com.hds.qa.pages.MotorcyclesPage;
import com.hds.qa.utils.TestUtil;

import java.lang.*;

public class MotorcyclesPageTest extends TestBase{
	
	HomePage homePageObj;
	MotorcyclesPage motorcyclesPageObj;
	
	String sheetName = "categories";
	
	public MotorcyclesPageTest()
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
	public void motocyclesPageTileTest() {

		motorcyclesPageObj = homePageObj.goToMotorcyclesPage();
		String pageTitle = motorcyclesPageObj.pageTitle();
		
		Assert.assertEquals(pageTitle, "2020 Motorcycle Lineup | Harley-Davidson India");
	}
	
	@Test
	public void vehiclesModelsLinksTest() {

		motorcyclesPageObj = homePageObj.goToMotorcyclesPage();
		Boolean links = motorcyclesPageObj.validateVehiclesModelsLinks();
		
		Assert.assertTrue(links);
	}
	
	@Test
	public void bottomPageIMGLinksTest() {

		motorcyclesPageObj = homePageObj.goToMotorcyclesPage();
		Boolean links = motorcyclesPageObj.bottomPageIMGLinks();
		
		Assert.assertTrue(links);
	}
	
	@DataProvider
	public Object[][] getCatsData()
	{
		return TestUtil.getTestData(sheetName);
	}
	
	@Test(priority=1, dataProvider = "getCatsData")
	public void clickOnCats(String cats)
	{
		motorcyclesPageObj = homePageObj.goToMotorcyclesPage();
		motorcyclesPageObj.verifyCategoriesPageTitle(cats);
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
