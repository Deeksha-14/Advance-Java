package com.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "course")
@Entity
public class Course extends BaseEntity{
	@Column(length = 30)
	private String name;
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private Category category;
	@Column(name = "Start_Date", length = 30)
	private LocalDate startDate;
	@Column(name = "End_Date", length = 30)
	private LocalDate endDate;
	@Column(length = 30)
	private double fees;
//	@Column(name = "Time_Stamp", length = 30)
//	private LocalDateTime updateDateTime;
//	public Course(LocalDateTime updateDateTime) {
//		super();
//		this.updateDateTime = LocalDateTime.now();
//	}
	
	
	
	
	

}
