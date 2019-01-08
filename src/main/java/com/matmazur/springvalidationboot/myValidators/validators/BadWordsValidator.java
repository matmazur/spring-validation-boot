package com.matmazur.springvalidationboot.myValidators.validators;


import com.matmazur.springvalidationboot.common.Lang;
import com.matmazur.springvalidationboot.myValidators.constraints.NotBadWord;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
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

        for (Lang l : languages) {
            if (l == Lang.PL)
                status &= polishFilter(s);
            if (l == Lang.ENG)
                status = status && englishFilter(s);
        }
        return status;
    }

    private boolean polishFilter(String text) {

        List<String> curseWords = Arrays.asList("kurwa", "dupa", "chuj", "huj", "pierdol");
        return coreFilter(curseWords, text);
    }

    private boolean englishFilter(String text) {

        List<String> curseWords = Arrays.asList("fuck", "twat", "cunt", "ass");
        return coreFilter(curseWords, text);
    }

    private boolean coreFilter(List<String> languageList, String text) {

        for (String s : languageList) {
            if (text.toLowerCase().contains(s.toLowerCase()))
                return false;
        }
        return true;
    }
}
