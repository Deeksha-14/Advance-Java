package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Team;

public class teamDaoImpl implements teamDao{

	
	@Override
	public List<Team> getAllTeam() {
		
		
		Session session = getFactory().getCurrentSession();
		List<Team> teams = null;
		String jpql = " select new pojos.Team(id, abbreviation) from Team";
		Transaction txn = session.beginTransaction();
		
		
		try {
			teams = session.createQuery(jpql, Team.class).getResultList();
			
			
			
			txn.commit();
		}catch(Exception e) {
			
			
			
			if(txn != null)
				txn.rollback();
			throw e;
		
		
		}
		return teams;
	}

	@Override
	public String addNewTeam(Team newTeam) {
		String mesg = "addine new team failed";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction txn = session.beginTransaction();
		
		try {
			session.persist(newTeam);
			txn.commit();
			mesg="Added new team with the id "+newTeam.getId();
		}catch(Exception e)
		{
			if(txn != null)
				txn.rollback();
			throw e;
		}
		
		return mesg;
	}

	@Override
	public Team getTeamDetails(long teamId) {
		// TODO Auto-generated method stub
		return null;
	}

}
