package com.example.project.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Getter
@Setter
public class Users {

    @Id
    private String id;
    private String name;
    private String email;

    private Set<Role> roles;

    public Users() {
    }

    public Users(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
