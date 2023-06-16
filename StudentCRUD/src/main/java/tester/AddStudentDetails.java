package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

public class AddStudentDetails {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in))
		{
			StudentDaoImpl dao = new StudentDaoImpl();
			
			System.out.println("Enter Student details : firstName, lastName, email, password,"
					+ "enrolledCourse, dob");
			
			Student newstud = new Student(sc.next(), sc.next(), sc.next(), sc.next(), Course.valueOf(sc.next().toUpperCase()), LocalDate.parse(sc.next()));
			System.out.println(dao.insertStudent(newstud));
			
			//JAVA_EE 2000-02-01
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
