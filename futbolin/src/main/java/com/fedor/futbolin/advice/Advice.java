package com.fedor.futbolin.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fedor.futbolin.exception.JugadorNotFoundException;
import com.fedor.futbolin.exception.PartidoNotFoundException;

@ControllerAdvice
public class Advice {

	@ResponseBody
	@ExceptionHandler(JugadorNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String jugadorNotFoundHandler(JugadorNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(PartidoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String partidoNotFoundHandler(PartidoNotFoundException ex) {
		return ex.getMessage();
	}
	
}
