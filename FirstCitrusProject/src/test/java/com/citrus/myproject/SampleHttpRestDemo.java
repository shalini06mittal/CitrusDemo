package com.citrus.myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.consol.citrus.annotations.CitrusEndpoint;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.testng.TestNGCitrusTestDesigner;
import com.consol.citrus.http.client.HttpClient;
import com.consol.citrus.http.config.annotation.HttpClientConfig;
import com.consol.citrus.message.MessageType;

public class SampleHttpRestDemo extends TestNGCitrusTestDesigner{
	
	
//@Autowired
	@CitrusEndpoint
	@HttpClientConfig(requestUrl = "http://localhost:8080/customers")
	HttpClient customerClient;
	
	@Test(enabled = false)
	@CitrusTest
	public void testGetAllCustomers()
	{	
		String data = "";
		ClassPathResource resource = new ClassPathResource("customer.json");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			data = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		http().client(customerClient).send().get("/");
		http().client(customerClient).receive()
		.response(HttpStatus.OK)
		.validate("$",data)
		.extractFromPayload("$", "response");
		echo("${response}");	
	}
	@Test//(enabled = false)
	@CitrusTest
	public void testGetCustomerById()
	{	
		String data = "";
		ClassPathResource resource = new ClassPathResource("customer.json");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			data = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		http().client(customerClient).send().get("/1");
		http().client(customerClient).receive()
		.response(HttpStatus.OK)
		.validate("$",data)
		.extractFromPayload("$", "response");
		echo("${response}");	
	}
	
	@Test(enabled = false)
	@CitrusTest
	public void testAddCustomer()
	{	
		String data = "";
		ClassPathResource resource = new ClassPathResource("customer.json");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			data = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		http().client(customerClient).send().post("/").contentType("application/json").payload(resource);
		http().client(customerClient).receive()
		.response(HttpStatus.OK)
		.extractFromPayload("$", "response");
		echo("${response}");	
	}
	//@Test
	@CitrusTest
	public void testDeleteCustomer()
	{	
		
		http().client(customerClient).send().delete("/3");
		http().client(customerClient).receive()
		.response(HttpStatus.OK)
		//.payload("Deleted");
		.payload("@equalsIgnoreCase('Deleted')@");
		//echo("${response}");	
	}

}
