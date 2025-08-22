package com.productapp.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
	private String errorMessage;
	private int statusCode;
	private LocalDateTime timeStamp;
	private String toContact;
}
