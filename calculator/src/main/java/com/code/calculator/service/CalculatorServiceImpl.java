package com.code.calculator.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.calculator.model.CalculatorResult;
import com.code.calculator.repository.CalculatorRepository;
import com.code.calculator.request.CalculatorRequest;
import com.code.calculator.response.Response;
import com.code.calculator.utils.Utils;

@Service("CalculatorService")
public class CalculatorServiceImpl implements CalculatorService {

	@Autowired
	CalculatorRepository calculatorRepository;

	@Override
	public Response addition(CalculatorRequest request) {
		long result = Math.addExact(request.getInput1(), request.getInput2());
		return saveCalculatorResult(request, result, Utils.CONST_ADD, Utils.STATUS_SUCCESS);	}

	@Override
	public Response subtraction(CalculatorRequest request) {
		long result = Math.subtractExact(request.getInput1(), request.getInput2());
		return saveCalculatorResult(request, result, Utils.CONST_SUBTRACT, Utils.STATUS_SUCCESS);
	}

	@Override
	public Response multiplication(CalculatorRequest request) {
		long result = Math.multiplyExact(request.getInput1(), request.getInput2());
		return saveCalculatorResult(request, result, Utils.CONST_MULTIPLY, Utils.STATUS_SUCCESS);
	}

	@Override
	public Response division(CalculatorRequest request) {
		long result = Math.floorDiv(request.getInput1(), request.getInput2());
		return saveCalculatorResult(request, result, Utils.CONST_DIVIDE, Utils.STATUS_SUCCESS);
	}

	@Override
	public List<CalculatorResult> getResults() {
		List<CalculatorResult> results = new ArrayList<CalculatorResult>();
		calculatorRepository.findAll().forEach(result -> results.add(result));
		return results;
	}
	
	@Override
	public List<CalculatorResult> getResultsByDate(Date date) {
		List<CalculatorResult> results = new ArrayList<CalculatorResult>();
		calculatorRepository.findAll().forEach(result -> {if(result.getCreated_dttm().compareTo(date) == 0) {results.add(result);}});
		return results;
	}
	
	@Override
	public List<CalculatorResult> getResultsByDateRange(Date fromDate, Date toDate) {
		List<CalculatorResult> results = new ArrayList<CalculatorResult>();
		calculatorRepository.findAll().forEach(result -> {if(result.getCreated_dttm().compareTo(fromDate) >= 0 &&
				result.getCreated_dttm().compareTo(toDate) <= 0) {results.add(result);}});
		return results;
	}

	private Response saveCalculatorResult(CalculatorRequest request, long result, String operation, String status) { 

		CalculatorResult resultObject = new CalculatorResult();
		resultObject.setCreated_dttm(new Date());
		resultObject.setOperation(operation);
		resultObject.setInput1(request.getInput1());
		resultObject.setInput2(request.getInput2());
		resultObject.setResult(result);
		resultObject.setStatus(Utils.STATUS_SUCCESS);
		calculatorRepository.save(resultObject);

		Response response = Utils.populateResponse(result, "SUCCESS", "Operation have been performed successfully");
		return response;
	}





}
