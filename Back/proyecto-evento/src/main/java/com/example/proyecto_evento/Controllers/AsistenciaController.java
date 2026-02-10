package com.example.proyecto_evento.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto_evento.Services.AsistenciaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/asistencia")
public class AsistenciaController {
   
    //@Autowired
    //public AsistenciaService asistenciaService;

   /* @PostMapping("/gAsistencia")//Guardar la asistencia
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }


    @GetMapping("/mAsistencia")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }*/
    
}
