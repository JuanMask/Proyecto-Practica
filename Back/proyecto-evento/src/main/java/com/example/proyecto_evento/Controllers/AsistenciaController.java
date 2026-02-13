package com.example.proyecto_evento.Controllers;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto_evento.DTOS.AsistenciaDTO;
import com.example.proyecto_evento.Models.asistencia;
import com.example.proyecto_evento.Models.evento;
import com.example.proyecto_evento.Models.usuario;
import com.example.proyecto_evento.Services.AsistenciaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/asistencia")
//@Tag(name = "Asistencia de Usuarios.", description = "Endpoints de gestión de Asistencia a un evento por parte de un usuario: Se actualiza la asistencia de un usuario.")
public class AsistenciaController {
   
    @Autowired
    public AsistenciaService asistenciaService;
    
    @PutMapping("/actualiza")//Actualiar asistencia
    //@Operation(summary = "Actualizar la asistencia a un evento de un usuario.", description = "Devuelve una OK cuando la asistencia se ha actualizado.")
    //public ResponseEntity<?> actualizaAsistencia(@RequestBody @Parameter(description = "Datos del usuario a actualizar la asistencia") AsistenciaDTO dto) {
    public ResponseEntity<?> actualizaAsistencia(@RequestBody AsistenciaDTO dto) {

        asistenciaService.actualizaAsistencia(
            dto.getIdUsuario(),
            dto.getIdEvento(),
            dto.getEstado()
        );
        
        //this.actAsistencia(dto);     
        return ResponseEntity.ok().build();
    }


  @GetMapping("/listar")//mostrar eventos
  @Operation(summary = "Obtener todos los datos de asistencia.", description = "Devuelve una lista de todos los datos de asistencia de los eventos.")
     public ResponseEntity<List<asistencia>> ListarEventos(){        
        List <asistencia> asis= new ArrayList<>();
        asis =asistenciaService.findAll();
        if (!asis.isEmpty()){
                return ResponseEntity.ok(asis);
        }else{
            return ResponseEntity.notFound().build();
        }
     }
    
     public void confirmaAsistencia(AsistenciaDTO dto){
        asistenciaService.confirmarAsistencia(dto.getIdUsuario(), dto.getIdEvento());
     }


    public void actAsistencia(AsistenciaDTO dto){
        asistenciaService.actualizaAsistencia(dto.getIdUsuario(), dto.getIdEvento(), dto.getEstado());
     }
    
}

