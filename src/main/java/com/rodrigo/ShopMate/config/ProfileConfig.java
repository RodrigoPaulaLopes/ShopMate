package com.rodrigo.ShopMate.config;

import com.rodrigo.ShopMate.entities.User;
import com.rodrigo.ShopMate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;

@Configuration
@Profile("test")
public class ProfileConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {


        var user = new ArrayList<User>();
        user.add(new User(null, "Rodrigo", "rodrigo.lopes@email.com.br", "12345", "21996041143"));
        user.add(new User(null, "Camille", "camille.lopes@email.com.br", "12345", "21996041143"));
        user.add(new User(null, "amanda", "amanda.santos@email.com.br", "12345", "21996041143"));


        this.userRepository.saveAll(user);
    }
}
