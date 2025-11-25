package com.bisa.evaluacion.blog.blog.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bisa.evaluacion.blog.blog.model.BlogSnapshot;

@Repository
public class HistorialBlogRepository {

    private List<BlogSnapshot> store = new ArrayList<>();

    public void add(BlogSnapshot blog) {
        store.add(blog);
    }

    public List<BlogSnapshot> findAll() {
        return new ArrayList<>(store);
    }
}
