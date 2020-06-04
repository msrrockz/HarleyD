package com.hds.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hds.qa.base.TestBase;

public class HomePage extends TestBase{
	
	
	//Object Repository(Page Objects)
	@FindBy(xpath="//a[contains(@data-dropdown,\"events-dropdown\") and contains(text(),\"Events\")]")
	WebElement eventsDropDown;
	
	
	@FindBy(xpath="//li[contains(@data-ui,\"event-calender-link\")]//a[contains(text(),\"Event Calendar\")]")
	WebElement eventCalendarLink;	


	@FindBy(xpath="//a[contains(text(),\"Vehicles\") and contains(@data-dropdown,\"vehicles-dropdown\")]")
	WebElement vehiclesDropDown;
	
	
	@FindBy(xpath="//a[contains(text(),\"Motorcycles\")]")
	WebElement motorcyclesLink;
	
		
	@FindBy(xpath="//a[contains(text(),\"Harley-Davidson\")]")
	WebElement logo;
	
	//constructor to initialize page elements
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods/Actions
	public String homePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean homePageLogo()
	{
		return logo.isDisplayed();
	}
	
	public EventCalendarPage goToEventCalendarPage()
	{
		eventsDropDown.click();
		eventCalendarLink.click();
		
		return new EventCalendarPage();
	}
	
	public MotorcyclesPage goToMotorcyclesPage()
	{
		vehiclesDropDown.click();
		motorcyclesLink.click();
		
		return new MotorcyclesPage();
	}

}
