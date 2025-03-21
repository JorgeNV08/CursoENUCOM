package com.mx.CursosAcademicos.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.CursosAcademicos.Entity.Inscripcion;

@Repository
public interface IInscripcionDao extends JpaRepository<Inscripcion, Integer>{
}
