package com.portal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reservation.pages.AbstractPage;
import com.reservation.pages.FlightsConfirmationPage;

public class DashboardPage extends AbstractPage {

	private static final Logger log=  LoggerFactory.getLogger(FlightsConfirmationPage.class);
	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "monthly-earning")
	private WebElement monthlyEarning;

	@FindBy(id = "annual-earning")
	private WebElement annualEarning;

	@FindBy(id = "profit-margin")
	private WebElement profitMargin;

	@FindBy(id = "available-inventory")
	private WebElement availableInventory;

	@FindBy(css = "#dataTable_filter input")
	private WebElement search;

	@FindBy(id = "dataTable_info")
	private WebElement noOfEntries;

	@FindBy(css = "#userDropdown img")
	private WebElement profileImage;

	@FindBy(linkText = "Logout")
	private WebElement LogoutMenu;

	@FindBy(css = "#logoutModal a")
	private WebElement LogoutButton;

	@Override
	public boolean isat() {
		wait.until(ExpectedConditions.visibilityOf(monthlyEarning));
		return monthlyEarning.isDisplayed();
	}

	public String getMonthlyEarnings() {

		return this.monthlyEarning.getText();
	}

	public String getAnnualEarnings() {

		return this.annualEarning.getText();
	}
	
	public String getProfitMargin() {

		return this.profitMargin.getText();
	}
	
	public String getAvailableInventory() {

		return this.availableInventory.getText();
	}
	
	public void seachOrderHistory(String searchText) {
		
		this.search.sendKeys(searchText);
	}
	public int getSearchResultCount() {
		
		String fullString =noOfEntries.getText();
		String entriesStr=fullString.split(" ")[5];
		int entries=Integer.parseInt(entriesStr) ;
		log.info(entriesStr);
		return entries;
		
	}
	
	public void logout() {
		
		this.profileImage.click();
		wait.until(ExpectedConditions.visibilityOf(LogoutMenu));
		this.LogoutMenu.click();
		wait.until(ExpectedConditions.visibilityOf(LogoutButton));
		this.LogoutButton.click();
	}
	}

