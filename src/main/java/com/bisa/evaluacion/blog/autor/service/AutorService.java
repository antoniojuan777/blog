package com.bisa.evaluacion.blog.autor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bisa.evaluacion.blog.autor.dto.AutorDto;
import com.bisa.evaluacion.blog.autor.dto.CrearAutorRequest;
import com.bisa.evaluacion.blog.autor.mapper.AutorMapper;
import com.bisa.evaluacion.blog.autor.model.Autor;
import com.bisa.evaluacion.blog.autor.repository.AutorRepository;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public AutorDto create(CrearAutorRequest request) {
        Autor autor = AutorMapper.toEntity(request);
        autorRepository.save(autor);
        return AutorMapper.toDto(autor);
    }

    public List<AutorDto> getAll() {
        return autorRepository.findAll().stream().map(AutorMapper::toDto).collect(Collectors.toList());
    }

    public AutorDto findById(String id) {
        return autorRepository.findById(id).map(AutorMapper::toDto).orElse(null);
    }
}
