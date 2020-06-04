package com.hds.qa.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hds.qa.base.TestBase;

public class EventCalendarPage extends TestBase{
	
	@FindBy(xpath="//input[contains(@placeholder,\"City, State or ZIP Code\")]")
	WebElement placeHolderInput;
	
	@FindBy(xpath="//p[starts-with(@data-value,\"lat\")]")
	WebElement selectPlace;
	
	@FindBy(xpath="//div[contains(text(),'EVENT TYPE')]//parent::div")
	WebElement eventTypeDD;
	
	@FindBy(xpath="//p[contains(@data-value,\"115\")]")
	WebElement eventType;
	
	@FindBy(xpath="//div[contains(text(),'Date')]//parent::div")
	WebElement dateDD;
	
	
	@FindBy(xpath="//p[contains(@data-value,\"month\")]")
	WebElement dateInput;
	
	@FindBy(xpath="//div[contains(text(),'Distance')]//parent::div")
	WebElement distanceDD;
	
	@FindBy(xpath="//p[contains(@data-value,\"100km\")]")
	WebElement distanceInput;
		
	@FindBy(xpath="//button[contains(@title,\"Find Events\")]")
	WebElement findEventsButton;
	
	public EventCalendarPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void findEvents()
	{
		placeHolderInput.sendKeys("560040");
	//	new WebDriverWait(driver, 20).ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(selectPlace));
	//	selectPlace.click();
		eventTypeDD.click();
		eventType.click();
		dateDD.click();
		dateInput.click();
		distanceDD.click();
		distanceInput.click();
		findEventsButton.click();
			
	}
	
	
}
