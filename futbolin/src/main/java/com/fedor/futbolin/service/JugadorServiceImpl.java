package com.fedor.futbolin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedor.futbolin.models.Jugador;
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
		return jugadorRepository.findAll();
	}

	@Override
	public Optional<Jugador> obtenerJugador(Long id) {
		return jugadorRepository.findById(id);
	}

}
