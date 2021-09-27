package com.citrus.myproject;

import org.testng.annotations.Test;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;

@Test
public class SampleBehaviorDemoIT extends TestNGCitrusTestRunner{

	@CitrusTest
	public void test1()
	{
		applyBehavior(new BeforeLogBehavior());
		echo("The test case started for TEST1...");
		applyBehavior(new AfterLogBehavior());
	}
	@CitrusTest
	public void test2()
	{
		applyBehavior(new BeforeLogBehavior());
		echo("The test case started for TEST2...");
		applyBehavior(new AfterLogBehavior());
	}
}
