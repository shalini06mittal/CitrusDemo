package com.citrus.myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.testng.TestNGCitrusTestDesigner;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import com.consol.citrus.http.client.HttpClient;


public class SampleCitrusFunctionsDemoIT extends TestNGCitrusTestDesigner{

	@Autowired
	HttpClient httpclient;
	@CitrusTest
	@Test(enabled = false)
	public void testStringFunctions()
	{
		variable("uname", "Shalini Mittal");
		echo("My name is citrus:substring(${uname},0,8)");
		echo(" citrus:concat('My name is ',${uname})");
		echo(" ${uname} has length => citrus:stringLength(${uname})");
	}
	@CitrusTest
	@Test(enabled = false)
	public void testNumberFunctions()
	{
		echo("My name is citrus:maximum(12,0,8)");
		echo(" citrus:sum(1,2,3,4,5,6,7)");
		echo(" citrus:randomNumber(3)");
	}
	@CitrusTest
	@Test
	public void testJsonFunctions()
	{
//		variable("person","{\"name\":\"shalini\",\"city\":\"Mumbai\"}");
//		echo("JSON Object => ${person}");
//		echo("Name : citrus:jsonPath(${person}, '$.name')");
		echo("***** CLIENT REQ SEND *********");
	
//		http(httpAction -> httpAction.client(httpclient).send()
//				.get("/")
//				.accept("application/json"));
//			echo("***** CLIENT REQ RECIEVE *********");
//		http(httpAction -> httpAction.client(httpclient).receive()
//				.response(HttpStatus.OK)
//				.validate("$", hasSize(2))
//				.validate("$[0]", "{\"name\":\"Shalini\",\"cid\":1}")
//				.extractFromPayload("$", "resp"));
//			echo("${resp}");
		
		http().client(httpclient).send().get();
		http().client(httpclient).receive().response(HttpStatus.OK).validate("%", hasSize(2)).extractFromPayload("$", "resp");
		
		echo("${resp}");
	}
}
