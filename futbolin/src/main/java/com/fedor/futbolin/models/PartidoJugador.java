package com.fedor.futbolin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "partido_jugador")
@SequenceGenerator(name = "partidoJugadorIdSeq", sequenceName = "partido_jugador_id_seq")
public class PartidoJugador {
	
	private Long id;
	private Partido partido;
	private Jugador jugador;
	private PartidoEquipo partidoEquipo;
	
	@Id
	@Column (name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "partidoJugadorIdSeq")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne()
	@JoinColumn(name = "id_partido", nullable = false)
	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	@ManyToOne()
	@JoinColumn(name = "id_jugador", nullable = false)
	public Jugador getJugador() {
		return jugador;
	}
	
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	@ManyToOne()
	@JoinColumn(name = "id_partido_equipo", nullable = false)
	public PartidoEquipo getPartidoEquipo() {
		return partidoEquipo;
	}
	
	public void setPartidoEquipo(PartidoEquipo partidoEquipo) {
		this.partidoEquipo = partidoEquipo;
	}
}
