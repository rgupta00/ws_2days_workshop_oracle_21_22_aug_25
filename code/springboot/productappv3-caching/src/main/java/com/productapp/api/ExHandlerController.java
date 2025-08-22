package com.productapp.api;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.productapp.dto.ErrorMessage;
import com.productapp.exceptions.ProductNotFoundException;

@RestControllerAdvice
public class ExHandlerController {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorMessage> handle404(ProductNotFoundException ex) {
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setErrorMessage(ex.getMessage());
		errorMessage.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorMessage.setTimeStamp(LocalDateTime.now());
		errorMessage.setToContact("rgupta.mtech@gmail.com");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
		
	}
	//MethodArgumentNotValidException
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> handle400(MethodArgumentNotValidException ex) {
		String errorMessageString= ex.getBindingResult()
				.getAllErrors()
				.stream().map(x->x.getDefaultMessage())
				.collect(Collectors.joining(" ,"));
		
		
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setErrorMessage(errorMessageString);
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setTimeStamp(LocalDateTime.now());
		errorMessage.setToContact("rgupta.mtech@gmail.com");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handle500(Exception ex) {
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setErrorMessage("pls try after some time");
		errorMessage.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorMessage.setTimeStamp(LocalDateTime.now());
		errorMessage.setToContact("rgupta.mtech@gmail.com");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		
	}
}
