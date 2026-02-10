package com.example.proyecto_evento.Models;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
//Arreglar las relaciones de las columnas
@Entity
public class asistencia {
    @Id
    private int id_asistencia;
    @OneToMany
    @JoinColumn(name = "id_evento")
    private evento eve;
    private int id_evento;
    @ManyToMany
    @JoinColumn(name = "id_usuario")
    private usuario usu;
    private int id_usuario;
    private boolean estado;
    private String fecha_registro;
    public asistencia() {
    }
    public asistencia(int id_asistencia, int id_evento, int id_usuario, boolean estado, String fecha_registro) {
        this.id_asistencia = id_asistencia;
        this.id_evento = id_evento;
        this.id_usuario = id_usuario;
        this.estado = estado;
        this.fecha_registro = fecha_registro;
    }
    public int getId_asistencia() {
        return id_asistencia;
    }
    public void setId_asistencia(int id_asistencia) {
        this.id_asistencia = id_asistencia;
    }
    public int getId_evento() {
        return id_evento;
    }
    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }
    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public String getFecha_registro() {
        return fecha_registro;
    }
    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    public evento getEve() {
        return eve;
    }
    public void setEve(evento eve) {
        this.eve = eve;
    }
    public usuario getUsu() {
        return usu;
    }
    public void setUsu(usuario usu) {
        this.usu = usu;
    }
    

}
