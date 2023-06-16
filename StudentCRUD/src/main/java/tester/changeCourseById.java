package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;

public class changeCourseById {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory(); 
				Scanner sc = new Scanner(System.in) )
		{
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("enter student id and course");
			System.out.println(dao.changeCourse(sc.nextInt(), Course.valueOf(sc.next())));
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
