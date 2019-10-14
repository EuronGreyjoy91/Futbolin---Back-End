package com.fedor.futbolin.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fedor.futbolin.assembler.JugadorResourceAssembler;
import com.fedor.futbolin.model.Jugador;
import com.fedor.futbolin.service.IJugadorService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
@RequestMapping(path = "/api/v1/jugadores", produces = MediaType.APPLICATION_JSON_VALUE)
public class JugadorController {
	
	@Autowired
	private IJugadorService jugadorService;
	
	@Autowired
	private JugadorResourceAssembler assembler;
	
	@GetMapping
	public Resources<Resource<Jugador>> list(){
		List<Resource<Jugador>> jugadores =  jugadorService.getJugadores().stream()
		    .map(assembler::toResource)
		    .collect(Collectors.toList());

		return new Resources<>(jugadores,
		    linkTo(methodOn(JugadorController.class).list()).withSelfRel());
	}
	
	@GetMapping("/{id}")
	public Resource<Jugador> one(@PathVariable Long id) {
		Jugador jugador = jugadorService.obtenerJugador(id);
		return assembler.toResource(jugador);
	}
	
	@PostMapping
	public ResponseEntity<?> saveJugador(@RequestBody Jugador jugador) throws URISyntaxException {
		Resource<Jugador> resource = assembler.toResource(jugadorService.saveJugador(jugador));
		
		return ResponseEntity
			    .created(new URI(resource.getId().expand().getHref()))
			    .body(resource);
	}
	
	@PutMapping
	public ResponseEntity<?> updateJugador(@RequestBody Jugador jugador) throws URISyntaxException {
		Resource<Jugador> resource = assembler.toResource(jugadorService.saveJugador(jugador));
		
		return ResponseEntity
			    .created(new URI(resource.getId().expand().getHref()))
			    .body(resource);
	}
	
	@PutMapping("/status")
	public void borrarJugador(@RequestBody Jugador jugador) {
		jugadorService.borrarJugador(jugador);
	}
}
