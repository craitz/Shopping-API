package com.camilo.shopping.handler;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handlerConstraintViolation(ConstraintViolationException e, HttpServletResponse response) {
		
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		
		for (ConstraintViolation<?> v : violations) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(v.getMessageTemplate());
		}
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("");
	}
	
	@ExceptionHandler(JsonParseException.class)
	public ResponseEntity<String> handlerJsonParseException(JsonParseException e, HttpServletResponse response) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Preenchimento inválido dos dados.");
	}
	
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<String> handlerInvalidFormatException(InvalidFormatException e, HttpServletResponse response) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(JsonMappingException.class)
	public ResponseEntity<String> handlerJsonMappingException(JsonMappingException e, HttpServletResponse response) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Preenchimento inválido dos dados.");
	}
	
	@ExceptionHandler(UnexpectedTypeException.class)
	public ResponseEntity<String> handlerUnexpectedTypeException(UnexpectedTypeException e, HttpServletResponse response) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
}
