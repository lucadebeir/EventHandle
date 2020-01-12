package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.implement.UserDAO;
import model.Event;
import model.User;

/**
 * 
 * @author lucadebeir
 *
 */

public class UserDAOMySQL extends UserDAO {
	
	public UserDAOMySQL(Connection conn) {
	  super(conn);
	}
	 
	public User find(int id) {
		User user = new User(0, null, null, null, null);      
	    
	  try {
	    ResultSet result = this.connect.createStatement(
	    ResultSet.TYPE_SCROLL_INSENSITIVE,
	    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM User WHERE idUser = " + id);
	    if(result.first())
	    	user = new User(
	    		id,
	        result.getString("lastNameUser"),
	        result.getString("firstNameUser"),
	        result.getString("email"),
	        result.getString("password"));
	  } catch (SQLException e) {
	    e.printStackTrace();
	  }
	  return user;
	}
	
	public User login(String id, String password) {
		User user = new User(0, null, null, null, null);
		
		try {
		   ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM User WHERE email = '" + id + "' AND password = '" + password + "'");
		   if(result.next()) {
			   user = new User(
			    	result.getInt("idUser"),
			        result.getString("lastNameUser"),
			        result.getString("firstNameUser"),
			        result.getString("email"),
			        result.getString("password"));
			   return user;
		   } else { 
			   return null;
		   }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return null;
	}
	
	@Override
	public void createUser(User obj) {
		try {
			this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO User VALUES (NULL,'" + obj.getLastNameUser() + "','" + obj.getFirstNameUser() + "','" + obj.getEmailUser() + "','" + obj.getPasswordUser() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean deleteUser(User obj) {
		// TODO Auto-generated method stub
		try {
			this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM User WHERE idUser = '" + obj.getId() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean updateUser(User obj) {
		// TODO Auto-generated method stub
		try {
			this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE User SET lastNameUser = '" + obj.getLastNameUser() + "', firstNameUser = '" + obj.getFirstNameUser() + "', email = '" + obj.getEmailUser() + "', password = '" + obj.getPasswordUser() + " WHERE idUser = '" + obj.getId() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int getUserByMail(String mail) {
		// TODO Auto-generated method stub
		int idUser;
		
		try {
		   ResultSet result = this.connect.createStatement().executeQuery("SELECT idUser FROM User WHERE email = '" + mail + "'");
		   if(result.next()) {
			   idUser = result.getInt("idUser");
			   return idUser;
		   } else { 
			   return 0;
		   }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return 0;
	}
	
	public ArrayList<String> getAllEmailUserOfEvent(int id) {
		ArrayList<String> list = new ArrayList<String>();
		String mail;
		
		String sql = "SELECT email FROM user WHERE idUser IN "
				+ "(SELECT idUser From isVolunteer Where idEvent = ? UNION Select idUser FROM isIntervener "
				+ "WHERE idEvent = ? UNION SELECT idUser FROM isManager WHERE idEvent = ?)";
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = this.connect.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, id);
			preparedStatement.setInt(3, id);
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()) {
				mail = result.getString("email");
				list.add(mail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}

