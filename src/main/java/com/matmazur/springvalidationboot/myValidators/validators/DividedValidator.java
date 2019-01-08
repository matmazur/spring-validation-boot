package com.matmazur.springvalidationboot.myValidators.validators;

import com.matmazur.springvalidationboot.myValidators.constraints.Divided;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DividedValidator implements ConstraintValidator<Divided, Integer> {

    private int number;

    @Override
    public void initialize(Divided constraintAnnotation) {
        this.number = constraintAnnotation.by();
    }

    @Override
    public boolean isValid(Integer i, ConstraintValidatorContext constraintValidatorContext) {
        return i % number == 0;
    }
}
