package com.bisa.evaluacion.blog.autor.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CrearAutorRequest {
    @NotBlank(message = "los nombres son requeridos")
    private String nombres;

    @NotBlank(message = "el apellido paterno es requerido")
    private String apellidoPaterno;

    @NotBlank(message = "el apellido materno es requerido")
    private String apellidoMaterno;

    @NotNull(message = "la fecha de nacimiento es requerida (yyyy-MM-dd)")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "el pais es requerido")
    private String pais;

    @Email(message = "el email debe ser válido")
    private String email;

    public CrearAutorRequest() {
    }

    public CrearAutorRequest(String nombres, String apellidoPaterno, String apellidoMaterno,
            LocalDate fechaNacimiento, String pais, String email) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.pais = pais;
        this.email = email;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
