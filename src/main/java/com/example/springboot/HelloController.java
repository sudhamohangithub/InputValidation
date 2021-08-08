package com.example.springboot;

import com.example.springboot.validation.ValidSearchParameter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.temporal.ChronoUnit;

@RestController
@Validated
public class HelloController {

	/**
	 * User can search by only any one criteria. by postalCode/city/ownerName
	 * @return
	 */
	@ValidSearchParameter
	@GetMapping("/search")
	public String searchBy(@RequestParam(value = "postal_code", required = false) String postalCode,
						   @RequestParam(value = "city", required = false) String city,
						   @RequestParam(value = "ownerName", required = false) String ownerName
						   ) {
		return "Greetings from Spring Boot!";
	}

	@PostMapping("/age")
	public Long saveDate(@RequestBody @Valid MyDTO myDTO){
		return myDTO.getStartDate().until(myDTO.getEndDate(), ChronoUnit.DAYS);
	}
}
