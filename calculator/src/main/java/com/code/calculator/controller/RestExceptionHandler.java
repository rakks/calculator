package com.code.calculator.controller;

import org.jboss.logging.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.code.calculator.exception.ApiError;
import com.code.calculator.exception.CalcValidationException;
import com.code.calculator.response.Response;
import com.code.calculator.utils.Utils;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	Logger log = Logger.getLogger(RestExceptionHandler.class);
	
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
    
/*    @ExceptionHandler({CalcValidationException.class})
    public ResponseEntity<Response> handle(CalcValidationException e) {
    	 log.error("Exception : "+ e);
    	 Response response = Utils.populateResponse(0, Utils.STATUS_FAILURE, e.getMessage());
         return ResponseEntity.status(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE).body(response);
    }*/
    
    @ExceptionHandler(CalcValidationException.class)
    protected ResponseEntity<Object> handleCalcValidation(
            CalcValidationException ex) {
        ApiError apiError = new ApiError(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
    
/*    private ResponseEntity<String> error(HttpStatus status, Exception e) {
        log.error("Exception : "+ e);
        return ResponseEntity.status(status).body(e.getMessage());
    }*/
}