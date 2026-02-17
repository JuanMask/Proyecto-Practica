package com.example.proyecto_evento.DTOS;

import java.util.Date;
import jakarta.validation.constraints.*;

public class CrearEventoDTO {
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @FutureOrPresent
    private Date fechaEvento;
    @NotBlank
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
