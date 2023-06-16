package dao;

import static utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Course;
import pojos.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String insertStudent(Student stud) {
		
		String mesg="Adding student failed";
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
		Serializable id =  session.save(stud);
			
			
			
			
			tx.commit();
			mesg = "Student registred successfully with id "+id;
		}catch(RuntimeException e)
		{
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		
		
		
		
		return mesg;
	}

	@Override
	public String login(String email, String password) {
		
		Session session = getFactory().getCurrentSession();
		String mesg="Login Unsuccessful";
		String jpql="select s from Student s where s.email=:em and s.password=:pw";
		Student studlist = null;
		Transaction txn = session.beginTransaction();
		try{
			
			studlist = session.createQuery(jpql, Student.class).setParameter("em", email).setParameter("pw", password).getSingleResult();
			// jpql - select s from students s where s.email=:em and s.password=:pw
			txn.commit();
			mesg="login successful";
		}catch(RuntimeException e)
		{
			
			if(txn != null)
			{
				txn.rollback();
				throw e;
			}
		}
		
		return mesg;
	}

	@Override
	public List<Student> fetchDetails(Course course) {
		Session session = getFactory().getCurrentSession();
		String jpql = "select s from Student s where s.enrolledCourse = :cor";
		List<Student> studentList = null;
		
		Transaction txn = session.beginTransaction();
		try {
			
			studentList = session.createQuery(jpql, Student.class).setParameter("cor", course).getResultList();
			
			
			
			txn.commit();
		}catch(RuntimeException e)
		{
			if(txn!=null)
				txn.rollback();
			throw e;
		}
		
		
		
		
		return studentList;
	}

	@Override
	public String changeCourse(int studentId, Course enrolledCourse) {
		Student st = null;
		Session session = getFactory().getCurrentSession();
		String mesg = "not changed";
		
		Transaction txn = session.beginTransaction();
		try {
		st =	session.get(Student.class, studentId);
		st.setEnrolledCourse(enrolledCourse);
		mesg="course updated"+st;
			txn.commit();
			
		}catch(RuntimeException e)
		{
			if(txn != null)
				txn.rollback();
			throw e;
			
		}
		
		
		
		return mesg;
	}
	
	
	

}
