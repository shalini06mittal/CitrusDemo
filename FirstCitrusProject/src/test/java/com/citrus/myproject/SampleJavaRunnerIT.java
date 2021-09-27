package com.citrus.myproject;

import org.testng.annotations.Test;

import com.consol.citrus.actions.AbstractTestAction;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.junit.JUnit4CitrusTestDesigner;
import com.consol.citrus.dsl.junit.JUnit4CitrusTestRunner;
import com.consol.citrus.dsl.testng.TestNGCitrusTestDesigner;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;

import utils.LoggingService;

//@Test
public class SampleJavaRunnerIT extends JUnit4CitrusTestRunner {

	LoggingService obj = new LoggingService();
	@org.junit.Test
	@CitrusTest
	public void testLogService()
	{
		echo("Before log called");
		obj.logs("Logs will be printed...");

		echo("After log called");

	}

}
