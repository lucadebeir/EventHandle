package src.dao.implement;

import java.sql.Connection;

import src.model.User;

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
	 
	public abstract src.model.User find(int id);
	
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
}
