package com.example.springboot;

import com.example.springboot.validation.ValidDateRange;
import lombok.Data;

import java.time.LocalDate;

@Data
@ValidDateRange(startDate = "startDate", endDate = "endDate")
public class MyDTO {
    LocalDate startDate;
    LocalDate endDate;
}
