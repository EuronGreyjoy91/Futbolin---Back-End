package com.fedor.futbolin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fedor.futbolin.models.Jugador;
import com.fedor.futbolin.service.IJugadorService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
@RequestMapping(path = "/jugadores")
public class JugadorController {
	
	@Autowired
	private IJugadorService jugadorService;
	
	@GetMapping("/list")
	public List<Jugador> obtenerJugadores(){
		return jugadorService.getJugadores();
	}
	
	@GetMapping("/{id}/edit")
	public Jugador editarJugador(@PathVariable Long id) {
		return jugadorService.obtenerJugador(id).get();
	}
	
	@PostMapping(value = "/save")
	public Long saveJugador(@RequestBody Jugador jugador) {
		return jugadorService.saveJugador(jugador).getId();
	}
	
	@PutMapping("/update")
	public void updateJugador(@RequestBody Jugador jugador) {
		jugadorService.saveJugador(jugador);
	}
	
}
