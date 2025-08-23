package com.productapp.dto;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//DTO-Enitity-SRP
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto  {
	private Integer id;
	
	@NotEmpty(message = "name must not be empty")
	private String name;
	
	@Range(min = 10, max = 200000, message = "price must be in limit")
	private BigDecimal price;

	public ProductDto(@NotEmpty(message = "name must not be empty") String name,
			@Range(min = 10, max = 200000, message = "price must be in limit") BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	
}
