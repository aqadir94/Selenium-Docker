package com.reservation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends AbstractPage {

	public FlightSearchPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(id="oneway")
	private WebElement oneWay;
	
	@FindBy(id="search-flights")
	private WebElement searchFlights;
	
	@FindBy(id="passengers")
	private WebElement noOFPass;
	

	@Override
	public boolean isat() {
		wait.until(ExpectedConditions.elementToBeClickable(searchFlights));
		return searchFlights.isDisplayed();
	}
	
	public void searchFlight(String noOfPassengers)  {
		
		Select select =new Select(noOFPass);
		select.selectByValue(noOfPassengers);
		this.oneWay.click();
	
		searchFlights.click();
	}

}
