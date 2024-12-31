package com.reservation.tests;



import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import utils.ResourceLoader;

public class DummyTest {

	public DummyTest() {

	}

	public static void main(String[] args) throws IOException {
		
		InputStream stream=ResourceLoader.getResource("/test-data/vendor-portal-data.json");
		byte[] content=IOUtils.toByteArray(stream);
		System.out.println(new String(content));
		

	}

}
