package com.citrus.myproject;

//https://www.techbeamers.com/generate-reports-selenium-webdriver/#h3
//https://www.swtestacademy.com/extentreports-testng/

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportTest {

	@Test
	public void test1()
	{
		String extentReportFile = System.getProperty("user.dir") +"/extentReportFile.html";
		String extentReportImage = System.getProperty("user.dir")
				+ "/extentReportImage.png";

		// Create object of extent report and specify the report file path.
		ExtentReports extent = new ExtentReports(extentReportFile, false);

		// Start the test using the ExtentTest class object.
		ExtentTest extentTest = extent.startTest("My First Test",
				"Verify WebSite Title");

		assertEquals(10, 10);

		extentTest.log(LogStatus.INFO, "assert 10 is 10");


		// In case you want to attach screenshot then use below method
		// We used a random image but you've to take screenshot at run-time
		// and specify the error image path.
		extentTest.log(
				LogStatus.INFO,
				"Error Snapshot : "
						+ extentTest.addScreenCapture(extentReportImage));

	

		extentTest.log(LogStatus.INFO, "Browser closed");

		// close report.
		extent.endTest(extentTest);

		// writing everything to document.
		extent.flush();
	}
}
