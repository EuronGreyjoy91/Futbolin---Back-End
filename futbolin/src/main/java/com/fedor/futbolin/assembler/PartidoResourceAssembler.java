package com.fedor.futbolin.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.fedor.futbolin.controller.PartidoController;
import com.fedor.futbolin.model.Partido;

@Component
public class PartidoResourceAssembler implements ResourceAssembler<Partido, Resource<Partido>>{

	@Override
	public Resource<Partido> toResource(Partido partido) {
		return new Resource<>(partido,
			linkTo(methodOn(PartidoController.class).one(partido.getId())).withSelfRel(),
			linkTo(methodOn(PartidoController.class).list()).withRel("partidos"));
	}

}
