package com.udemyproject.course.resources;

import com.udemyproject.course.entities.Category;
import com.udemyproject.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @RequestMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = service.findAll();

        return ResponseEntity.ok().body(categories);
    }


    @RequestMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category cat = service.findById(id);

        return ResponseEntity.ok().body(cat);
    }

}
