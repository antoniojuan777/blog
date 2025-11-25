package com.bisa.evaluacion.blog.blog.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bisa.evaluacion.blog.blog.dto.ComentarioDto;
import com.bisa.evaluacion.blog.blog.dto.CrearComentarioRequest;
import com.bisa.evaluacion.blog.blog.mapper.ComentarioMapper;
import com.bisa.evaluacion.blog.blog.model.Blog;
import com.bisa.evaluacion.blog.blog.model.Comentario;
import com.bisa.evaluacion.blog.blog.repository.BlogRepository;
import com.bisa.evaluacion.blog.core.exceptions.BusinessException;
import com.bisa.evaluacion.blog.core.exceptions.NotFoundException;

@Service
public class ComentarioService {

    private final BlogRepository blogRepository;

    public ComentarioService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public ComentarioDto create(CrearComentarioRequest request) {

        Optional<Blog> opBlog = blogRepository.findById(request.getBlogId());
        if (!opBlog.isPresent()) {
            throw new NotFoundException("Blog no encontrado");
        }
        if (!opBlog.get().isPermiteComentarios()) {
            throw new BusinessException("El blog no permite comentarios");
        }

        Blog blog = opBlog.get();
        Comentario comentario = ComentarioMapper.toEntity(request);
        blog.getComentarios().add(comentario);

        blog.setMinCalificacion(blog.getComentarios().stream().mapToInt(Comentario::getPuntuacion).min().orElse(0));
        blog.setMaxCalificacion(blog.getComentarios().stream().mapToInt(Comentario::getPuntuacion).max().orElse(0));
        blog.setPromedioCalificacion(
                blog.getComentarios().stream().mapToInt(Comentario::getPuntuacion).average().orElse(0));

        blogRepository.save(blog);
        ComentarioDto comentarioDto = ComentarioMapper.toDto(comentario);
        return comentarioDto;
    }

}
