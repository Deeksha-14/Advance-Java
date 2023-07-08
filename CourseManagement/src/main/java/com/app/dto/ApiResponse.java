package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class ApiResponse {
	
	private String messege;
	private LocalDateTime timestamp;
	public ApiResponse(String messege) {
		super();
		this.messege = messege;
		this.timestamp = LocalDateTime.now();
	}
	
	

}
