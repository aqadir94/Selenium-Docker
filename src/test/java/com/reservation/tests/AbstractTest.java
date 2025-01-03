package com.reservation.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.TestListener;
import utils.Config;
import utils.Constants;

@Listeners({TestListener.class})
public class AbstractTest {

	private static Logger log = LoggerFactory.getLogger(AbstractTest.class);
	protected WebDriver driver;
	
	@BeforeSuite
	public void beforeSuite() {
		
		Config.initialize();
	}

	@BeforeTest
	public void beforeTest(ITestContext ctx) throws MalformedURLException {

		this.driver = Boolean.parseBoolean(Config.get(Constants.GRID_ENABLED)) ? getRemoteDriver() : getLocalDriver();
		ctx.setAttribute(Constants.DRIVER, this.driver);
	}

	private WebDriver getRemoteDriver() throws MalformedURLException {

		Capabilities capabilities = new ChromeOptions();

		if (Constants.FIREFOX.equalsIgnoreCase(Config.get(Constants.BROWSER))) {

			capabilities = new FirefoxOptions();
		}

		String urlFormat = Config.get(Constants.GRID_URL_FORMAT);
		String hubHost = Config.get(Constants.GRID_HUB_HOST);
		String url = String.format(urlFormat, hubHost);

		log.info("Grid url: {}", url);
		return new RemoteWebDriver(new URL(url), capabilities);

	}

	private WebDriver getLocalDriver() {

		if(Config.get("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
			
		}
		
		else {
			
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
		}
	}

	@AfterTest
	public void afterTest() {

		driver.quit();

	}

}
