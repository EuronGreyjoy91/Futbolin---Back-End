package com.fedor.futbolin.exception;

public class PartidoNotFoundException extends RuntimeException{
	
	public PartidoNotFoundException(Long id){
		super("Partido no encontrado " + id);
	}
	
}
