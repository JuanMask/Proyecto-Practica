package com.example.proyecto_evento.Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto_evento.DTOS.CrearEventoDTO;
import com.example.proyecto_evento.Models.evento;
import com.example.proyecto_evento.Models.usuario;
import com.example.proyecto_evento.Services.EventoService;
import com.example.proyecto_evento.Services.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/evento")
@Tag(name = "Eventos", description = "Endpoints de gestión de eventos: Creación de un evento, Listar los eventos existentes, Eliminar un evento.")
public class EventoController {
    @Autowired
    private EventoService eventoService;
    @Autowired
    private UsuarioService usuarioService;
    //Modificarla para que lo guarde
  
 @PostMapping("/cEvento")// Crear Evento
    @Operation(summary = "Creacion de Evento", description = "Devuelve un ok cuando se crea un evento.")
    public ResponseEntity <?> CreaEvento( @RequestBody CrearEventoDTO eve){
        System.out.println("Evento a registrar: "+eve.getNombre() + " " + eve.getDescripcion() + " " + eve.getFechaEvento() + " " + eve.getCreador());        
        try {
            int idt = usuarioService.findIdByEmail(eve.getCreador());
            eventoService.insertarEvento(
                eve.getNombre(),
                eve.getDescripcion(),
                eve.getFechaEvento(),
                idt
            );
            return ResponseEntity.ok().body(
                Map.of("mensaje", "Evento creado correctamente")
            );
        } catch (Exception e){
            return ResponseEntity
                .badRequest()
                .body("Error al crear evento: " + e.getMessage());
        }
    }
    @GetMapping("/listar")//mostrar eventos
    @Operation(summary = "Listado de eventos creados.", description = "Devuelve una Lista de eventos creados.")
     public ResponseEntity<List<evento>> ListarEventos(){        
        List <evento> eventos= new ArrayList<>();
        List <String> pAsist = new ArrayList<>(); 
        eventos =eventoService.findAll();
        if (!eventos.isEmpty()){
            for(int i=0; i<eventos.size(); i++){
                evento  p= eventos.get(i);
                pAsist.add(p.getNombre() + " " + p.getDescripcion() + " " + p.getFecha_creacion() + " " + p.getFecha_evento() + " " + p.getId_evento());
            }
<<<<<<< HEAD
                //return ResponseEntity.ok().build();
                return ResponseEntity.ok(eventoService.findAll());
=======
                return ResponseEntity.ok(eventos);
>>>>>>> 08b33985879889556bd529bf3bd451924d949ac2
        }else{
            return ResponseEntity.notFound().build();
        }
     }
    
@DeleteMapping("/dEvento/{id}") //Eliminar evento
@Operation(summary = "Eliminar evento y su informacion", description = "Devuelve una OK cuando el evento se ha eliminado.")
public ResponseEntity<Void> EliminarEvento(@PathVariable("id") int id_eve) {
    evento eve= new evento();
    String ids= ""+eve.getId_evento()+" "+id_eve;
    System.out.print(ids );
    eventoService.deleteAllById(id_eve );
    return ResponseEntity.ok().build();
}



}

