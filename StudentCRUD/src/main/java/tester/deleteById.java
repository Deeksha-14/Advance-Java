package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;
import dao.StudentDaoImpl;

import org.hibernate.SessionFactory;

public class deleteById {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory();
				Scanner sc =new Scanner(System.in))
		{
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("Enter id  to be deleted : ");
			System.out.println(dao.deleteById(sc.nextInt()));
			
		}catch(RuntimeException e)
		{
			e.printStackTrace();
		}

	}

}
