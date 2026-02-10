package com.example.proyecto_evento.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class evento {
    @Id
    @Column(name = "id_evento")
    private int id_evento;
    @ManyToOne
    @JoinColumn(name = "id_creador")
    private usuario usu;

    
    //private int id_creador; // creador del evento
    private String nombre;
    private String descripcion;
    private Date fecha_evento;
    private String fecha_creacion;
    private boolean activo;
    
    public evento() {
    }
    public evento(int id_evento, String nombre, String descripcion, Date fecha_evento,
            String fecha_creacion, boolean activo, usuario idUsuario) {
        this.id_evento = id_evento;
        //this.id_creador = id_creador;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_evento = fecha_evento;
        this.fecha_creacion = fecha_creacion;
        this.activo = activo;
    }



    public int getId_evento() {
        return id_evento;
    }
    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }
/*    public int getId_creador() {
        return id_creador;
    }
    public void setId_creador(int id_creador) {
        this.id_creador = id_creador;
    }*/
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Date getFecha_evento() {
        return fecha_evento;
    }
    public void setFecha_evento(Date fecha_evento) {
        this.fecha_evento = fecha_evento;
    }
    public String getFecha_creacion() {
        return fecha_creacion;
    }
    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public usuario getUsu() {
        return usu;
    }
    public void setUsu(usuario usu) {
        this.usu = usu;
    }
   
   


}
