package com.app.service;

import java.util.List;


import com.app.entities.Course;

public interface CourseService {
	
	//insert - post
	Course addCourseDetails(Course transientDetails);
	
	//retrieve specific - get
	Course fetchCourseDetails(Long cId);
	
	//retrieve all - get
	List<Course> fetchAllCourseDetails();
	
	//deleteSpecific - delete
	String deleteSpecific(Long cId);
	
	//update - put
	Course updateCourse(Course detachedDetails);
	

	
	
}
