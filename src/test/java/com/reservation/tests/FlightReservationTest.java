package com.reservation.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.reservation.pages.FlightSearchPage;
import com.reservation.pages.FlightsConfirmationPage;
import com.reservation.pages.RegistrationConfirmationPage;
import com.reservation.pages.RegistrationPage;
import com.reservation.pages.SelectFlightsPage;

import model.CustomerModelTestData;
import utils.Config;
import utils.Constants;
import utils.JSONUtil;
import utils.ResourceLoader;

public class FlightReservationTest extends AbstractTest {

	private String expectedPrice;
	private static final Logger log = LoggerFactory.getLogger(FlightReservationTest.class);
	private CustomerModelTestData customerData;

	@BeforeClass
	@Parameters({ "path" })
	public void beforeMethod(String path) {

		this.customerData = JSONUtil.getTestData(path, CustomerModelTestData.class);

	}

	@Test
	public void registrationTest() {

		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.goToURL(Config.get(Constants.FLIGHT_RESERVATION_URL));
		Assert.assertTrue(registrationPage.isat());
		registrationPage.enterDetails(this.customerData.firstName(), this.customerData.lastName(),
				this.customerData.email(), this.customerData.password(), this.customerData.street(),
				this.customerData.city(), this.customerData.state(), this.customerData.zip());

	}

	@Test(dependsOnMethods = "registrationTest")
	public void registrationConfirmationTest() {

		RegistrationConfirmationPage regConfPage = new RegistrationConfirmationPage(driver);
		regConfPage.isat();
		Assert.assertEquals(regConfPage.getName(), customerData.firstName());
		regConfPage.goToSearchPage();

	}

	@Test(dependsOnMethods = "registrationConfirmationTest")
	public void flightSearchTest() {

		FlightSearchPage fltSearch = new FlightSearchPage(driver);
		fltSearch.isat();
		fltSearch.searchFlight(this.customerData.passengersCount());

	}

	@Test(dependsOnMethods = "flightSearchTest")
	public void flightSelectTest() {

		SelectFlightsPage selFlights = new SelectFlightsPage(driver);
		selFlights.isat();
		selFlights.selectDepartureflt("emirates-business");
		selFlights.selectArrivalflt("qatar-first");

	}

	@Test(dependsOnMethods = "flightSelectTest")
	public void flightConfirmationTest() {

		FlightsConfirmationPage fltConfPage = new FlightsConfirmationPage(driver);
		Assert.assertTrue(fltConfPage.isat());
		Assert.assertEquals(fltConfPage.getPrice(), this.customerData.expectedPrice());
	}

}
