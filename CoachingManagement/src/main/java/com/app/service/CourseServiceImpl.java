package com.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.entities.Course;
import com.app.repository.CourseRepository;

@Transactional
@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public Course addCourseDetails(Course transientDetails) {

		return courseRepo.save(transientDetails);
	}

	@Override
	public Course fetchCourseDetails(Long cid) {
		
		return courseRepo.findById(cid).orElseThrow(()->new ResourceNotFoundException("invalid id"));
	}

	@Override
	public List<Course> fetchAllCourseDetails() {
		
		return courseRepo.findAll();
	}

	@Override
	public String deleteSpecific(Long cId) {
		String mesg = "course id invalid can't delete course details";
		if(courseRepo.existsById(cId))
		{courseRepo.deleteById(cId);
		mesg = "course details deleted successfully!!";
		}
		return mesg;
	}

	@Override
	public Course updateCourse(Course detachedDetails) {
		
		return courseRepo.save(detachedDetails);
	}
	
	

}
