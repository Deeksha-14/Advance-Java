package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Player;
import pojos.Team;

public class PlayerDaoImpl implements PlayerDao {
//	String addPlayerToTeam(Player newPlayer, Long teamId);//Hint : get team, use helper method

	@Override
	public String addPlayerToTeam(Player newPlayer, Long teamId) {
		Session session  = getFactory().getCurrentSession();
		
		
		
		Transaction txn = session.beginTransaction();
		try {
		//	Team team = Session.get(Team.class, teamId);
			
			txn.commit();
		}catch(Exception e) {
			if(txn != null)
				txn.rollback();
			throw e;
		}
		
		
		return null;
	}

}
