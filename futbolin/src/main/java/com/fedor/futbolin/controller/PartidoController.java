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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fedor.futbolin.assembler.PartidoResourceAssembler;
import com.fedor.futbolin.model.Partido;
import com.fedor.futbolin.service.IJugadorService;
import com.fedor.futbolin.service.IPartidoService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(path = "/api/v1/partidos", produces = MediaType.APPLICATION_JSON_VALUE)
public class PartidoController {
	
	@Autowired
	private IPartidoService partidoService;
	
	@Autowired
	private IJugadorService jugadorService;
	
	@Autowired
	private PartidoResourceAssembler assembler;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Partido partido) throws URISyntaxException{
		
		partido.getPartidoJugadores().forEach(partidoJugador -> {
			partidoJugador.setPartido(partido);
			jugadorService.saveJugador(partidoJugador.getJugador());
		});
		
		Resource<Partido> resource = assembler.toResource(partidoService.savePartido(partido));
		
		return ResponseEntity
			    .created(new URI(resource.getId().expand().getHref()))
			    .body(resource);
	}
	
	@GetMapping
	public Resources<Resource<Partido>> list() {
		List<Resource<Partido>> partidos =  partidoService.obtenerPartidos().stream()
		    .map(assembler::toResource)
		    .collect(Collectors.toList());

		return new Resources<>(partidos,
		    linkTo(methodOn(PartidoController.class).list()).withSelfRel());
	}
	
	@GetMapping("/{id}")
	public Resource<Partido> one(@PathVariable Long id){
		Partido partido = partidoService.obtenerPartido(id);
		return assembler.toResource(partido);
	}
	
	
}
