package com.bisa.evaluacion.blog.blog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CrearComentarioRequest {

    @NotBlank(message = "el blogId es requerido")
    private String blogId;

    @NotBlank(message = "el nombre es requerido")
    private String nombre;

    @NotBlank(message = "el email es requerido")
    @Email(message = "el email no es valido")
    private String email;

    @NotBlank(message = "el pais es requerido")
    private String pais;

    @NotBlank(message = "el comentario es requerido")
    private String comentario;

    @NotNull(message = "la puntuacion es requerida")
    @Max(value = 10, message = "la puntuacion debe ser menor o igual a 10")
    @Min(value = 0, message = "la puntuacion debe ser mayor o igual a 0")
    private Integer puntuacion;

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }
}
