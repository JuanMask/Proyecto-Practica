package com.example.proyecto_evento.Controllers;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.proyecto_evento.DTOS.AsistenciaDTO;
import com.example.proyecto_evento.Models.asistencia;
import com.example.proyecto_evento.Models.usuario;
import com.example.proyecto_evento.Services.AsistenciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/asistencia")
@Tag(name = "Asistencia de Usuarios.", description = "Endpoints de gestión de Asistencia a un evento por parte de un usuario: Se actualiza la asistencia de un usuario.")
public class AsistenciaController {
   
    @Autowired
    public AsistenciaService asistenciaService;
    
    @PutMapping("/actualiza")//Actualiar asistencia
    @Operation(summary = "Actualizar la asistencia a un evento de un usuario.", description = "Devuelve una OK cuando la asistencia se ha actualizado.")
        @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Actualizacion de asistencia del usuario realizada con exito.", content = @Content(schema = @Schema(implementation = asistencia.class))),
        @ApiResponse(responseCode = "400", description = "Error al actualizar la asistencia del usuario.")
    })    
    public ResponseEntity<Void> actualizaAsistencia(@Valid @RequestBody AsistenciaDTO dto) {
        this.actAsistencia(dto);     
        return ResponseEntity.ok().build();
    }


  @GetMapping("/listar")//mostrar eventos
  @Operation(summary = "Obtener todos los datos de asistencia.", description = "Devuelve una lista de todos los datos de asistencia de los eventos.")
  @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de todos los datos de asistencia creada con exito.", content = @Content(schema = @Schema(implementation = usuario.class))),
        @ApiResponse(responseCode = "400", description = "Error al crear lista de datos de asistencia.")
    })    
     public ResponseEntity<List<asistencia>> ListarEventos(){        
        List <asistencia> asis= new ArrayList<>();
        asis =asistenciaService.findAll();
        if (!asis.isEmpty()){
                return ResponseEntity.ok(asis);
        }else{
            return ResponseEntity.notFound().build();
        }
     }
    
     public void confirmaAsistencia(@Valid AsistenciaDTO dto){
        asistenciaService.confirmarAsistencia(dto.getIdUsuario(), dto.getIdEvento());
     }


    public void actAsistencia(@Valid AsistenciaDTO dto){
        asistenciaService.actualizaAsistencia(dto.getIdUsuario(), dto.getIdEvento(), dto.getEstado());
     }
    
}
