package com.rodrigo.ShopMate.config;

import com.rodrigo.ShopMate.entities.Order;
import com.rodrigo.ShopMate.entities.User;
import com.rodrigo.ShopMate.repositories.OrderRepository;
import com.rodrigo.ShopMate.repositories.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Profile("test")
public class ProfileConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {



        var u1 = new User(null, "rodrigo", "rodrigo@email.com", "1234", "21996041143", null);
        var u2 = new User(null, "camille", "camille@email.com", "1234", "21996041143", null);


        this.userRepository.saveAll(Arrays.asList(u1, u2));

        var o1 = new Order(null, Instant.parse("2023-05-12T19:30:00Z"), u1);
        var o2 = new Order(null, Instant.parse("2023-05-11T19:30:00Z"), u2);


        this.orderRepository.saveAll(Arrays.asList(o1, o2));

    }
}
