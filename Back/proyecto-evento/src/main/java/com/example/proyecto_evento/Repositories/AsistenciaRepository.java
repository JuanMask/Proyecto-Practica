package com.example.proyecto_evento.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.proyecto_evento.Models.asistencia;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.query.Param;

public interface AsistenciaRepository extends JpaRepository <asistencia, Integer>{

    @Modifying
    @Transactional
    @Query(
      value = """
        INSERT INTO asistencia 
        (id_evento, id_usuario, estado, fecha_registro)
        VALUES 
        (:idEvento, :idUsuario , true, now())
      """,
      nativeQuery = true
    )
    //void confirmarAsistencia(int idUsuario, int idEvento);
    void confirmarAsistencia(
      @Param("idEvento") Integer idEvento,
      @Param("idUsuario") Integer idUsuario
    );


    @Modifying
    @Transactional
    @Query(
    value = """
      UPDATE asistencia
      SET estado = :estado
      WHERE id_evento = :idEvento
        AND id_usuario = :idUsuario
    """,
    nativeQuery = true
)
    void actualizaAsistencia(Integer idUsuario, Integer idEvento, Boolean estado);
}
