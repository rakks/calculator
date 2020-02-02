package com.code.calculator.repository;

import org.springframework.data.repository.CrudRepository;

import com.code.calculator.model.CalculatorResult;

public interface CalculatorRepository extends CrudRepository<CalculatorResult, Integer> {}

