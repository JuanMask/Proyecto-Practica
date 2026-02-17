package com.example.proyecto_evento.DTOS;

import jakarta.validation.constraints.*;


public class UsuarioRegDTO {
    private String nombre;
    private String apellido;
    @NotBlank
    @Size(min=8, max=20)
    private String ps;
    @NotBlank
    @Email
    private String email;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getPs() {
        return ps;
    }
    public void setPs(String ps) {
        this.ps = ps;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
