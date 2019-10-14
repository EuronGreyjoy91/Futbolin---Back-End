package com.fedor.futbolin.service;

import java.util.List;

import com.fedor.futbolin.model.Jugador;

public interface IJugadorService {
	Jugador saveJugador(Jugador jugador);
	List<Jugador> getJugadores();
	Jugador obtenerJugador(Long id);
	void borrarJugador(Jugador jugador);
}
