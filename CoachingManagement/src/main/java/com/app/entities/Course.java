package com.app.entities;

import java.time.LocalDate;

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

@Entity
@Table(name = "course")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Course extends BaseEntity{
	@Column(nullable = false, length = 30)
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private Category category;
	
	@Column(nullable = false, length = 30)
	private LocalDate startDate;
	
	@Column(nullable = false, length=30)
	private LocalDate endDate;
	
	@Column(nullable = false, length=40)
	private double fee;
	
	
}
