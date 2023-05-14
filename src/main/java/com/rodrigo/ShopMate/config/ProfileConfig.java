package com.rodrigo.ShopMate.config;

import com.rodrigo.ShopMate.entities.Category;
import com.rodrigo.ShopMate.entities.Product;
import com.rodrigo.ShopMate.entities.User;
import com.rodrigo.ShopMate.entities.Order;

import com.rodrigo.ShopMate.enums.OrderStatus;
import com.rodrigo.ShopMate.repositories.CategoryRepository;
import com.rodrigo.ShopMate.repositories.ProductRepository;
import com.rodrigo.ShopMate.repositories.UserRepository;
import com.rodrigo.ShopMate.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@Profile("test")
public class ProfileConfig implements CommandLineRunner {
    @Autowired
    private UserRepository UserRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");



        Set<Category> lcat1 = new HashSet<>(Arrays.asList(cat2));
        Set<Category> lcat2 = new HashSet<>(Arrays.asList(cat1, cat3));
        Set<Category> lcat3 = new HashSet<>(Arrays.asList(cat3));
        Set<Category> lcat4 = new HashSet<>(Arrays.asList(cat3));
        Set<Category> lcat5 = new HashSet<>(Arrays.asList(cat2));

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "", lcat1);
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "", lcat2);
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "", lcat3);
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "", lcat4);
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "", lcat5);


        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));


        var u1 = new User(null, "rodrigo", "rodrigo@email.com", "1234", "21996041143", null);
        var u2 = new User(null, "camille", "camille@email.com", "1234", "21996041143", null);


        this.UserRepository.saveAll(Arrays.asList(u1, u2));

        var o1 = new Order(null, Instant.parse("2023-05-12T19:30:00Z"), OrderStatus.PAID, u1);
        var o2 = new Order(null, Instant.parse("2023-05-11T19:30:00Z"), OrderStatus.DELIVERED, u2);


        this.orderRepository.saveAll(Arrays.asList(o1, o2));

    }
}
