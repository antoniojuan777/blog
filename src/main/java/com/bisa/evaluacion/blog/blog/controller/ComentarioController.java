package com.bisa.evaluacion.blog.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bisa.evaluacion.blog.blog.dto.ComentarioDto;
import com.bisa.evaluacion.blog.blog.dto.CrearComentarioRequest;
import com.bisa.evaluacion.blog.blog.service.ComentarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/comentarios")
@Tag(name = "Comentarios", description = "Operaciones relacionadas con comentarios")
public class ComentarioController {
    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo comentario", description = "Crea un comentario en un blog existente con los datos proporcionados", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del comentario a crear", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = CrearComentarioRequest.class), examples = @ExampleObject(name = "EjemploCrearComentario", value = """
            {
              "blogId": "abc123",
              "nombre": "María López",
              "email": "maria.lopez@example.com",
              "pais": "Bolivia",
              "comentario": "Excelente artículo, muy informativo.",
              "puntuacion": 9
            }
            """))), responses = {
            @ApiResponse(responseCode = "201", description = "Comentario creado correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CrearComentarioRequest.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"),
            @ApiResponse(responseCode = "404", description = "Blog no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error inesperado del servidor")
    })
    public ResponseEntity<ComentarioDto> create(@Valid @RequestBody CrearComentarioRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioService.create(request));
    }
}