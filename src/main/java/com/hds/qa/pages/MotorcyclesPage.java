package com.hds.qa.pages;

import java.util.NoSuchElementException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hds.qa.base.TestBase;

public class MotorcyclesPage extends TestBase{
	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	
	//Object Repository
	
	@FindBy(xpath = "//a[contains(@data-target,\"street\")]")
	@CacheLookup
	WebElement streetLink;
	
	@FindBy(xpath = "//a[contains(@data-target,\"sportster\")]")
	@CacheLookup
	WebElement sportsterLink;
	
	@FindBy(xpath = "//a[contains(@data-target,\"softail\")]")
	@CacheLookup
	WebElement softtailLink;
	
	@FindBy(xpath = "//a[contains(@data-target,\"touring\")]")
	@CacheLookup
	WebElement touringLink;
	
	@FindBy(xpath = "//a[contains(@data-target,\"cvo\")]")
	@CacheLookup
	WebElement cvoLink;
	
	@FindBy(xpath = "//a//img[contains(@alt,\"2019 Harley-Davidson Motorcycle Lineup\")]")
	WebElement motorcycles2019IMGLink;
	
	@FindBy(xpath = "//a//img[contains(@alt,\"LiveWire motorcycle\")]")
	WebElement futureMotorcyclesIMGLink;
	
	
	@FindBy(xpath = "//a[contains(text(),\"LEARN ABOUT harley-Davidson Street\")]")
	WebElement learnAboutStreetLink;
	
	@FindBy(xpath = "//a[contains(text(),\"LEARN ABOUT SPORTSTER\")]")
	WebElement learnAboutSportsterLink;
	
	@FindBy(xpath = "//a[contains(text(),\"LEARN ABOUT SOFTAIL\")]")
	WebElement learnAboutSoftailtLink;
		
	//Constructor - initialize page elements
	public MotorcyclesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String pageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateVehiclesModelsLinks()
	{
		Boolean s1 = streetLink.isDisplayed();
		Boolean s2 = sportsterLink.isDisplayed();
		Boolean s3 = softtailLink.isDisplayed();
		Boolean s4 = touringLink.isDisplayed();
		Boolean s5 = cvoLink.isDisplayed();
		
		if(s1 && s2 && s3 && s4 && s5)
		{
			return true;
		}else {
			return false;
		}
	
	}
	
	public boolean bottomPageIMGLinks()
	{
		Boolean s1 = motorcycles2019IMGLink.isDisplayed();
		Boolean s2 = futureMotorcyclesIMGLink.isDisplayed();
		if(s1 && s2)
		{
			return true;
		}else {
			return false;
		}
	
	}
	
	public void verifyCategoriesPageTitle(String category)
	{
		if( category.equals("Street"))
		{
			
			executor.executeScript("arguments[0].click();", streetLink);	
			//streetLink.click();
			learnAboutStreetLink.click();
			System.out.println(driver.getTitle());
		}else if( category.equals("Softail"))
		{
			executor.executeScript("arguments[0].click();", softtailLink);	
			//softtailLink.click();
			learnAboutSoftailtLink.click();
			System.out.println(driver.getTitle());
		}else if( category.equals("Sportster"))
		{
			executor.executeScript("arguments[0].click();", sportsterLink);
			//sportsterLink.click();
			learnAboutSportsterLink.click();
			System.out.println(driver.getTitle());
		}
	}

}
