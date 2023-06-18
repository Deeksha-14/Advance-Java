package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;

public class BulkUpdate {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in))
		{
			
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("enter firstname, course : ");
			System.out.println(dao.changeCourseByName(sc.next(), Course.valueOf(sc.next().toUpperCase())));
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
