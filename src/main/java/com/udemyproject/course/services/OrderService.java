package com.udemyproject.course.services;

import com.udemyproject.course.entities.Order;
import com.udemyproject.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;


    public List<Order> findAll() {

        return repository.findAll();
    }


    public Order findById(Long id) {

        Optional<Order> obj = repository.findById(id);

        return obj.get();

    }

}
