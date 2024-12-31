package com.reservation.tests;

import model.VendorPortalTestData;
import utils.JSONUtil;

public class ReadData {
	VendorPortalTestData vp;

	public ReadData() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		VendorPortalTestData vp = JSONUtil.getTestData("/test-data/vendor-portal-data.json",VendorPortalTestData.class);
		System.out.println(vp.annualEarnings());

	}

}
