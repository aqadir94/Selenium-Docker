package com.reservation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SelectFlightsPage extends AbstractPage {

	public SelectFlightsPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(name = "departure-flight")
	List<WebElement> departureFlights;

	@FindBy(name = "arrival-flight")
	List<WebElement> arrivalFlights;

	@FindBy(id = "confirm-flights")
	WebElement btn_ConfirmFlights;

	@Override
	public boolean isat() {
		wait.until(ExpectedConditions.visibilityOf(btn_ConfirmFlights));
		return btn_ConfirmFlights.isDisplayed();
	}

	public void selectDepartureflt(String flt) {

		for (WebElement ele : departureFlights) {

			String value = ele.getAttribute("value");
			if (value == flt) {

				ele.click();
			}

		}
	}

	public void selectArrivalflt(String flt) {

		for (WebElement ele : arrivalFlights) {

			String value = ele.getAttribute("value");
			if (value == flt) {

				ele.click();
			}

		}
			this.btn_ConfirmFlights.click();
	}

}
