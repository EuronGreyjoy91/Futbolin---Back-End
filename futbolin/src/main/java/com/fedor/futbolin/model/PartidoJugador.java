package com.fedor.futbolin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "partido_jugador")
@SequenceGenerator(name = "partidoJugadorIdSeq", sequenceName = "partido_jugador_id_seq", allocationSize = 1)
public class PartidoJugador {
	@Id
	@Column (name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partidoJugadorIdSeq")
	private Long id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_partido", nullable = false)
	private Partido partido;
	
	@ManyToOne
	@JoinColumn(name = "id_jugador", nullable = false)
	private Jugador jugador;
	
	@ManyToOne
	@JoinColumn(name = "id_partido_equipo", nullable = false)
	private PartidoEquipo partidoEquipo;
}
