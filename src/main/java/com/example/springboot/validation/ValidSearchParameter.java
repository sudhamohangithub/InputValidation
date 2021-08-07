package com.example.springboot.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = ValidSearchParameterValidator.class)
@Target({ METHOD, CONSTRUCTOR })
@Retention(RUNTIME)
@Documented
public @interface ValidSearchParameter {
    String message() default
            "you must provide one and only one of the postalCode/city/ownerName parameter with valid non blank value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
