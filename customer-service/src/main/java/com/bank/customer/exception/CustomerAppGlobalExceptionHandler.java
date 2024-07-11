package com.bank.customer.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bank.customer.payload.ErrorInfo;



@RestControllerAdvice
public class CustomerAppGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleResourceNotFoundException(CustomerNotFoundException exception,
			WebRequest webRequest) {

		ErrorInfo errordetails = new ErrorInfo(new Date(), exception.getMessage(), webRequest.getDescription(false));
		
		return new ResponseEntity<>(errordetails, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> handleResourceNotFoundException(Exception exception,
			WebRequest webRequest) {

		ErrorInfo errordetails = new ErrorInfo(new Date(), "Application Error : "+exception.getMessage(), webRequest.getDescription(false));
		
		return new ResponseEntity<>(errordetails, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> validationErrors = new HashMap<>();
        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();
 
        validationErrorList.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String validationMsg = error.getDefaultMessage();
            validationErrors.put(fieldName, validationMsg);
        });
        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }
}
