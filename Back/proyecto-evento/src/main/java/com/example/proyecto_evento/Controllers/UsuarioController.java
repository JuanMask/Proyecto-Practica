package com.example.proyecto_evento.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto_evento.DTOS.AsistenciaDTO;
import com.example.proyecto_evento.DTOS.UsuarioDTO;
import com.example.proyecto_evento.DTOS.UsuarioRegDTO;
import com.example.proyecto_evento.Models.usuario;
import com.example.proyecto_evento.Services.AsistenciaService;
import com.example.proyecto_evento.Services.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins= "http://localhost:4200")
@Tag(name = "Usuarios", description = "Endpoints de gestión de usuarios: Registro, Inicio de sesion.")
public class UsuarioController {
    
    @Autowired
    public UsuarioService usuarioService;

   @PostMapping("/reg")// Guardar usuario
   @Operation(summary = "Registro de un usuario a la api.", description = "Devuelve una OK cuando el registro se ha completado.")
   public ResponseEntity<String> GuardaUsuario(@RequestBody UsuarioRegDTO persona){
        //System.out.println("Persona a registrar: "+persona.getNombre()+" "+persona.getApellido()+ " "+ persona.getEmail()+" "+persona.getPs());
        usuarioService.insertarUsuario(
            persona.getNombre(),
            persona.getApellido(),
            persona.getEmail(),
            persona.getPs()
        );
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/log")// Comprobar usuario
        @Operation(summary = "inicio de session de un usuario.", description = "Devuelve una OK cuando el usuario ha sido autenticado.")
    public ResponseEntity CompruebaUsuario( @RequestBody UsuarioDTO persona){
        if(usuarioService.login(persona.getEmail(), persona.getPs())){
            System.out.println("contraseña valida");               
                return ResponseEntity.ok().build();
        }else{
            System.out.println("contraseña erronea");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }        
    }
    @GetMapping("/listar")// Listar todas las personas en la bd
        @Operation(summary = "Lista a los usuarios registrados.", description = "Devuelve una lista de usuarios que se han registrado.")
    public ResponseEntity<List<String>> ListarUsuarios(){        
        List <usuario> personas= new ArrayList<>();
        List <String> pAsist = new ArrayList<>(); 
        personas =usuarioService.findAll();
        if (!personas.isEmpty()){
            for(int i=0; i<personas.size(); i++){
                usuario  p= personas.get(i);
                pAsist.add(p.getNombre() + " " + p.getApellido());
            }
                return ResponseEntity.ok(pAsist);
        }else{
            
            return ResponseEntity.notFound().build();
        }
     }



//metodo usuario modifica su asistencia a un evento
/*@PutMapping("/modAsistencia")
public ResponseEntity ModificarAsistencia(@RequestBody AsistenciaDTO asistenciaDTO) {
    AsistenciaService asistenciaService = null;
    asistenciaService.actualizaAsistencia(asistenciaDTO.getIdUsuario(), asistenciaDTO.getIdEvento(), asistenciaDTO.getEstado());
    return ResponseEntity.ok(null);
}*/



}

