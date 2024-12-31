package com.reservation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.portal.pages.DashboardPage;
import com.portal.pages.LoginPage;

import model.VendorPortalTestData;
import utils.Config;
import utils.Constants;
import utils.JSONUtil;

public class PortalTest extends AbstractTest {


	private VendorPortalTestData vp;
	
	@BeforeClass
	@Parameters("path")
	public void beforeClass(String path) {
	
	this.vp=JSONUtil.getTestData(path,VendorPortalTestData.class);	
		
	}
	
	@Test
	public void logInTest() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.gotourl(Config.get(Constants.VENDOR_PORTAL_URL));
		loginPage.isat();
		loginPage.login(vp.username(), vp.password());

	}

	@Test(dependsOnMethods = "logInTest")
	public void dashBoardTest() throws InterruptedException {

		DashboardPage dashBoardPage = new DashboardPage(driver);
		dashBoardPage.isat();
		Thread.sleep(10000);
		Assert.assertEquals(dashBoardPage.getMonthlyEarnings(), vp.monthlyEarnings());
		Assert.assertEquals(dashBoardPage.getAnnualEarnings(), vp.annualEarnings());
		Assert.assertEquals(dashBoardPage.getProfitMargin(), vp.profitMargin());
		Assert.assertEquals(dashBoardPage.getAvailableInventory(), vp.availableInventory());
		dashBoardPage.seachOrderHistory(vp.searchKeyWord());
		Assert.assertEquals(dashBoardPage.getSearchResultCount(), vp.resultCount());
		
		dashBoardPage.logout();

	}
	

	

}
