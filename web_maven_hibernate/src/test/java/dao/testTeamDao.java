package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pojos.Team;
import utils.HibernateUtils;

class testTeamDao {
private static teamDao dao;//because dependent obj is creating obj of dependency
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//build sf n create dao instance
		HibernateUtils.getFactory();//triggers creation of sessionfactory
		dao= new teamDaoImpl();
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		HibernateUtils.getFactory().close();
	}

	@Test
	void test() {
		//fail("Not yet implemented");
		Team newTeam = new Team("Lucknow Super Giants22", "LSG22", "owner5", 37, 57, 27);
		//create team instance : hard coded details
		//invoke dao's method
		//assert : if id = 1
		String mesg = dao.addNewTeam(newTeam);
		System.out.println(mesg);
		assertTrue(mesg.contains("Added"));
		
		
	}
	
	
	@Test
	void testGetAllTeams()
	{
		List<Team> teams = dao.getAllTeam();
		teams.forEach(t -> System.out.println(t.getId()+" "+t.getAbbreviation()));
		assertEquals(4, teams.size());
	}

}
