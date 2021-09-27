package com.citrus.myproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.consol.citrus.dsl.endpoint.CitrusEndpoints;
import com.consol.citrus.http.client.HttpClient;

@Configuration
public class MyConfig {

	@Bean
	public HttpClient client()
	{
		System.out.println("Client is created");
		return CitrusEndpoints.http().client()
				.requestUrl("http://localhost:8080/customers")
				.build();
	}
}
