package com.jaime.practices.practices1.profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jaime.practices.practices1.qualifiers.QualifiersMain;

@SpringBootApplication
public class MainProfiles {

    private static final Logger log = LoggerFactory.getLogger(QualifiersMain.class);
    
    public static void main(String[] args) {
        
        ConfigurableApplicationContext context = SpringApplication.run(MainProfiles.class, args);
        EnvironmentServices environmentServices = context.getBean(EnvironmentServices.class);
        log.info("Active environment {} ", environmentServices.getEnvironmentString());
    }
}
