package com.fedor.futbolin.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "partido")
@SequenceGenerator(name = "partidoIdSeq", sequenceName = "partido_id_seq")
public class Partido {
	
	private Long id;
	private Timestamp fechaInicio;
	private Timestamp fechaFin;
	private List<PartidoJugador> partidoJugadores;
	private PartidoEquipo equipoGanador;
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "partidoIdSeq")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "fecha_inicio", nullable = false)
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	@Column(name = "fecha_fin")
	public Timestamp getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	@OneToMany(mappedBy = "partido")
	public List<PartidoJugador> getPartidoJugadores() {
		return partidoJugadores;
	}
	
	public void setPartidoJugadores(List<PartidoJugador> partidoJugadores) {
		this.partidoJugadores = partidoJugadores;
	}

	@ManyToOne
	@JoinColumn(name = "id_partido_equipo")
	public PartidoEquipo getEquipoGanador() {
		return equipoGanador;
	}

	public void setEquipoGanador(PartidoEquipo equipoGanador) {
		this.equipoGanador = equipoGanador;
	}
}
