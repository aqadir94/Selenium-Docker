package com.reservation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmationPage extends AbstractPage {

	public RegistrationConfirmationPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(id = "go-to-flights-search")
	private WebElement goToSearch;

	@FindBy(css = "#registration-confirmation-section div b")
	private WebElement name;

	public void goToSearchPage() {

		goToSearch.click();

	}

	@Override
	public boolean isat() {
		wait.until(ExpectedConditions.visibilityOf(goToSearch));
		return goToSearch.isDisplayed();
	}

	public String getName() {
		
		return this.name.getText();
		

	}

}
