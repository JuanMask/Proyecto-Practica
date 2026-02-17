package com.example.proyecto_evento.DTOS;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class AsistenciaDTO {
    @Positive
    @NotBlank
    private Integer idUsuario;
    @Positive
    @NotBlank
    private Integer idEvento;
    @NotBlank
    private Boolean estado;

    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Integer getIdEvento() {
        return idEvento;
    }
    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}

