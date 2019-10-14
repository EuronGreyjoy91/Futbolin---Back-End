package com.fedor.futbolin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fedor.futbolin.model.PartidoJugador;

@Repository
@Transactional
public interface IPartidoJugadorRepository extends JpaRepository<PartidoJugador, Long> {

}
