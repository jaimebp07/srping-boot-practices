package com.jaime.practices.practices1.qualifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bird extends Animal implements Flying {

    private static final Logger log = LoggerFactory.getLogger(Bird.class);
    
    public Bird(@Value("Pajaro Loco") String name, @Value("2") String age) {
        super(name, age);
    }

    @Override
    public void fly() {
        log.info("I'm a bird and I'm flying");
        throw new UnsupportedOperationException("Unimplemented method 'fly'");
    }
}
