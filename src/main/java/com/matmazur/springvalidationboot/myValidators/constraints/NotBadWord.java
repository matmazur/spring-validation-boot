package com.matmazur.springvalidationboot.myValidators.constraints;

import com.matmazur.springvalidationboot.common.Lang;
import com.matmazur.springvalidationboot.myValidators.validators.BadWordsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, METHOD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {BadWordsValidator.class})
public @interface NotBadWord {

    String message() default "explicit words are not allowed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Lang[] lang() default Lang.PL;
}
