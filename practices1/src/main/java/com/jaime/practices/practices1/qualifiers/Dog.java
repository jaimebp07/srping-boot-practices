package com.jaime.practices.practices1.qualifiers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("doggy")
public class Dog extends Animal {

    public Dog(@Value("Telius") String name, @Value("3") String age) {
        super(name, age);
    }

}
