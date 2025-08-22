package com.productapp.dao;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Product  {
	
	private Integer id;
	@NotEmpty(message = "name must not be empty")
	private String name;
	
	@Range(min = 10, max = 200000, message = "price must be in limit")
	private BigDecimal price;
	
}
