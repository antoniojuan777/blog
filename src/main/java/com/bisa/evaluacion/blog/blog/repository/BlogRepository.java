package com.bisa.evaluacion.blog.blog.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.bisa.evaluacion.blog.blog.model.Blog;

@Repository
public class BlogRepository {

    private final Map<String, Blog> store = new ConcurrentHashMap<>();

    public Blog save(Blog blog) {
        store.put(blog.getId(), blog);
        return blog;
    }

    public Optional<Blog> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<Blog> findAll() {
        return new ArrayList<>(store.values());
    }
}
