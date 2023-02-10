package com.udemyproject.course.resources;

import com.udemyproject.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResourse {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1l, "Luan", "maria@gmail.com", "999999", "123456");


        return ResponseEntity.ok().body(u);
    }
}
