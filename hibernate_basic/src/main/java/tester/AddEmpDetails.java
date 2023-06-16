package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;
import pojos.Employee;
import pojos.EmploymentType;

public class AddEmpDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc=new Scanner(System.in)) // static method ---> cls loading ---> static init block --> singleton
												// instance of SF
		{
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			//String firstName, String lastName, String email, String password, String confirmPassword,
			//LocalDate joinDate, EmploymentType type, double salary
			System.out.println("Hibernate is up n running !!!"+sf);//sf imple cls instance
			System.out.println("Add details firstName, lastName, email, password, confirmPassword,  joinDate, type,  salary : ");
			Employee newEmp = new Employee(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), LocalDate.parse(sc.next()), EmploymentType.valueOf(sc.next().toUpperCase()), sc.nextDouble());
			
			System.out.println(dao.insertEmployeeDetails(newEmp));
			
			
		}  //sf.close() --> clean up DB connection pool!
		
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
