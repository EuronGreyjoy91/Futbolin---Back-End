package com.fedor.futbolin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "jugador")
@SequenceGenerator(name = "jugadorIdSeq", sequenceName = "jugador_id_seq", allocationSize = 1)
public class Jugador {

	@Id
	@Column (name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jugadorIdSeq")
	private Long id;
	
	@Column (name = "nombre", nullable = false)
	private String nombre;
	
	@Column (name = "ganados", nullable = false)
	private Integer ganados;
	
	@Column (name = "perdidos", nullable = false)
	private Integer perdidos;
	
	@Column (name = "habilidad_especial")
	private String habilidadEspecial;
	
	@Column (name = "activo", nullable = false)
	private Boolean activo;
	
	@Column (name = "path_imagen")
	private String pathImagen;
	
}
