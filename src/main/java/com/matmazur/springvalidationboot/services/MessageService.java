package com.matmazur.springvalidationboot.services;

import com.matmazur.springvalidationboot.model.Message;
import com.matmazur.springvalidationboot.myValidators.groups.Complete;
import com.matmazur.springvalidationboot.myValidators.groups.Draft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class MessageService {

    private final Validator validator;

    @Autowired
    public MessageService(Validator validator) {
        this.validator = validator;
    }

    public void verifyAndPrintMessage(Message message) {

        Set<ConstraintViolation<Message>> errors = validator.validate(message, Complete.class);
        if (errors.isEmpty()) {
            System.out.println(message.getMessage());
        } else {
            System.err.printf("%d errors found!\n", errors.size());
            for (ConstraintViolation err : errors) {
                System.err.println(err.getMessage());
            }
        }
    }
}
