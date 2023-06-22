package beans;
import java.util.List;
import org.hibernate.HibernateException;
import dao.teamDaoImpl;
import pojos.Team;

public class IPLBean {
//state : dep : dao
	private teamDaoImpl teamDao;
	
	
	public IPLBean() {
		//dao instace
		teamDao=new teamDaoImpl();
		System.out.println("IPL bean created...");
		
	}
	//getters n setters
	public teamDaoImpl getTeamDao() {
		return teamDao;
	}
	public void setTeamDao(teamDaoImpl teamDao) {
		this.teamDao = teamDao;
	}
	//add B.L method to ret list of all teams to the caller(JSP)
	public List<Team> fetchAllTeams() 
	{
		//invoke dao's method
		return teamDao.getAllTeam();
	}
	
	
}
