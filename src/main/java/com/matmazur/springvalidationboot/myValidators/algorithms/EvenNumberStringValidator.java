package com.matmazur.springvalidationboot.myValidators.algorithms;

import com.matmazur.springvalidationboot.myValidators.EvenNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EvenNumberStringValidator implements ConstraintValidator<EvenNumber, String> {
    @Override
    public void initialize(EvenNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        return Integer.valueOf(string) % 2 == 0;
    }
}
