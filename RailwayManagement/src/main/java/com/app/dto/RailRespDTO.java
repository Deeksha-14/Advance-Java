package com.app.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.app.entities.CategoryE;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RailRespDTO {
	
	
	@NotBlank(message = "Name cant be null")
	private String name;
	
	@NotNull(message = "category cant be null")
	private CategoryE category;
	
	@NotNull(message = "start time cannot be null")
	private LocalDateTime startTime;
	
	
	@NotNull(message = "End time cannot be null")
	private LocalDateTime endTime;
	
	@NotBlank(message = "Source cannot be null")
	private String source;
	
	@NotBlank(message = "destination cannot be null")
	private String destination;
	
	@NotNull(message = "Distance cannot be null")
	@Min(value = 1, message = "Distance must be greater than 0")
	private double distance;
	
	@NotNull(message = "Frequency cannot be null")
	@Min(value = 1, message = "frequency must be greater than 0")
	private int frequency;
	

}
