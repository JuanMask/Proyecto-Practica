package com.example.proyecto_evento.Controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.proyecto_evento.DTOS.UsuarioDTO;
import com.example.proyecto_evento.DTOS.UsuarioRegDTO;
import com.example.proyecto_evento.Models.usuario;
import com.example.proyecto_evento.Services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
      @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuario registrado.", content = @Content(schema = @Schema(implementation = usuario.class))),
        @ApiResponse(responseCode = "400", description = "Usuario no registrado, ya existe o se equivoco al ingresar algun dato.")
    })
    public ResponseEntity <UsuarioRegDTO> GuardaUsuario(@Valid @RequestBody UsuarioRegDTO persona){
        if(usuarioService.findAllEmail().contains(persona.getEmail())){
            usuarioService.insertarUsuario(persona.getNombre(),persona.getApellido(), persona.getEmail(), persona.getPs());
            return ResponseEntity.ok(persona);
        }else{
            return ResponseEntity.badRequest().build();
        }
        //System.out.println("Persona a registrar: "+persona.getNombre()+" "+persona.getApellido()+ " "+ persona.getEmail()+" "+persona.getPs());     
    }

    @PostMapping("/log")// Comprobar usuario
        @Operation(summary = "inicio de session de un usuario.", description = "Devuelve una OK cuando el usuario ha sido autenticado.")            
        @ApiResponses(value = { 
            @ApiResponse(responseCode = "200",  description = "Usuario encontrado.", content = @Content(schema = @Schema(implementation = usuario.class))),
            @ApiResponse(responseCode = "400", description = "Usuario no encontrado, no existe o se equivoco al ingresar algun dato.")
                })        
    public ResponseEntity<Void> CompruebaUsuario(@Valid @RequestBody UsuarioDTO persona){
            if(usuarioService.login(persona.getEmail(), persona.getPs())){
                //System.out.println("contraseña valida");                              
                return ResponseEntity.ok().build();
            }else{
                //System.out.println("contraseña erronea");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            } 
    }
    @GetMapping("/listar")// Listar todas las personas en la bd
        @Operation(summary = "Lista los nombres y apellidos de los usuarios registrados.", description = "Devuelve una lista de los nombres y apellidos de los usuarios que se han registrado.")      
              @ApiResponses(value = {
                    @ApiResponse(responseCode = "200", description = "Usuarios encontrados.", content = @Content(schema = @Schema(implementation = usuario.class))),
                    @ApiResponse(responseCode = "400", description = "Usuarios no encontrados, no existen datos de usuarios en la db.")
                })  
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




}
