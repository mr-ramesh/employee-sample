package com.vivriti.test.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentException(MethodArgumentNotValidException ex) {
		Map<String, String> result = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(err -> {
			String fieldName = ((FieldError) err).getField();
			result.put(fieldName, err.getDefaultMessage());
		});
		return result;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DataNotFoundException.class)
	public Map<String, String> handleMethodArgumentException(DataNotFoundException ex) {
		Map<String, String> result = new HashMap<>();
		result.put("error", ex.getMessage());
		return result;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DuplicateDataException.class)
	public Map<String, String> handleMethodArgumentException(DuplicateDataException ex) {
		Map<String, String> result = new HashMap<>();
		result.put("error", ex.getMessage());
		return result;
	}
}
