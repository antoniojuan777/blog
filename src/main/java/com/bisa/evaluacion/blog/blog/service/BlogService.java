package com.bisa.evaluacion.blog.blog.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bisa.evaluacion.blog.autor.model.Autor;
import com.bisa.evaluacion.blog.autor.repository.AutorRepository;
import com.bisa.evaluacion.blog.blog.dto.ActualizarBlogRequest;
import com.bisa.evaluacion.blog.blog.dto.BlogDto;
import com.bisa.evaluacion.blog.blog.dto.BlogSnapshotDto;
import com.bisa.evaluacion.blog.blog.dto.CrearBlogRequest;
import com.bisa.evaluacion.blog.blog.mapper.BlogMapper;
import com.bisa.evaluacion.blog.blog.mapper.BlogSnapshotMapper;
import com.bisa.evaluacion.blog.blog.model.Blog;
import com.bisa.evaluacion.blog.blog.model.BlogSnapshot;
import com.bisa.evaluacion.blog.blog.repository.BlogRepository;
import com.bisa.evaluacion.blog.blog.repository.HistorialBlogRepository;
import com.bisa.evaluacion.blog.core.exceptions.NotFoundException;

import org.springframework.stereotype.Service;

@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final AutorRepository autorRepository;
    private final HistorialBlogRepository historialBlogRepository;

    public BlogService(BlogRepository blogRepository, AutorRepository autorRepository,
            HistorialBlogRepository historialBlogRepository) {
        this.blogRepository = blogRepository;
        this.autorRepository = autorRepository;
        this.historialBlogRepository = historialBlogRepository;
    }

    public BlogDto create(CrearBlogRequest request) {

        Blog blog = BlogMapper.toEntity(request);
        Optional<Autor> opAutor = autorRepository.findById(request.getAutorId());
        if (!opAutor.isPresent()) {
            throw new NotFoundException("Autor no encontrado");
        }

        blog.setAutor(opAutor.get());
        blogRepository.save(blog);
        BlogDto blogDto = BlogMapper.toDto(blog);
        return blogDto;
    }

    public BlogDto get(String id) {
        Optional<Blog> opBlog = blogRepository.findById(id);
        if (!opBlog.isPresent()) {
            throw new NotFoundException("Blog no encontrado");
        }
        return BlogMapper.toDto(opBlog.get());
    }

    public List<BlogDto> getAll() {
        return blogRepository.findAll().stream().map(BlogMapper::toDto).collect(Collectors.toList());
    }

    public BlogDto update(String id, ActualizarBlogRequest request) {
        // valida existencia de blog y autor
        Optional<Blog> opBlog = blogRepository.findById(id);
        if (!opBlog.isPresent()) {
            throw new NotFoundException("Blog no encontrado");
        }
        Optional<Autor> opAutor = autorRepository.findById(request.getAutorId());
        if (!opAutor.isPresent()) {
            throw new NotFoundException("Autor no encontrado");
        }

        // historial
        BlogSnapshot blogHistorial = new BlogSnapshot();
        blogHistorial.setId(opBlog.get().getId());
        blogHistorial.setTitulo(opBlog.get().getTitulo());
        blogHistorial.setContenido(opBlog.get().getContenido());
        blogHistorial.setAutor(opBlog.get().getAutor());
        blogHistorial.setPeriodicidad(opBlog.get().getPeriodicidad());
        blogHistorial.setPermiteComentarios(opBlog.get().isPermiteComentarios());
        blogHistorial.setTema(opBlog.get().getTema());
        historialBlogRepository.add(blogHistorial);

        // blog actualizado
        Blog blog = opBlog.get();
        blog.setTitulo(request.getTitulo());
        blog.setContenido(request.getContenido());
        blog.setAutor(opAutor.get());
        blog.setPeriodicidad(request.getPeriodicidad());
        blog.setPermiteComentarios(request.isPermiteComentarios());
        blog.setTema(request.getTema());
        blogRepository.save(blog);

        return BlogMapper.toDto(blog);
    }

    public List<BlogSnapshotDto> getHistorial(String id) {
        return historialBlogRepository.findByBlogId(id).stream().map(BlogSnapshotMapper::toDto).collect(Collectors.toList());
    }
}
