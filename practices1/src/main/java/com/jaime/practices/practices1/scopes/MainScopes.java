package com.jaime.practices.practices1.scopes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainScopes {
private static final Logger log = LoggerFactory.getLogger(MainScopes.class);
    
    public static void main(String[] args) {
        
        ConfigurableApplicationContext context = SpringApplication.run(MainScopes.class, args);
        ExampleScopesService exampleScopesService = context.getBean(ExampleScopesService.class);
        ExampleScopesService exampleScopesService1 = context.getBean(ExampleScopesService.class);
        log.info("Are beans equals {} ", exampleScopesService.equals(exampleScopesService1));
        log.info("Are beans == {} ", exampleScopesService == exampleScopesService1);
    }
}
