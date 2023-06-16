package dao;

import pojos.Employee;
import static utils.HibernateUtils.getFactory;
import org.hibernate.*;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String insertEmployeeDetails(Employee emp) {
		String mesg = "adding emp details fails";
		//get session from session factory 
		//session represent pooled connection--here
		//takes out a connection from DBCP , wraps it and rets it in session obj and returns it to the caller
		Session session = getFactory().openSession();
		//begin a transaction
		Transaction tx = session.beginTransaction();
		try {
			session.save(emp);
			
			
			
			tx.commit();
			mesg="success with ID ="+emp.getempId();
		}catch(RuntimeException e)
		{
			//rollback tx
			if(tx != null)
				tx.rollback();
			//rethrow the same exc to the caller to inform the caller
			throw e;
			
		}finally {
			
			//session closing
			if(session != null)
				session.close();  //pooled out db cn simply rets to the pool!
			
		}
		return mesg;
	}

}
