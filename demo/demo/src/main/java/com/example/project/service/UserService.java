package com.example.project.service;

import com.example.project.entity.Users;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public List<Users> findAll() {
        return userRepository.findAll();
    }

}
