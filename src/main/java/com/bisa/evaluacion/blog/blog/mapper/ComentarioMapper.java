package com.bisa.evaluacion.blog.blog.mapper;

import com.bisa.evaluacion.blog.blog.dto.ComentarioDto;
import com.bisa.evaluacion.blog.blog.dto.CrearComentarioRequest;
import com.bisa.evaluacion.blog.blog.model.Comentario;

public class ComentarioMapper {

    public static Comentario toEntity(CrearComentarioRequest request) {
        Comentario comentario = new Comentario();
        comentario.setNombre(request.getNombre());
        comentario.setEmail(request.getEmail());
        comentario.setPais(request.getPais());
        comentario.setComentario(request.getComentario());
        comentario.setPuntuacion(request.getPuntuacion());
        return comentario;
    }

    public static ComentarioDto toDto(Comentario comentario) {
        ComentarioDto comentarioDto = new ComentarioDto();
        comentarioDto.setNombre(comentario.getNombre());
        comentarioDto.setEmail(comentario.getEmail());
        comentarioDto.setPais(comentario.getPais());
        comentarioDto.setComentario(comentario.getComentario());
        comentarioDto.setPuntuacion(comentario.getPuntuacion());
        return comentarioDto;
    }
}
