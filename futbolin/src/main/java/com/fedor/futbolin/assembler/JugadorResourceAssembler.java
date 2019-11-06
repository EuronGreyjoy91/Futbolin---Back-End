package com.fedor.futbolin.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.fedor.futbolin.controller.JugadorController;
import com.fedor.futbolin.model.Jugador;

@Component
public class JugadorResourceAssembler implements ResourceAssembler<Jugador, Resource<Jugador>>{

	@Override
	public Resource<Jugador> toResource(Jugador jugador) {
		return new Resource<>(jugador,
			linkTo(methodOn(JugadorController.class).one(jugador.getId())).withSelfRel(),
			linkTo(methodOn(JugadorController.class).list()).withRel("jugadores"));
	}

}
