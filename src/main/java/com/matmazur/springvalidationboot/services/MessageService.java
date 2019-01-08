package com.matmazur.springvalidationboot.services;

import com.matmazur.springvalidationboot.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

@Service
public class MessageService {

    private final Validator validator;

    @Autowired
    public MessageService(Validator validator) {
        this.validator = validator;
    }

    public void printWords(Message message) {

        Errors errors = new BeanPropertyBindingResult("message", "message");
        validator.validate(message, errors);

        if (!errors.hasErrors()) {
            System.out.println(message.getMessage());
        } else {
            System.err.printf("%d errors found!\n", errors.getAllErrors().size());
            for (ObjectError err : errors.getAllErrors()) {
                System.err.println(message.getName() + " -- " + err.getDefaultMessage());
            }
        }
    }
}
