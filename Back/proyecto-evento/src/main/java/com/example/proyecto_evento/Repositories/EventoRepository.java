package com.example.proyecto_evento.Repositories;


import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.proyecto_evento.Models.evento;

import jakarta.transaction.Transactional;

public interface EventoRepository extends JpaRepository<evento, Integer>{
   @Modifying
    @Transactional
    @Query(
      value = """
        INSERT INTO evento 
        (nombre, descripcion, fecha_evento, fecha_creacion, activo,  id_creador)
        VALUES 
        (:nombre, :descripcion, :fecha_evento, now(), true, :id_creador)
      """,
      nativeQuery = true
    )
    void insertarEvento(String nombre, String descripcion, Date fecha_evento, int id_creador);

   /*@Modifying
    @Transactional
    @Query(value="""
        DELETE FROM evento WHERE nombre = :nombreEve)
        """, nativeQuery =true
        )
    void deleteByNombre(String nombreEve);*/


}
