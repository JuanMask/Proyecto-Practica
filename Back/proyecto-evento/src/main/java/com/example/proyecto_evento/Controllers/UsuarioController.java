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

import com.example.proyecto_evento.Models.usuario;
import com.example.proyecto_evento.Services.UsuarioService;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins= "http://localhost:4200")
public class UsuarioController {
    
    @Autowired
    public UsuarioService usuarioService;

   @PostMapping("/reg")// Guardar usuario
    public ResponseEntity <usuario> GuardaUsuario(@NotBlank @RequestBody usuario persona){
        //System.out.println("Persona a registrar: "+persona.getNombre()+" "+persona.getApellido()+ " "+ persona.getEmail()+" "+persona.getPs());
        usuarioService.insertarUsuario(persona.getNombre(),persona.getApellido(), persona.getEmail(), persona.getPs());
        return ResponseEntity.ok(persona);           
    }

    @PostMapping("/log")// Comprobar usuario
    public ResponseEntity CompruebaUsuario( @RequestBody usuario persona){//@RequestParam("correo") String correo, @RequestParam("ps") String ps) {
    //System.out.println("email:"+ persona.getEmail() + " ps:"+ persona.getPs());
        if(usuarioService.login(persona.getEmail(), persona.getPs())){
            System.out.println("contraseña valida");               
                return ResponseEntity.ok().build();
        }else{
            System.out.println("contraseña erronea");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }        
    }

    @GetMapping("/listar")// Listar todas las personas en la bd
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

//Metodo usuario se registra a un evento

//metodo usuario modifica su asistencia a un evento



}
