package com.fedor.futbolin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedor.futbolin.exception.PartidoNotFoundException;
import com.fedor.futbolin.model.Partido;
import com.fedor.futbolin.repository.IPartidoRepository;

@Service
public class PartidoServiceImpl implements IPartidoService{

	@Autowired
	private IPartidoRepository partidoRepository;
	
	@Override
	public Partido savePartido(Partido partido) {
		return partidoRepository.save(partido);
	}

	@Override
	public List<Partido> obtenerPartidos() {
		return partidoRepository.findAll();
	}
	
	@Override
	public Partido obtenerPartido(Long id) {
		return partidoRepository.findById(id)
				.orElseThrow(() -> new PartidoNotFoundException(id));
	}
}
