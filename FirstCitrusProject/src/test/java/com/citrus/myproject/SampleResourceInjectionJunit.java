package com.citrus.myproject;

import org.junit.Test;
import org.testng.annotations.Optional;


import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.design.TestDesigner;
import com.consol.citrus.dsl.junit.JUnit4CitrusTest;
import com.consol.citrus.dsl.runner.TestRunner;
import com.consol.citrus.dsl.testng.TestNGCitrusTest;


public class SampleResourceInjectionJunit extends JUnit4CitrusTest
{

	@CitrusTest
	@Test
	public void injectDesigner( @CitrusResource TestDesigner designer)
	{
		designer.echo(("Before junit"));
		System.out.println("Its a print statement");
		designer.echo(("After"));
	}
	
	@CitrusTest
	@Test
	public void injectRunner( @CitrusResource TestRunner runner)
	{
		runner.echo(("Before junit"));
		System.out.println("Its a print statement");
		runner.echo(("After"));
	}
	
}
