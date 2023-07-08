package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.entities.Course;
import com.app.service.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/course")
public class CoachingController {
	@Autowired
	private CourseService cs;
	
	public CoachingController() {
		System.out.println("in ctor of coaching controller"+getClass());
	}
	
	@GetMapping
	public List<Course> fetchAll()
	{
		return cs.fetchAll();
	}
	
	@PostMapping
	public Course add(@RequestBody Course transientDetail)
	{
		return cs.insert(transientDetail);
	}
	
	@DeleteMapping("{cId}")
	public ApiResponse deleteCourseDetail(@PathVariable Long cId)
	{
		System.out.println("in api response"+cId);
		return new ApiResponse(cs.delete(cId));
	}
	
	
	@PutMapping("{cId}")
	public ResponseEntity<?> updateCourse(@RequestBody Course detachedCourse)
	{
		System.out.println("in update Course"+detachedCourse);
		return new ResponseEntity<>(cs.update(detachedCourse), HttpStatus.OK);
	}
	
	
	
	
	
}
