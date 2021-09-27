package com.techgatha.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.www_techgatha_com.xml.school.StudentDetailsRequest;
import https.www_techgatha_com.xml.school.StudentDetailsResponse;

@Endpoint
public class SoapService {

	
	private static final String NAMESPACE_URI = "https://www.techgatha.com/xml/school";

	private StudentRepository StudentRepository;

	@Autowired
	public SoapService(StudentRepository StudentRepository) {
		this.StudentRepository = StudentRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
	@ResponsePayload
	public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest request) {
		StudentDetailsResponse response = new StudentDetailsResponse();
		response.setStudent(StudentRepository.findStudent(request.getName()));

		return response;
	}
}
