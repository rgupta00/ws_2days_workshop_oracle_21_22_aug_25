package com.productapp.dao;

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

//DTO--SRP
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Product  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "name must not be empty")
	private String name;
	
	@Range(min = 10, max = 200000, message = "price must be in limit")
	private BigDecimal price;

	public Product(@NotEmpty(message = "name must not be empty") String name,
			@Range(min = 10, max = 200000, message = "price must be in limit") BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	
}
