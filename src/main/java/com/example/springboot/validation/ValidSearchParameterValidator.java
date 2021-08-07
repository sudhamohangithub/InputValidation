package com.example.springboot.validation;

import io.micrometer.core.instrument.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ValidSearchParameterValidator implements ConstraintValidator<ValidSearchParameter, Object[]> {
    public void initialize(ValidSearchParameter constraint) {
    }

   @Override
   public boolean isValid(Object[] arguments, ConstraintValidatorContext context) {
       List<Object> stringStream = Arrays.stream(arguments).filter(this::isValidArgument).collect(toList());
       return stringStream.size() == 1;
   }

    private boolean isValidArgument(Object x) {
        return x instanceof String && StringUtils.isNotBlank((String) x);
    }
}
