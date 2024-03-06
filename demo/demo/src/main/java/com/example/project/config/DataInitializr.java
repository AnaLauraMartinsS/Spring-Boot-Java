package com.example.project.config;

import com.example.project.entity.Users;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        List<Users> users = userRepository.findAll();

        if (users.isEmpty()) {

            createUser("Ana Laura Martins Souto", "ana.bonita123@gmail.com");
            createUser("Hugo Samuel Friedrich", "huguinhoZN@gmail.com");
            createUser("Michael Cruz", "michaelC@gmail.com");
        }

        Users user = userRepository.findByName("Ana Laura Martins Souto");

        System.out.println(user.getName());
    }

    public void createUser(String name, String email) {

        Users user = new Users(name, email);
        userRepository.save(user);

    }
}
