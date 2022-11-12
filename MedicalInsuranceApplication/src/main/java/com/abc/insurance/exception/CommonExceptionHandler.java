package com.abc.insurance.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class CommonExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<AllExceptionDTO> handler(javax.persistence.EntityNotFoundException e)
	{
		
		System.out.println(" ------------- inside --- @Controller Advice Not Found Exception ----");
		
		AllExceptionDTO dto = new AllExceptionDTO();
		
		dto.setMsg(e.getLocalizedMessage());
		dto.setAdminInput(e.getLocalizedMessage().toString());
		dto.setDateAndTime(LocalDateTime.now().toString());
		
		return new ResponseEntity<AllExceptionDTO>(dto, HttpStatus.BAD_REQUEST);
	}

}