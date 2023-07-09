package com.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = "railway")
public class Railway extends BaseEntity {
	
	@Column(nullable = false )
	private String name;
	
	@Column(nullable = false)
	private CategoryE category;
	
	@Column(name = "start_time",nullable = false)
	private LocalDateTime startTime;
	
	@Column(name = "end_time", nullable = false)
	private LocalDateTime endTime;
	
	@Column(nullable = false)
	private String source;
	
	@Column(nullable = false)
	private String destination;
	
	@Column(nullable = false)
	private double distance;
	
	@Column(nullable = false)
	private int frequency;
	

}
