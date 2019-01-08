package com.matmazur.springvalidationboot.myValidators.algorithms;

import com.matmazur.springvalidationboot.myValidators.EvenNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EvenNumberValidator implements ConstraintValidator<EvenNumber,Integer> {
    @Override
    public void initialize(EvenNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer%2==0;
    }
}
