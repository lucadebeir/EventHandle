package facade;

import java.util.ArrayList;

import dao.AbstractDAOFactory;
import dao.implement.UserDAO;
import facade.exception.DisconnectedUserException;
import model.User;

/**
 * 
 * @author lucadebeir
 *
 */

public class LoginFacade {
	
	private AbstractDAOFactory af = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private UserDAO userDAO = af.createUserDAO();
	private User user;
	
	/** Holder */
    private static class SingletonHolder
    {       
        /** Instance unique non préinitialisée */
        private final static LoginFacade instance = new LoginFacade();
    }
    
    /** Point d'accès pour l'instance unique du singleton */
    public static LoginFacade getInstance()
    {
        return SingletonHolder.instance;
    }
    
    /**
     * @param email 
     * @param password 
     * @return boolean true if the user is logged false if wrong login or password
     */
	public void login(String email, String password) {
		user = userDAO.login(email, password);
		LoginFacade.getInstance().setConnectedUser(user);
    }
	
	public void signUp(String lastNameUser, String firstNameUser, String emailUser, String password) {
		user = new User(0, lastNameUser,firstNameUser,emailUser,password);
		userDAO.createUser(user);
	
	}
	
	public void updateUser(User uCo) {
		userDAO.updateUser(uCo);
		
	}
	
	public ArrayList<String> getAllEmailUserOfEvent(int idEvent) {
		return userDAO.getAllEmailUserOfEvent(idEvent);
	}
	
	public int getUserByMail(String email) {
		return userDAO.getUserByMail(email);
	}
	
	public int getUserByName(String name) {
		return userDAO.getUserByName(name);
	}
	
	public User getConnectedUser() throws DisconnectedUserException {
		return this.user;
	}

	public void setConnectedUser(User newUser) {
		this.user = newUser;
	}

    public boolean isConnected () {
    	return this.user != null;
    }
    
    public User find(int id) {
    	return userDAO.find(id);
    }
    
    public ArrayList<User> getAllVolunteerOfAnEvent(int idEvent) {
    	return userDAO.getAllVolunteerOfAnEvent(idEvent);
    }
    
    public ArrayList<User> getAllIntervenerOfAnEvent(int idEvent) {
    	return userDAO.getAllIntervenerOfAnEvent(idEvent);
    }
    
    public ArrayList<String> getAllUsersNotCollaborator(int idEvent) {
    	ArrayList<User> list = userDAO.getAllUsersNotCollaborator(idEvent);
    	ArrayList<String> listUser = new ArrayList<String>();
    	String name;
    	for (User u : list) {
    		name = u.getFirstNameUser() + " " + u.getLastNameUser();
    		listUser.add(name);
    	}
    	return listUser;
    }
    
    public void deleteUserCollaborator(int idEvent, int idUser, String role) {
    	userDAO.deleteUserCollaborator(idUser, idEvent, role);
    }
    
    public void addCollaborator(int idEvent, int idUser, String role) {
    	userDAO.addCollaborator(idUser, idEvent, role);
    }

}
