package com.code.calculator;


import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.code.calculator.request.CalculatorRequest;
import com.code.calculator.response.Response;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CalculatorControllerTest 
{
	@LocalServerPort
	int randomServerPort; 

	@Test
	public void testAddOperation() throws URISyntaxException 
	{
		RestTemplate restTemplate = new RestTemplate();

		final String addUrl = "http://localhost:" + randomServerPort + "/calculator/add";
		URI uri = new URI(addUrl);
		CalculatorRequest calcRequest = new CalculatorRequest(100, 200);
		ResponseEntity<Response> result = restTemplate.postForEntity(uri, calcRequest, Response.class);

		//Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(300, result.getBody().getResult());
	}

	@Test
	public void testSubtractOperation() throws URISyntaxException 
	{
		RestTemplate restTemplate = new RestTemplate();

		final String subtractUrl = "http://localhost:" + randomServerPort + "/calculator/subtract";
		URI uri = new URI(subtractUrl);
		CalculatorRequest calcRequest = new CalculatorRequest(500, 100);
		ResponseEntity<Response> result = restTemplate.postForEntity(uri, calcRequest, Response.class);

		//Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(400, result.getBody().getResult());
	}
	
	@Test
	public void testMultiplyOperation() throws URISyntaxException 
	{
		RestTemplate restTemplate = new RestTemplate();

		final String multiplyUrl = "http://localhost:" + randomServerPort + "/calculator/multiply";
		URI uri = new URI(multiplyUrl);
		CalculatorRequest calcRequest = new CalculatorRequest(500, 100);
		ResponseEntity<Response> result = restTemplate.postForEntity(uri, calcRequest, Response.class);

		//Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(50000, result.getBody().getResult());
	}

	
	@Test
	public void testDivideOperation() throws URISyntaxException 
	{
		RestTemplate restTemplate = new RestTemplate();

		final String divideUrl = "http://localhost:" + randomServerPort + "/calculator/divide";
		URI uri = new URI(divideUrl);
		CalculatorRequest calcRequest = new CalculatorRequest(5000, 100);
		ResponseEntity<Response> result = restTemplate.postForEntity(uri, calcRequest, Response.class);

		//Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(50, result.getBody().getResult());
	}


	@Test
	public void testYResultsByDate() throws URISyntaxException 
	{
		RestTemplate restTemplate = new RestTemplate();

		Date today = new Date();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("ddMMyyyy");
	    String date = DATE_FORMAT.format(today);
		final String allResultsUrl = "http://localhost:" + randomServerPort + "/calculator/results?date=";
		URI uri = new URI(allResultsUrl + date);
		
		ResponseEntity<List> results = restTemplate.getForEntity(uri, List.class);
		
		//Verify request succeed
		Assert.assertEquals(200, results.getStatusCodeValue());
		Assert.assertEquals(4, results.getBody().size());
	}
	
	@Test
	public void testZResults() throws URISyntaxException 
	{
		RestTemplate restTemplate = new RestTemplate();

		final String allResultsUrl = "http://localhost:" + randomServerPort + "/calculator/results";
		URI uri = new URI(allResultsUrl);
		ResponseEntity<List> results = restTemplate.getForEntity(uri, List.class);
		
		//Verify request succeed
		Assert.assertEquals(200, results.getStatusCodeValue());
		Assert.assertEquals(4, results.getBody().size());
	}



	
}