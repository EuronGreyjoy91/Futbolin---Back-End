package com.fedor.futbolin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fedor.futbolin.model.Jugador;

@Repository
@Transactional
public interface IJugadorRepository extends JpaRepository<Jugador, Long> {
	List<Jugador> findByActivoOrderByIdAsc(boolean activo);
}
