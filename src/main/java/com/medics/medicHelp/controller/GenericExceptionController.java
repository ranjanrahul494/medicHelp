package com.medics.medicHelp.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.medics.medicHelp.model.ErrorMessage;

@ControllerAdvice
public class GenericExceptionController extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorMessage> commonExceptionHandler(Exception ex) {
		ErrorMessage errorMessage=new ErrorMessage(ex.getMessage(), "error message details", "bad request", 404);
		return new ResponseEntity<ErrorMessage>(errorMessage,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
