package com.portal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.reservation.pages.AbstractPage;

public class LoginPage extends AbstractPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="username")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login")
	private WebElement login;

	@Override
	public boolean isat() {
		wait.until(ExpectedConditions.visibilityOf(login));
		return this.login.isDisplayed();
	}
	
	public void login(String userName,String password) {
		
		
		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		this.login.click();
	}
	
	public void gotourl(String url) {
		
		driver.get(url);
	}

}
