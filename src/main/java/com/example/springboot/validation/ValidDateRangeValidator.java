package com.example.springboot.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;


public class ValidDateRangeValidator implements ConstraintValidator<ValidDateRange, Object> {
    private String startDate;
    private String endDate;

    public void initialize(ValidDateRange constraint) {
        this.startDate = constraint.startDate();
        this.endDate = constraint.endDate();
    }

   @Override
   public boolean isValid(Object value, ConstraintValidatorContext context) {
       Object startDateValue = new BeanWrapperImpl(value)
               .getPropertyValue(startDate);
       Object endDateValue = new BeanWrapperImpl(value)
               .getPropertyValue(endDate);
       LocalDate startLocalDate = (LocalDate) startDateValue;
       LocalDate endLocalDate = (LocalDate) endDateValue;
       return endLocalDate.isAfter(startLocalDate);
   }
}
