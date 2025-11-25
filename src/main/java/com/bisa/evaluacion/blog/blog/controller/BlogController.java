package com.bisa.evaluacion.blog.blog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bisa.evaluacion.blog.blog.dto.ActualizarBlogRequest;
import com.bisa.evaluacion.blog.blog.dto.BlogDto;
import com.bisa.evaluacion.blog.blog.dto.BlogSnapshotDto;
import com.bisa.evaluacion.blog.blog.dto.CrearBlogRequest;
import com.bisa.evaluacion.blog.blog.service.BlogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/blogs")
@Tag(name = "Blogs", description = "Operaciones relacionadas con blogs")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    @Operation(summary = "Crear blog", description = "Crea un nuevo blog", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del nuevo blog", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = CrearBlogRequest.class), examples = @ExampleObject(name = "EjemploBlog", value = "{\"autorId\":\"123-asd-asd-ew3\",\"titulo\":\"ranking de musica\",\"tema\":\"Musica\",\"contenido\":\"contenido de prueba para el blog\",\"periodicidad\":\"SEMANAL\",\"permiteComentarios\":true}"))), responses = {
            @ApiResponse(responseCode = "201", description = "Blog creado"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public ResponseEntity<BlogDto> create(@Valid @RequestBody CrearBlogRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(blogService.create(request));
    }

    @Operation(summary = "Obtener todos los blogs", description = "Devuelve la lista completa de blogs registrados", responses = {
            @ApiResponse(responseCode = "200", description = "Lista de blogs obtenida correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BlogDto.class, type = "array"))),
            @ApiResponse(responseCode = "500", description = "Error inesperado del servidor")
    })
    @GetMapping
    public ResponseEntity<List<BlogDto>> getAll() {
        return ResponseEntity.ok(blogService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener blog por ID", description = "Devuelve un blog específico por su ID", responses = {
            @ApiResponse(responseCode = "200", description = "Blog obtenido correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BlogDto.class))),
            @ApiResponse(responseCode = "404", description = "Blog no encontrado")
    })
    public ResponseEntity<BlogDto> get(@PathVariable String id) {
        return ResponseEntity.ok(blogService.get(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar blog", description = "Actualiza un blog específico por su ID", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos para actualizar un blog", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = ActualizarBlogRequest.class), examples = @ExampleObject(name = "EjemploActualizarBlog", value = """
            {
              "autorId": "12345",
              "titulo": "Nuevo título del blog",
              "tema": "Tecnología",
              "contenido": "Contenido actualizado del blog",
              "periodicidad": "MENSUAL",
              "permiteComentarios": false
            }
            """))), responses = {
            @ApiResponse(responseCode = "200", description = "Blog actualizado correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BlogDto.class))),
            @ApiResponse(responseCode = "404", description = "Blog no encontrado")
    })
    public ResponseEntity<BlogDto> update(@PathVariable String id, @RequestBody ActualizarBlogRequest req) {
        return ResponseEntity.ok(blogService.update(id, req));
    }

    @Operation(summary = "Obtener el historial de blogs", description = "Devuelve la lista de blogs con sus versiones anteriores", responses = {
            @ApiResponse(responseCode = "200", description = "Lista de blogs obtenida correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BlogDto.class, type = "array"))),
            @ApiResponse(responseCode = "500", description = "Error inesperado del servidor")
    })
    @GetMapping("/historial")
    public ResponseEntity<List<BlogSnapshotDto>> getHistorial() {
        return ResponseEntity.ok(blogService.getHistorial());
    }
}
