package com.example.proyecto_evento.DTOS;

import java.security.Timestamp;
import java.util.Date;

public class CrearEventoDTO {
private String nombre;
private String descripcion;
private Date fechaEvento;
private String creador;
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
public Date getFechaEvento() {
    return fechaEvento;
}
public void setFechaEvento(Date fechaEvento) {
    this.fechaEvento = fechaEvento;
}
public String getCreador() {
    return creador;
}
public void setCreador(String creador) {
    this.creador = creador;
}

}
