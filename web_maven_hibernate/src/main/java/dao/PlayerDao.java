package dao;

import pojos.Player;

public interface PlayerDao {

	String addPlayerToTeam(Player newPlayer, Long teamId);//Hint : get team, use helper method
	
}
