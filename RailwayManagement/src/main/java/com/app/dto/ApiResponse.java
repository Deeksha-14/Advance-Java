package com.app.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
	
	
	private String message;
	private LocalDateTime timestamp;
	
	
	
	public ApiResponse(String message) {
		super();
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}
	
	
	

}
