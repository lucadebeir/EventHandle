package dao.implement;

import java.sql.Connection;
import java.util.ArrayList;

import model.Event;
import model.User;

/**
 * 
 * @author lucadebeir
 *
 */

public abstract class UserDAO {
	
	protected Connection connect = null;
	
	/**
     * Default constructor
     */
	public UserDAO(Connection conn) {
		this.connect = conn;
	}
	 
	public abstract User find(int id);
	
	public abstract int getUserByMail(String mail);
	
	public abstract ArrayList<String> getAllEmailUserOfEvent(int id);
	
	/**
     * Log in the user on the app, if it's true.
     * @param email 
     * @param password 
     * @return boolean
     */
	public abstract User login(String email, String password);
			
	/**
     * Creates a new User
     * @param obj 
     * 
     */
	public abstract void createUser(User obj);
	
	/**
     * Update the user thanks to his id
     * @param obj
     */
	public abstract boolean updateUser(User obj);
	
	/**
     * Delete the user thanks to his id
     * @param obj
     */
	public abstract boolean deleteUser(User obj);
	
	public abstract ArrayList<User> getAllIntervenerOfAnEvent(int idEvent);
	
	public abstract ArrayList<User> getAllVolunteerOfAnEvent(int idEvent);
	
	public abstract ArrayList<User> getAllUsersNotCollaborator(int iEvent);
	
	public abstract boolean deleteUserCollaborator(int idUser, int idEvent, String role);
	
	public abstract void addCollaborator(int idUser, int idEvent, String role);
	
	public abstract int getUserByName(String name);
}
