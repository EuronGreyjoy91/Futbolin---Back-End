package com.fedor.futbolin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fedor.futbolin.model.PartidoEquipo;

@Repository
@Transactional
public interface IPartidoEquipoRepository extends JpaRepository<PartidoEquipo, Long> {

}
