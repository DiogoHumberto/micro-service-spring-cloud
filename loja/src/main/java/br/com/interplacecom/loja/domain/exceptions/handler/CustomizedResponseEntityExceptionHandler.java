package br.com.interplacecom.loja.domain.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.interplacecom.loja.domain.exceptions.CompraNotFound;
import br.com.interplacecom.loja.domain.exceptions.ExceptionResponseDto;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(CompraNotFound.class)
	public final ResponseEntity<ExceptionResponseDto> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponseDto exceptionResponse = new ExceptionResponseDto(new Date() , ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}
