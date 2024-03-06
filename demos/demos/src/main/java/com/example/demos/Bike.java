package com.example.demos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bike")
public class Bike implements Vehicle{
    @Override
    public void start() {
        System.out.println("Bike andando");
    }

    @Override
    public void stop() {
        System.out.println("Bike parando");
    }
}
