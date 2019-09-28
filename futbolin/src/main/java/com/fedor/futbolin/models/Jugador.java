package com.fedor.futbolin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "jugador")
@SequenceGenerator(name = "jugadorIdSeq", sequenceName = "jugador_id_seq")
public class Jugador {

	private Long id;
	private String nombre;
	private Integer ganados;
	private Integer perdidos;
	private Integer goles;
	private String habilidadEspecial;
	private Boolean activo;
	private String pathImagen;
	
	@Id
	@Column (name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "jugadorIdSeq")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column (name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column (name = "ganados", nullable = false)
	public Integer getGanados() {
		return ganados;
	}

	public void setGanados(Integer ganados) {
		this.ganados = ganados;
	}
	
	@Column (name = "perdidos", nullable = false)
	public Integer getPerdidos() {
		return perdidos;
	}

	public void setPerdidos(Integer perdidos) {
		this.perdidos = perdidos;
	}

	@Column (name = "goles", nullable = false)
	public Integer getGoles() {
		return goles;
	}

	public void setGoles(Integer goles) {
		this.goles = goles;
	}

	@Column (name = "habilidad_especial")
	public String getHabilidadEspecial() {
		return habilidadEspecial;
	}

	public void setHabilidadEspecial(String habilidadEspecial) {
		this.habilidadEspecial = habilidadEspecial;
	}

	@Column (name = "activo", nullable = false)
	public Boolean getActivo() {
		return activo;
	}
	
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Column (name = "path_imagen")
	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}

}
