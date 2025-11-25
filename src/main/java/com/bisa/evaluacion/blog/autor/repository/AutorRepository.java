package com.bisa.evaluacion.blog.autor.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.bisa.evaluacion.blog.autor.model.Autor;

@Repository
public class AutorRepository {

    private final Map<String, Autor> store = new ConcurrentHashMap<>();

    public Autor save(Autor autor) {
        store.put(autor.getId(), autor);
        return autor;
    }

    public Optional<Autor> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<Autor> findAll() {
        return new ArrayList<>(store.values());
    }
}
