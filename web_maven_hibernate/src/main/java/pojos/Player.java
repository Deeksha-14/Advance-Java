package pojos;
/*
 * 	id (PK), first_name,last_name, dob,batting_avg,wickets_taken....
	+team_id (FK)
 */

import java.time.LocalDate;
import javax.persistence.*;


@Entity
@Table(name="players")
public class Player extends BaseEntity {
	//atleast add one field : unique : for generation of later equality of hashcode: to make it business key
	
	//private int playerId;
	@Column(length = 20, unique=true)
	private String email;
	@Column(length = 20, name="first_name")
	private String firstName;
	@Column(length = 20, name="last_name")
	private String lastName;
	private LocalDate dob;
	@Column(name="batting_avg")
	private double battingAvg;
	@Column(name="wickets_taken")
	private int wicketsTaken;
	//FK 
	
	@ManyToOne
	@JoinColumn(name="team_id",nullable = false)
	private Team myTeam;
	public Player() {
		// TODO Auto-generated constructor stub
	}
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public double getBattingAvg() {
		return battingAvg;
	}
	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}
	public int getWicketsTaken() {
		return wicketsTaken;
	}
	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
	
	@Override
	public String toString() {
		return "Player [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken + "]";
	}
	public Team getMyTeam() {
		return myTeam;
	}
	public void setMyTeam(Team myTeam) {
		this.myTeam = myTeam;
	}
	
}
