package com.example.project.repository;


import com.example.project.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, Long> {

    Users findByName(String name);
}
