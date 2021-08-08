package com.example.springboot.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = ValidDateRangeValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
public @interface ValidDateRange {
    String message() default
            "StartDate must be less then endDate";
    String startDate();

    String endDate();
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
