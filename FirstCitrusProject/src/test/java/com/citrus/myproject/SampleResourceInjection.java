package com.citrus.myproject;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.design.TestDesigner;
import com.consol.citrus.dsl.runner.TestRunner;
import com.consol.citrus.dsl.testng.TestNGCitrusTest;

@Test
public class SampleResourceInjection extends TestNGCitrusTest
{

	@CitrusTest
	@Parameters("designer")
	public void injectDesigner(@Optional @CitrusResource TestDesigner designer)
	{
		designer.echo(("Before"));
		System.out.println("Its a print statement");
		designer.echo(("After"));
	}
	
	@CitrusTest
	@Parameters("runner")
	public void injectRunner(@Optional @CitrusResource TestRunner runner)
	{
		runner.echo(("Before"));
		System.out.println("Its a print statement");
		runner.echo(("After"));
	}
	
}
