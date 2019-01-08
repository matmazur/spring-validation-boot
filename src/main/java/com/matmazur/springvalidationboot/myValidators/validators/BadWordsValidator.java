package com.matmazur.springvalidationboot.myValidators.validators;


import com.matmazur.springvalidationboot.common.Lang;
import com.matmazur.springvalidationboot.myValidators.constraints.NotBadWord;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BadWordsValidator implements ConstraintValidator<NotBadWord, String> {

    private Lang[] languages;

    @Override
    public void initialize(NotBadWord constraintAnnotation) {
        this.languages = constraintAnnotation.lang();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        boolean status = true;

        for (Lang l:languages){
            if (l==Lang.PL){
                status=polishFilter(s);
            }else if (l==Lang.ENG){
                status=englishFilter(s);
            }
        }
        return status;
    }

    private boolean polishFilter(String message) {

        List<String> curseWords = Arrays.asList("kurwa", "dupa", "chuj", "huj");

        return coreFilter(curseWords, message);
    }

    private boolean englishFilter(String message) {

        List<String> curseWords = Arrays.asList("fuck", "twat", "cunt", "ass");

        return coreFilter(curseWords, message);
    }


    private boolean coreFilter(List<String> languageList, String message) {

        List<String> messageToWords = Arrays.asList(message.split(" "));

        return !Collections.disjoint(languageList, messageToWords);
    }
}
