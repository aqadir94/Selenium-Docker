package com.reservation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlightsConfirmationPage extends AbstractPage {

	private static final Logger log=  LoggerFactory.getLogger(FlightsConfirmationPage.class);
	public FlightsConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".card-body div:nth-child(3) p")
	WebElement totalPrice;

	@FindBy(xpath = "//div[contains(text(),'Flight')]/following-sibling::div")
	WebElement confirmationNumber;

	@Override
	public boolean isat() {
		wait.until(ExpectedConditions.visibilityOf(confirmationNumber));
		return confirmationNumber.isDisplayed();
	}

	public String getPrice() {

		String confirmationNumber=this.confirmationNumber.getText();
		String price =this.totalPrice.getText();
		log.info("Flight confirmation number {}", confirmationNumber);
		log.info("Price is {}", price);
		
		return price;
	}

}
