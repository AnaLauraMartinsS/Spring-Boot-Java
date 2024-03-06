package com.example.demos;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    public String hello(){

        System.out.println("Entrou caramba");

        return "hello";
    }
}
