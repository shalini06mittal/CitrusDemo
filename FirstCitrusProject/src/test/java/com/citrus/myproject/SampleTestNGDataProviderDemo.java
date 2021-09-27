package com.citrus.myproject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import com.consol.citrus.testng.CitrusParameters;


public class SampleTestNGDataProviderDemo extends TestNGCitrusTestRunner{

	@CitrusTest
	@CitrusParameters("message")
	@Test(dataProvider = "messages")
	public void testDataProviders(String message)
	{
		echo("${message}");
	}
	@DataProvider
	public Object[][] messages()
	{
		return new Object[][]{
			{"hello"},
			{"welcome"},
			{"bye"},
		};
	}
}
