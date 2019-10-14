package com.fedor.futbolin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "partido_equipo")
public class PartidoEquipo {
	public static final Long AZUL = 1L;
	public static final Long ROJO = 2L;
	
	@Id
	@Column (name = "id", nullable = false)
	private Long id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
}

