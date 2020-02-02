package com.code.calculator.utils;

import com.code.calculator.response.Response;

public class Utils {

	public static final String URI_ADD = "/calculator/add";
	
	public static final String URI_SUBTRACT = "/calculator/subtract";
	
	public static final String URI_MULTIPLY = "/calculator/multiply";
	
	public static final String URI_DIVIDE = "/calculator/divide";
	
	public static final String URI_RESULTS = "/calculator/results";
	
	public static final String URI_RESULTS_BYDATE = "/calculator/results/{date}";
	
	public static final String URI_RESULTS_DATE_RANGE = "/calculator/results/{fromDate}/{toDate}";

	public static final String CONST_ADD = "ADD";
	
	public static final String CONST_SUBTRACT = "SUBTRACT";
	
	public static final String CONST_MULTIPLY = "MULTIPLY";
	
	public static final String CONST_DIVIDE = "DIVIDE";
	
	public static final String STATUS_SUCCESS = "SUCCESS";
	
	public static final String STATUS_FAILURE = "FAILURE";
	
	
	public static final Response populateResponse(long result, String status, String description) { 
		
		Response response = new Response();
		response.setStatus(status);
		response.setResult(result);
		response.setDescription(description);
		return response;
	}
}
