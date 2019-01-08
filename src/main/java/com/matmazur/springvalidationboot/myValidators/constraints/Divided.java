package com.matmazur.springvalidationboot.myValidators.constraints;

import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target(value = {FIELD, METHOD, CONSTRUCTOR, ANNOTATION_TYPE, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Divided {

     Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "Number should be dividable {by}";

    int by() default 1;
}
