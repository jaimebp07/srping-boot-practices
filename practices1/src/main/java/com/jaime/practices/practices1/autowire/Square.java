package com.jaime.practices.practices1.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Square implements Figure {

    @Value("3")
    private int side;

    @Override
    public double calculateArea() {
        return side * side;
    }
}
