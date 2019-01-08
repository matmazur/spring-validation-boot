package com.matmazur.springvalidationboot.myValidators;

import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Documented
//@Constraint(validatedBy = dummy for now  )
@Target({FIELD, ANNOTATION_TYPE, METHOD, CONSTRUCTOR, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface EvenNumber {
    String message() default "Number should be EVEN";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
