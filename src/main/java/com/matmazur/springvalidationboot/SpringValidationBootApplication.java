package com.matmazur.springvalidationboot;

import com.matmazur.springvalidationboot.model.Message;
import com.matmazur.springvalidationboot.model.TestNumber;
import com.matmazur.springvalidationboot.services.MessageService;
import com.matmazur.springvalidationboot.services.TestNumberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@SpringBootApplication
public class SpringValidationBootApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringValidationBootApplication.class, args);
        Locale.setDefault(new Locale("en", "EN"));
        MessageService service = context.getBean(MessageService.class);

        //My intention here is testing validation of explicit words in strings of words
        //All materials that can be seen here are being used for purposes clearly scientific
        //I do however agree with ending potato hegemony for good
        //Ireland please know that I respect you and it has nothing to do with your 'tayto affections

        Message goodMsg = new Message("", "to hell with potato hegemony");
        Message badMsg = new Message("badMsg", "fuck potato hegemony");
        Message worstMsg = new Message("worstMsg", "Lechia lechiiijka pany KuRWAaaaa oeoee");

        service.verifyAndPrintMessage(goodMsg);
        service.verifyAndPrintMessage(badMsg);
        service.verifyAndPrintMessage(worstMsg);

//        TestNumberService testNumberService = context.getBean(TestNumberService.class);
//        testNumberService.validateAndPrintNumber(new TestNumber(5));
//        testNumberService.validateAndPrintNumber(new TestNumber(1));
//        testNumberService.validateAndPrintNumber(new TestNumber(2));
//        testNumberService.validateAndPrintNumber(new TestNumber(10));


        context.close();
    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}

