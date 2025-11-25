package com.bisa.evaluacion.blog.blog.mapper;

import com.bisa.evaluacion.blog.autor.mapper.AutorMapper;
import com.bisa.evaluacion.blog.blog.dto.BlogSnapshotDto;
import com.bisa.evaluacion.blog.blog.model.BlogSnapshot;

public class BlogSnapshotMapper {

    public static BlogSnapshotDto toDto(BlogSnapshot blog) {
        BlogSnapshotDto blogDto = new BlogSnapshotDto();
        blogDto.setId(blog.getId());
        blogDto.setTitulo(blog.getTitulo());
        blogDto.setTema(blog.getTema());
        blogDto.setContenido(blog.getContenido());
        blogDto.setPeriodicidad(blog.getPeriodicidad());
        blogDto.setPermiteComentarios(blog.isPermiteComentarios());
        blogDto.setAutor(AutorMapper.toDto(blog.getAutor()));
        return blogDto;
    }
}
