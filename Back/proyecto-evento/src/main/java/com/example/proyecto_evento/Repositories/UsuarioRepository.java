package com.example.proyecto_evento.Repositories;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyecto_evento.Models.usuario;

public interface UsuarioRepository extends JpaRepository<usuario, Integer>{

    //Loggin
 @Query(value = "SELECT * FROM usuario WHERE email = ?1 AND ps = crypt(?2, ps)", nativeQuery = true)
    Optional<usuario> findByUsernameAndPassword(String email, String ps);

    //Registry
    @Modifying
    @Transactional
    @Query(
      value = """
        INSERT INTO usuario 
        (nombre, apellido, email, ps, fecha_registro)
        VALUES 
        (:nombre, :apellido, :email, crypt(:ps, gen_salt('bf')), now())
      """,
      nativeQuery = true
    )
    void insertarUsuario(String nombre,String apellido, String email, String ps);


 @Query(value = "SELECT id_usurio FROM usuario WHERE nombre = ?1", nativeQuery = true)
    Integer findIdByUsername(String nombre);



}
