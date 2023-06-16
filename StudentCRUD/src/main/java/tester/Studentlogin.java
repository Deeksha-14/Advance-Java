package tester;

import java.util.Scanner;
import static java.time.LocalDate.*;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import static utils.HibernateUtils.getFactory;

public class Studentlogin {

	public static void main(String[] args) {
		
		
		
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) // invoking static method -->
		// cls loading --> static init block --> configure : entire hib frmwork loaded
		{
			// create dao instance
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("Enter email , password");
			System.out.println(dao.login(sc.next(), sc.next()));
			
			
//			dao.getEmpsByDateAndSalary(parse(sc.next()), parse(sc.next()), sc.nextDouble())
//					.forEach(System.out::println);

		} // sf.close() --> cleaning up DBCP (db conn pool)
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}


//package tester;
//
//import org.hibernate.SessionFactory;
//
//import dao.EmployeeDaoImpl;
//import pojos.Employee;
//import pojos.EmploymentType;
//
//import static utils.HibernateUtils.getFactory;
//
//import java.time.LocalDate;
//import java.util.Scanner;
//import static java.time.LocalDate.parse;
//
//public class GetSelectedEmpDetails {
//
//	public static void main(String[] args) {
//		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) // invoking static method -->
//		// cls loading --> static init block --> configure : entire hib frmwork loaded
//		{
//			// create dao instance
//			EmployeeDaoImpl dao = new EmployeeDaoImpl();
//			System.out.println("Enter begin date , end date n min sal");
//			System.out.println("List of selected emps : ");
//			dao.getEmpsByDateAndSalary(parse(sc.next()), parse(sc.next()), sc.nextDouble())
//					.forEach(System.out::println);
//
//		} // sf.close() --> cleaning up DBCP (db conn pool)
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//}
