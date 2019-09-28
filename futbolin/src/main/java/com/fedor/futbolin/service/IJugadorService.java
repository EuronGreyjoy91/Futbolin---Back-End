package com.fedor.futbolin.service;

import java.util.List;
import java.util.Optional;

import com.fedor.futbolin.models.Jugador;

public interface IJugadorService {
	Jugador saveJugador(Jugador jugador);
	List<Jugador> getJugadores();
	Optional<Jugador> obtenerJugador(Long id);
}
