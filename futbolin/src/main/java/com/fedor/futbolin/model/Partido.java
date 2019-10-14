package com.fedor.futbolin.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "partido")
@SequenceGenerator(name = "partidoIdSeq", sequenceName = "partido_id_seq", allocationSize = 1)
public class Partido {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partidoIdSeq")
	private Long id;
	
	@Column(name = "fecha_inicio", nullable = false)
	private Timestamp fechaInicio;
	
	@Column(name = "fecha_fin", nullable = false)
	private Timestamp fechaFin;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "partido", fetch = FetchType.EAGER)
	private List<PartidoJugador> partidoJugadores;
	
	@ManyToOne
	@JoinColumn(name = "id_partido_equipo_ganador", nullable = false)
	private PartidoEquipo partidoEquipoGanador;
}
