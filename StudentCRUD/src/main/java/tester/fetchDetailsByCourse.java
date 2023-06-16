package tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;

import static utils.HibernateUtils.getFactory;

public class fetchDetailsByCourse {
	
	public static void main(String[] args) {

	try(SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in))
	{
		StudentDaoImpl dao = new StudentDaoImpl();
		System.out.println("enter course type");
		
		dao.fetchDetails(Course.valueOf(sc.next().toUpperCase())).forEach(System.out::println);
		
		
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	}
	
}
