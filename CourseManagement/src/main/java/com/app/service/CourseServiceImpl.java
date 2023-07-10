package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Custom_Exception.ResourceNotFoundException;
import com.app.entities.Course;
import com.app.repository.CourseRepository;

@Transactional
@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepository cr;
	
	@Override
	public List<Course> fetchAll() {
		
		return cr.findAll();
	}

	@Override
	public Course fetchById(Long cId) {
		
		return cr.findById(cId).orElseThrow(()->new ResourceNotFoundException("invalid id : plese put correct id"));
	}

	@Override
	public Course modify(Course detachedDetail) {
		
		return cr.save(detachedDetail);
	}

	@Override
	public Course insert(Course transientDetail) {
		
		return cr.save(transientDetail);
	}

	@Override
	public String delete(Long cId) {
		String mesg = "invalid id, cant delete course details";
		if(cr.existsById(cId))
		{
			cr.deleteById(cId);
		}
		mesg="Course id "+cId+" deleted!";
		return mesg;
	}

	@Override
	public Course update(Course detachedCourse) {
		
		return cr.save(detachedCourse);
	}
	
	

}
