package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.app.entities.Course;

public interface CourseService {
	
	//get
	List<Course> fetchAll();
	
	//get by id
	Course fetchById(Long cId);
	
	//put
	Course modify(Course detachedDetail);
	
	//post
	Course insert(Course transientDetail);
	
	//delete
	String delete(Long cId);

	//put
	Course update(Course detachedCourse);

}
