package com.reservation.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class justATest extends AbstractTest{

	private String noOfpass; 
	private String expectedPrice;
	
	
//	@BeforeTest
//	@Parameters({"noOfpass","expectedPrice"})
//	public void beforeTest(String noOfpass,String expectedPrice ) {
//		
//		
//		this.expectedPrice=expectedPrice;
//		this.noOfpass=noOfpass;
//	}
	
@Test
@Parameters({"noOfpass","expectedPrice"})
public void test(String noOfpass,String expectedPrice ) {
	
	
	System.out.println(noOfpass+" "+expectedPrice);
}
}
