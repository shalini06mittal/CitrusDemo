package com.citrus.myproject;

import org.junit.Test;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.junit.JUnit4CitrusTestDesigner;

public class SampleJavaJunit4IT extends JUnit4CitrusTestDesigner{
	
	@Test
	@CitrusTest
	public void sayHelloFromJunit()
	{
		echo("Hello from junit 4 test framework");
	}

}
