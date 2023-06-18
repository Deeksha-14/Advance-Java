package dao;

import java.util.List;

import pojos.Course;
import pojos.Student;

public interface StudentDao {
	//student registration
	String insertStudent(Student stud);
	
	//student login
	String login(String email, String password);
	
	//get all students from a specific course
	List<Student> fetchDetails(Course course);
	
	//Change course; ip : studid, courseName
	String changeCourse(int studentId, Course enrolledCourse);
	
	//change course; ip firstname, courseName
	String changeCourseByName(String firstName, Course enrolledCourse);
	
	//delete by id using API
	String deleteById(int studentId);
	
	
	

}
