package com.example.proyecto_evento.Models;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class usuario {
    @Id
    private Integer id_usuario;
    private String nombre;
    private String apellido;
   // private boolean Conf_Asis; //Confirmar asistencia
    // private boolean EsAdmin;
    private String email;
    private String ps;
    private Timestamp fecha_registro;

    
    public usuario(Integer id_usuario, String nombre, String apellido, String email,
            String ps) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.ps = ps;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPs() {
        return ps;
    }
    public void setPs(String ps) {
        this.ps = ps;
    }
   /* public boolean isEsAdmin() {
        return EsAdmin;
    }
    public void setEsAdmin(boolean esAdmin) {
        EsAdmin = esAdmin;
    } */
    public usuario() {
    }
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
    /*public boolean isConf_Asis() {
        return Conf_Asis;
    }
    public void setConf_Asis(boolean conf_Asis) {
        Conf_Asis = conf_Asis;
    }*/
    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    public Timestamp getFecha_registro() {
        return fecha_registro;
    }
    public void setFecha_registro(Timestamp fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    

}
