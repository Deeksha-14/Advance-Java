package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import com.app.dto.ApiResponse;
import com.app.entities.Course;
import com.app.service.CourseService;


@RestController
@RequestMapping("/course")
@CrossOrigin("http://localhost:3000")
public class CoachingController {
	@Autowired
	private CourseService courseService; //interface instance
	
	
	public CoachingController() {
		System.out.println("in ctor of Coaching controller"+getClass());
	}
	// import org.springframework.web.bind.annotation.RequestBody;
	@PostMapping("/insert")
	public Course saveCourse(@RequestBody Course transientCourse)
	{
		System.out.println("in save course, provided values : "+transientCourse);
		return courseService.addCourseDetails(transientCourse);
	}
	
	@GetMapping("{cId}")
	public Course fetchCourse(@PathVariable Long cId)
	{
		System.out.println("in fetchCourse"+cId);
		return courseService.fetchCourseDetails(cId);
	}
	
	@GetMapping("/fetch")
	public List<Course> getAllCourses()
	{
		System.out.println("in get all courses");
		return courseService.fetchAllCourseDetails();
	}
	
	//delete
	@DeleteMapping("{cId}")
	public ApiResponse deleteCourse(@PathVariable Long cId)
	{
		System.out.println("in deletecourse");
		return new ApiResponse(courseService.deleteSpecific(cId));
	}
	
	
	//update
	@PutMapping
	public Course update(@RequestBody Course detachedCourse)
	{
		System.out.println("in update course : "+detachedCourse);
		return courseService.updateCourse(detachedCourse);
	}
	
	

}
