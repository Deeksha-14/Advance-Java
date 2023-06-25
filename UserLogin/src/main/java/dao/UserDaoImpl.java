package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static utils.DBUtils.closeConnection;
import static utils.DBUtils.openConnection;

import pojos.Role;
import pojos.User;

public class UserDaoImpl implements UserDao {
	
	private Connection cn;
	private PreparedStatement pst1;
	
	
	public UserDaoImpl() throws SQLException {
		cn= openConnection();
		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		System.out.println("userdao created");
	}
	

	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		pst1.setString(1, email);
		pst1.setString(2, password);
		User abc =null;
		
		//int id 1,String firstName2, String lastName,3 String email4, String password5, Date dob6, boolean status, Role role
		
		try(ResultSet rst = pst1.executeQuery())
		{//email password we already have so no need to pick it up from db
			if(rst.next())
			{ abc = new User(rst.getInt(1), rst.getString(2), rst.getString(3), email, password, rst.getDate(6), rst.getBoolean(7), Role.valueOf(rst.getString(8)));
				System.out.println(abc);
	
			}
			
			return abc;
			
		}
		
		
	}
	
	
	
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		closeConnection();
	}

}
