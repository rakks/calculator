package com.code.calculator.service;

import java.util.Date;
import java.util.List;

import com.code.calculator.model.CalculatorResult;
import com.code.calculator.request.CalculatorRequest;
import com.code.calculator.response.Response;

public interface CalculatorService {

	public Response addition(CalculatorRequest request);
	public Response subtraction(CalculatorRequest request);
	public Response multiplication(CalculatorRequest request);
	public Response division(CalculatorRequest request);
	public List<CalculatorResult> getResults();
	public List<CalculatorResult> getResultsByDate(Date date);
	public List<CalculatorResult> getResultsByDateRange(Date fromDate, Date toDate);
}
