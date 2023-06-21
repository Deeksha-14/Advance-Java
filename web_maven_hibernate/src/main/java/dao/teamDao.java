package dao;

import java.util.List;

import pojos.Team;

public interface teamDao {

	//add a method to lift team team id and abbr from all the teams
	List<Team> getAllTeam(); //hInt :ctor expression
	
	//add new team
	String addNewTeam(Team newTeam);
	
	Team getTeamDetails(long teamId);
	
	
}
