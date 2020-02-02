package com.code.calculator.request;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import com.code.calculator.exception.CalcValidationException;
import com.code.calculator.utils.Utils;

public class CalculatorRequest {

	@Digits(integer=6, fraction=2, message = "Please enter only integer values not more than 6 digits and 2 decimals")
	@NotEmpty
	private long input1;
	
	@Digits(integer=6, fraction=2, message = "Please enter only integer values not more than 6 digits and 2 decimals")
	@NotEmpty
	private long input2;

	public long getInput1() {
		return input1;
	}

	public void setInput1(long input1) {
		this.input1 = input1;
	}

	public long getInput2() {
		return input2;
	}

	public void setInput2(long input2) {
		this.input2 = input2;
	}
	
	public CalculatorRequest() { }
	
	public CalculatorRequest(long input1, long input2) {
		this.input1 = input1;
		this.input2 = input2;
	}
	
	public boolean validate(String operation) { 
		boolean isValid = true;
		if(Utils.CONST_DIVIDE.equalsIgnoreCase(operation)) { 
			if(input2 == 0) { 
				isValid = false;
				throw new CalcValidationException("input2 cannot be equal to 0 for division operation");
			}
		}
		
		return isValid;
	}
	
	
}
