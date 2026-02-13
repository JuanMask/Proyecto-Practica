package com.example.proyecto_evento.DTOS;


import jakarta.validation.constraints.*;

public class UsuarioDTO {

    @NotBlank
    @Size(min=8, max= 50)
    private String ps;
    @NotBlank
    @Email
    private String email;
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
