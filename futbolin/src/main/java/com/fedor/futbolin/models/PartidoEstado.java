package com.fedor.futbolin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "partido_estado")
public class PartidoEstado {
	public static final Long INICIADO = 1L;
	public static final Long FINALIZADO = 2L;
	
	private Long id;
	private String nombre;
	
	@Id
	@Column (name = "id", nullable = false)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
