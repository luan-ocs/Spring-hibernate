package com.udemyproject.course.config;

import com.udemyproject.course.entities.Category;
import com.udemyproject.course.entities.Order;
import com.udemyproject.course.entities.Product;
import com.udemyproject.course.entities.User;
import com.udemyproject.course.entities.enums.OrderStatus;
import com.udemyproject.course.repositories.CategoryRepository;
import com.udemyproject.course.repositories.OrderRepository;
import com.udemyproject.course.repositories.ProductRepository;
import com.udemyproject.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "9888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "9888888", "123456");

        Order o1 = new Order(null, Instant.parse("2023-06-20T19:53:07Z"), u1, OrderStatus.SHIPPED);
        Order o2 = new Order(null, Instant.parse("2023-01-13T15:21:22Z"), u2, OrderStatus.PAID);
        Order o3 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.DELIVERED);

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");


        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }
}
