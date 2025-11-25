package com.bisa.evaluacion.blog.blog.dto;

import java.util.List;

import com.bisa.evaluacion.blog.autor.dto.AutorDto;
import com.bisa.evaluacion.blog.blog.enums.Periodicidad;

public class BlogDto {

    private String id;
    private AutorDto autor;
    private String titulo;
    private String tema;
    private String contenido;
    private Periodicidad periodicidad;
    private boolean permiteComentarios;
    private List<ComentarioDto> comentarios;
    private Integer minCalificacion;
    private Integer maxCalificacion;
    private Double promedioCalificacion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AutorDto getAutor() {
        return autor;
    }

    public void setAutor(AutorDto autor) {
        this.autor = autor;
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

    public boolean isPermiteComentarios() {
        return permiteComentarios;
    }

    public void setPermiteComentarios(boolean permiteComentarios) {
        this.permiteComentarios = permiteComentarios;
    }

    public List<ComentarioDto> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioDto> comentarios) {
        this.comentarios = comentarios;
    }

    public Integer getMinCalificacion() {
        return minCalificacion;
    }

    public void setMinCalificacion(Integer minCalificacion) {
        this.minCalificacion = minCalificacion;
    }

    public Integer getMaxCalificacion() {
        return maxCalificacion;
    }

    public void setMaxCalificacion(Integer maxCalificacion) {
        this.maxCalificacion = maxCalificacion;
    }

    public Double getPromedioCalificacion() {
        return promedioCalificacion;
    }

    public void setPromedioCalificacion(Double promedioCalificacion) {
        this.promedioCalificacion = promedioCalificacion;
    }
}
