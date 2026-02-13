package com.example.proyecto_evento.Controllers;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.proyecto_evento.DTOS.CrearEventoDTO;
import com.example.proyecto_evento.Models.evento;
import com.example.proyecto_evento.Services.EventoService;
import com.example.proyecto_evento.Services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/evento")
@Tag(name = "Eventos", description = "Endpoints de gestión de eventos: Creación de un evento, Listar los eventos existentes, Eliminar un evento.")
public class EventoController {
    @Autowired
    private EventoService eventoService;
    @Autowired
    private UsuarioService usuarioService;
  
 @PostMapping("/cEvento")// Crear Evento
    @Operation(summary = "Creacion de Evento", description = "Devulve un ok cuando se crea un evento.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Evento creado.",content = @Content(schema = @Schema(implementation = evento.class))),
        @ApiResponse(responseCode = "400", description = "Evento no creado, ya existe o se equivoco al ingresar algun dato.")
    })    
    public ResponseEntity <CrearEventoDTO> CreaEvento(@Valid @RequestBody CrearEventoDTO eve){
        //System.out.println("Evento a registrar: "+eve.getNombre() + " " + eve.getDescripcion() + " " + eve.getFechaEvento() + " " + eve.getCreador());        
        int idt = usuarioService.findIdByUsername(eve.getCreador());
        eventoService.insertarEvento(eve.getNombre(), eve.getDescripcion(), eve.getFechaEvento(), idt);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar")//mostrar eventos
    @Operation(summary = "Listado de eventos creados.", description = "Devuelve una Lista de eventos creados.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de eventos creada con exito.", content = @Content(schema = @Schema(implementation = evento.class))),
        @ApiResponse(responseCode = "400", description = "Error al crear lista de eventos.")
    })    
     public ResponseEntity<List<evento>> ListarEventos(){        
        List <evento> eventos= new ArrayList<>();
        List <String> pAsist = new ArrayList<>(); 
        eventos =eventoService.findAll();
        if (!eventos.isEmpty()){
            for(int i=0; i<eventos.size(); i++){
                evento  p= eventos.get(i);
                pAsist.add(p.getNombre() + " " + p.getDescripcion() + " " + p.getFecha_creacion() + " " + p.getFecha_evento() + " " + p.getId_evento());
            }
                return ResponseEntity.ok(eventos);
        }else{
            return ResponseEntity.notFound().build();
        }
     }
    
    @DeleteMapping("/dEvento/{id}") //Eliminar evento
    @Operation(summary = "Elimiar evento y su informacion", description = "Devuelve una OK cuando el evento se ha eliminado.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Evento eliminado con exito.", content = @Content(schema = @Schema(implementation = evento.class))),
        @ApiResponse(responseCode = "400", description = "Error al eliminar evento.")
    })    
    public ResponseEntity<Void> EliminarEvento(@PathVariable("id") int id_eve) {
        evento eve= new evento();
        String ids= ""+eve.getId_evento()+" "+id_eve;
        System.out.print(ids );
        eventoService.deleteById(id_eve );
        return ResponseEntity.ok().build();
    }



}
