package com.fedor.futbolin.service;

import java.util.List;

import com.fedor.futbolin.model.Partido;

public interface IPartidoService {
	Partido savePartido(Partido partido);
	List<Partido> obtenerPartidos();
	Partido obtenerPartido(Long id);
}
