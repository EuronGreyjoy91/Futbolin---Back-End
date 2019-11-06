package com.fedor.futbolin.exception;

public class JugadorNotFoundException extends RuntimeException{
	
	public JugadorNotFoundException(Long id){
		super("Jugador no encontrado " + id);
	}
	
}
