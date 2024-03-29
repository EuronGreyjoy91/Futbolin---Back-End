package com.fedor.futbolin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedor.futbolin.exception.JugadorNotFoundException;
import com.fedor.futbolin.model.Jugador;
import com.fedor.futbolin.repository.IJugadorRepository;

@Service
public class JugadorServiceImpl implements IJugadorService{
	
	@Autowired
	private IJugadorRepository jugadorRepository;

	@Override
	public Jugador saveJugador(Jugador jugador) {
		return jugadorRepository.save(jugador);
	}

	@Override
	public List<Jugador> getJugadores() {
		return jugadorRepository.findByActivoOrderByIdAsc(true);
	}

	@Override
	public Jugador obtenerJugador(Long id) {
		return jugadorRepository.findById(id)
				.orElseThrow(() -> new JugadorNotFoundException(id));
	}
	
	@Override
	public void borrarJugador(Jugador jugador) {
		jugador.setActivo(false);
		jugadorRepository.save(jugador);
	}
}
