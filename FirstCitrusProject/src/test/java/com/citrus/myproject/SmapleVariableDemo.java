package com.citrus.myproject;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Test
public class SmapleVariableDemo extends TestNGCitrusTestRunner{

	@CitrusTest
	public void testVariable1()
	{
		String extentReportFile = System.getProperty("user.dir") +"/extentReportFile.html";
		String extentReportImage = System.getProperty("user.dir")
				+ "/extentReportImage.png";

		// Create object of extent report and specify the report file path.
		ExtentReports extent = new ExtentReports(extentReportFile, false);

		// Start the test using the ExtentTest class object.
		ExtentTest extentTest = extent.startTest("My First Test",
				"Verify Variables Demo");

		variable("email", "shalini@gmail.com");
		variable("persons", "<persons> <person> <name>Theodor</name> \n" + 
				"					<age>10</age> </person> \n" + 
				"					<person> <name>Alvin</name> <age>9</age> 		</person> \n" + 
				"					</persons> ");
		echo("Email Variable declared locally ${email}");
		echo("Global variable ${//project.name//} :-> ${project.name}");
		echo("Global variable ${//test.author//} :-> ${test.author}");

		extentTest.log(LogStatus.INFO, "all variables echoed");


		// In case you want to attach screenshot then use below method
		// We used a random image but you've to take screenshot at run-time
		// and specify the error image path.
		extentTest.log(
				LogStatus.INFO,
				"Error Snapshot : "
						+ extentTest.addScreenCapture(extentReportImage));


		// close report.
		extent.endTest(extentTest);

		// writing everything to document.
		extent.flush();

	}
	@CitrusTest
	public void testVariable2()
	{
		//echo("Email Variable declared locally ${email}");
		echo("Global variable ${//project.name//} :-> ${project.name}");
		echo("Global variable ${//test.author//} :-> ${test.author}");
	}
}
