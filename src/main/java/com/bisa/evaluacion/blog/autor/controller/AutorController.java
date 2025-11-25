package com.bisa.evaluacion.blog.autor.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bisa.evaluacion.blog.autor.dto.AutorDto;
import com.bisa.evaluacion.blog.autor.dto.CrearAutorRequest;
import com.bisa.evaluacion.blog.autor.service.AutorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/autores")
@Tag(name = "Autores", description = "Operaciones relacionadas con autores")
public class AutorController {
    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    @Operation(summary = "Crear autor", description = "Crea un nuevo autor", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del autor a crear", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = CrearAutorRequest.class), examples = @ExampleObject(name = "EjemploCrearAutor", value = """
            {
              "nombres": "Juan Carlos",
              "apellidoPaterno": "Pérez",
              "apellidoMaterno": "García",
              "fechaNacimiento": "1980-05-15",
              "pais": "Bolivia",
              "email": "juan.perez@example.com"
            }
            """))), responses = {
            @ApiResponse(responseCode = "201", description = "Autor creado"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public ResponseEntity<AutorDto> create(@Valid @RequestBody CrearAutorRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(autorService.create(request));
    }

    @GetMapping
    @Operation(summary = "Obtener todos los autores", description = "Devuelve la lista completa de autores registrados", responses = {
            @ApiResponse(responseCode = "200", description = "Lista de autores obtenida correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AutorDto.class, type = "array"))),
            @ApiResponse(responseCode = "500", description = "Error inesperado del servidor")
    })
    public ResponseEntity<List<AutorDto>> getAll() {
        return ResponseEntity.ok(autorService.getAll());
    }
}