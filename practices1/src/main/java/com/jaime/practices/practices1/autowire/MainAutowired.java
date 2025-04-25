package com.jaime.practices.practices1.autowire;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainAutowired {

    private static final Logger log = LoggerFactory.getLogger(MainAutowired.class);

    public static void main(String[] args) {
        
        ConfigurableApplicationContext context = SpringApplication.run(MainAutowired.class, args);
        CalculateAreaService calculateAreaService = context.getBean(CalculateAreaService.class);
        log.info("Total area: {} ", calculateAreaService.calculateAreas());
    }
}
