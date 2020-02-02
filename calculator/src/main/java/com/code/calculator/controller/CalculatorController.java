package com.code.calculator.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code.calculator.model.CalculatorResult;
import com.code.calculator.request.CalculatorRequest;
import com.code.calculator.response.Response;
import com.code.calculator.service.CalculatorService;
import com.code.calculator.utils.Utils;

@RestController
public class CalculatorController {
	
	@Autowired
	private CalculatorService service;

	@RequestMapping(value = Utils.URI_ADD, method = RequestMethod.POST)
	public Response add(@RequestBody CalculatorRequest request) {
		boolean isValid = request.validate(Utils.CONST_ADD);
		if(isValid) { 
			return service.addition(request);
		}
		else { 
			return Utils.populateResponse(0, Utils.STATUS_FAILURE, "Validation failed");
		}
	}
	
	@RequestMapping(value = Utils.URI_SUBTRACT, method = RequestMethod.POST)
	public Response subtract(@RequestBody CalculatorRequest request) {
		boolean isValid = request.validate(Utils.CONST_SUBTRACT);
		if(isValid) { 
			return service.subtraction(request);
		}
		else { 
			return Utils.populateResponse(0, Utils.STATUS_FAILURE, "Validation failed");
		}
	}
	
	@RequestMapping(value = Utils.URI_MULTIPLY, method = RequestMethod.POST)
	public Response multiply(@RequestBody CalculatorRequest request) {
		boolean isValid = request.validate(Utils.CONST_MULTIPLY);
		if(isValid) { 
			return service.multiplication(request);
		}
		else { 
			return Utils.populateResponse(0, Utils.STATUS_FAILURE, "Validation failed");
		}
	}
	
	@RequestMapping(value = Utils.URI_DIVIDE, method = RequestMethod.POST)
	public Response divide(@RequestBody CalculatorRequest request) {
		boolean isValid = request.validate(Utils.CONST_DIVIDE);
		if(isValid) { 
			return service.division(request);
		}
		else { 
			return Utils.populateResponse(0, Utils.STATUS_FAILURE, "Validation failed");
		}
	}
	
	
	@RequestMapping(value = Utils.URI_RESULTS, method = RequestMethod.GET)
	public List<CalculatorResult> getCalculationResults() {
		return service.getResults();
	}
	
	// Example URL : http://localhost:8080/calculator/results?date=02022020
	@RequestMapping(value = Utils.URI_RESULTS_BYDATE, method = RequestMethod.GET)
	public List<CalculatorResult> getCalculationResultsByDate(@RequestParam(value="date") @DateTimeFormat(pattern="ddMMyyyy") Date date) {
		return service.getResultsByDate(date);
	}
	
	// Example URL : http://localhost:8080/calculator/results?fromDate=02022020&toDate=02022020
	@RequestMapping(value = Utils.URI_RESULTS_DATE_RANGE, method = RequestMethod.GET)
	public List<CalculatorResult> getCalculationResultsByDateRange(@RequestParam(value="fromDate") @DateTimeFormat(pattern="ddMMyyyy") Date fromDate, 
			@RequestParam(value="toDate") @DateTimeFormat(pattern="ddMMyyyy") Date toDate) {
		return service.getResultsByDateRange(fromDate, toDate);
	}
}