package com.code.calculator.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CalculatorResult {

	@Id
	@GeneratedValue
	private int id;
	private String operation;
	private long input1;
	private long input2;
	private long result;
	private String status;
	private Date created_dttm;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
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
	public long getResult() {
		return result;
	}
	public void setResult(long result) {
		this.result = result;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreated_dttm() {
		return created_dttm;
	}
	public void setCreated_dttm(Date created_dttm) {
		this.created_dttm = created_dttm;
	}

}
