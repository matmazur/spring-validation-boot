package com.matmazur.springvalidationboot.services;

import com.matmazur.springvalidationboot.model.TestNumber;
import com.matmazur.springvalidationboot.myValidators.groups.Draft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class TestNumberService {

    private final
    Validator validator;

    @Autowired
    public TestNumberService(Validator validator) {
        this.validator = validator;
    }

    public void validateAndPrintNumber(TestNumber testNumber) {
        Set<ConstraintViolation<TestNumber>> errors = validator.validate(testNumber);

        if (errors.isEmpty()) {
            System.out.println(testNumber.getNumber());
        } else {
            for (ConstraintViolation err : errors) {

                System.err.println(err.getMessage());
            }
        }
    }
}
