package com.lottoland.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lottoland.dto.ErrorDTO;
import com.lottoland.exception.InvalidIdException;

@ControllerAdvice
public class AppExceptionHandler 
  extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(value = { InvalidIdException.class })
    protected ResponseEntity<Object> handleInvalidIdException(RuntimeException ex, WebRequest request) {
    	
    	ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setErrorMessage(ex.getMessage());
        
        return handleExceptionInternal(ex, errorDTO, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}