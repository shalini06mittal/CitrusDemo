package com.citrus.myproject;

import com.consol.citrus.dsl.runner.AbstractTestBehavior;

public class BeforeLogBehavior extends AbstractTestBehavior{

	@Override
	public void apply() {
		echo("Before the actions execute citrus:currentDate()");
		
	}

}
