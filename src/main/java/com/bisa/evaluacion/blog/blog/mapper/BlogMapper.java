package com.bisa.evaluacion.blog.blog.mapper;

import java.util.stream.Collectors;

import com.bisa.evaluacion.blog.autor.mapper.AutorMapper;
import com.bisa.evaluacion.blog.blog.dto.BlogDto;
import com.bisa.evaluacion.blog.blog.dto.CrearBlogRequest;
import com.bisa.evaluacion.blog.blog.model.Blog;

public class BlogMapper {

    public static Blog toEntity(CrearBlogRequest request) {
        Blog blog = new Blog();
        blog.setTitulo(request.getTitulo());
        blog.setTema(request.getTema());
        blog.setContenido(request.getContenido());
        blog.setPeriodicidad(request.getPeriodicidad());
        blog.setPermiteComentarios(request.isPermiteComentarios());
        return blog;
    }

    public static BlogDto toDto(Blog blog) {
        BlogDto blogDto = new BlogDto();
        blogDto.setId(blog.getId());
        blogDto.setTitulo(blog.getTitulo());
        blogDto.setTema(blog.getTema());
        blogDto.setContenido(blog.getContenido());
        blogDto.setPeriodicidad(blog.getPeriodicidad());
        blogDto.setPermiteComentarios(blog.isPermiteComentarios());
        blogDto.setAutor(AutorMapper.toDto(blog.getAutor()));
        blogDto.setMinCalificacion(blog.getMinCalificacion());
        blogDto.setMaxCalificacion(blog.getMaxCalificacion());
        blogDto.setPromedioCalificacion(blog.getPromedioCalificacion());
        blogDto.setComentarios(
                blog.getComentarios().stream().map(ComentarioMapper::toDto).collect(Collectors.toList()));
        return blogDto;
    }
}
