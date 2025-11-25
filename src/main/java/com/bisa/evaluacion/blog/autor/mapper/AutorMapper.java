package com.bisa.evaluacion.blog.autor.mapper;

import com.bisa.evaluacion.blog.autor.dto.AutorDto;
import com.bisa.evaluacion.blog.autor.dto.CrearAutorRequest;
import com.bisa.evaluacion.blog.autor.model.Autor;

public class AutorMapper {

  public static Autor toEntity(CrearAutorRequest request) {
    Autor autor = new Autor();
    autor.setNombres(request.getNombres());
    autor.setApellidoPaterno(request.getApellidoPaterno());
    autor.setApellidoMaterno(request.getApellidoMaterno());
    autor.setFechaNacimiento(request.getFechaNacimiento());
    autor.setPais(request.getPais());
    autor.setEmail(request.getEmail());
    return autor;
  }

  public static AutorDto toDto(Autor autor) {
    AutorDto autorDto = new AutorDto();
    autorDto.setId(autor.getId());
    autorDto.setNombres(autor.getNombres());
    autorDto.setApellidoPaterno(autor.getApellidoPaterno());
    autorDto.setApellidoMaterno(autor.getApellidoMaterno());
    autorDto.setFechaNacimiento(autor.getFechaNacimiento());
    autorDto.setPais(autor.getPais());
    autorDto.setEmail(autor.getEmail());
    return autorDto;
  }
}
