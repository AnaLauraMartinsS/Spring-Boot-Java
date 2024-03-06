package com.example.demos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("car")
public class Car implements Vehicle {


    @Override
    public void start() {
        System.out.println("Iniciando carro");
    }

    @Override
    public void stop() {
        System.out.println("Parando carro");
    }
}
