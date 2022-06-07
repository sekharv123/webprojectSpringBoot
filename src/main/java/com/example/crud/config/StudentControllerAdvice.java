package com.example.crud.config;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StudentControllerAdvice {
	
	@ExceptionHandler(value=StudentMgmtException.class)
	@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleGenericException(StudentMgmtException ex, Model model) {
		model.addAttribute("errMsg",ex.getMessage());
		return "admin/error";
	}

}
