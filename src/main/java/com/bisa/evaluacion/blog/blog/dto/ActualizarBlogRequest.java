package com.bisa.evaluacion.blog.blog.dto;

import com.bisa.evaluacion.blog.blog.enums.Periodicidad;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ActualizarBlogRequest {

    @NotBlank(message = "autorId es requerido")
    private String autorId;

    @NotBlank(message = "titulo es requerido")
    private String titulo;

    @NotBlank(message = "tema es requerido")
    private String tema;

    @NotBlank(message = "contenido es requerido")
    private String contenido;

    @NotNull(message = "periodicidad es requerida")
    private Periodicidad periodicidad;

    @NotNull(message = "permiteComentarios es requerida")
    private boolean permiteComentarios = true;

    public String getAutorId() {
        return autorId;
    }

    public void setAutorId(String autorId) {
        this.autorId = autorId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Periodicidad getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(Periodicidad periodicidad) {
        this.periodicidad = periodicidad;
    }

    public Boolean isPermiteComentarios() {
        return permiteComentarios;
    }

    public void setPermiteComentarios(Boolean permiteComentarios) {
        this.permiteComentarios = permiteComentarios;
    }
}
