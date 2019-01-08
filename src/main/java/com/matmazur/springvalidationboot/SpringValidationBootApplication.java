package com.matmazur.springvalidationboot;

import com.matmazur.springvalidationboot.model.Person;
import com.matmazur.springvalidationboot.services.PersonValidationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class SpringValidationBootApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringValidationBootApplication.class, args);
        PersonValidationService service = context.getBean(PersonValidationService.class);
        Person person1 = new Person("Rick", "Jimeneez", 5, "654465", "");
        Person person2 = new Person("Mike", "Right", 543, "12345678", "mike@gmail.pl");
        Person person3 = new Person("Buck", "semiright", 1235, "65664465", "buck@gmail");

        service.addPerson(person1);
        service.addPerson(person2);
        service.addPerson(person3);
        System.out.println(service.getPeople());
    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}

