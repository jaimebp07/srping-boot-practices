package com.jaime.practices.practices1.qualifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class QualifiersMain {

    private static final Logger log = LoggerFactory.getLogger(QualifiersMain.class);

    public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(QualifiersMain.class, args);
		
        /* FIRST EXAMPLE */
        //Dog dog = context.getBean(Dog.class);
        //log.info("Dog name: {}, Edad: {}", dog.getName(), dog.getAge()  );
        
        /* SECOND EXAMPLE */
		//Bird bird = context.getBean(Bird.class);
		//log.info("Bird name: {}, Edad: {}", bird.getName(), bird.getAge()  );
        
        /* THIRD EXAMPLE */
		//Plane plane = context.getBean(Plane.class);
        //plane.fly();

        /* FOURTH EXAMPLE */
        //Animal animal = context.getBean(Animal.class);
        //log.info("Animal name: {}, Edad: {}", animal.getName(), animal.getAge()); /*This will generate an error since it will find 2 beans implementing the Animal class and it won't know wich to use */

        /* FIFTIN EXAMPLE */
        //Animal animal = context.getBean("bird", Animal.class);
        //log.info("Animal name: {}, Edad: {}", animal.getName(), animal.getAge());

        /* SIXTH EXAMPLE */
        //Animal animal = context.getBean("doggy", Animal.class);
        //log.info("Animal name: {}, Edad: {}", animal.getName(), animal.getAge());

        /* SEVENTH EXAMPLE */

	}
}
