package com.reservation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends AbstractPage {

	public RegistrationPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(id = "firstName")
	private WebElement txt_FirstName;

	@FindBy(id = "lastName")
	private WebElement txt_LastName;

	@FindBy(id = "email")
	private WebElement txt_Email;

	@FindBy(id = "password")
	private WebElement txt_Password;

	@FindBy(name = "street")
	private WebElement txt_Street;

	@FindBy(name = "city")
	private WebElement txt_City;

	@FindBy(name = "zip")
	private WebElement txt_Zip;

	@FindBy(id = "register-btn")
	private WebElement btn_Register;

	@FindBy(id = "inputState")
	private WebElement drp_State;

	public void goToURL(String url) {
		this.driver.get(url);

	}

	public void enterDetails(String firstName, String lastName, String email, String password, String street,
			String city, String state, String zip) {

		Select select = new Select(drp_State);

		this.txt_FirstName.sendKeys(firstName);
		this.txt_LastName.sendKeys(lastName);
		this.txt_Email.sendKeys(email);
		this.txt_Password.sendKeys(password);
		this.txt_Street.sendKeys(street);
		select.selectByVisibleText(state);
		this.txt_City.sendKeys(city);
		this.txt_Zip.sendKeys(zip);
		this.btn_Register.click();

	}

	@Override
	public boolean isat() {
		wait.until(ExpectedConditions.visibilityOf(btn_Register));
		return btn_Register.isDisplayed();
	}

}
