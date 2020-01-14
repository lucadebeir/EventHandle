package dao;

import java.sql.Connection;

import dao.implement.*;
import database.BdConnector;

/**
 * 
 * @author lucadebeir
 *
 */

public class DAOFactoryMySQL extends AbstractDAOFactory {
  protected static final Connection conn = BdConnector.getInstance();   
   
  /**
  * Retourne un objet Classe interagissant avec la BDD
  * @return DAO
  */
  public UserDAO createUserDAO(){
    return new UserDAOMySQL(conn);
  }

	@Override
	public EventDAO createEventDAO() {
		// TODO Auto-generated method stub
		return new EventDAOMySQL(conn);
	}
	/**
	 * @return
	 */
	public SponsorDAO createSponsorDAO() {
	    // TODO implement here
	    return new SponsorDAOMySQL(conn);
	}
	
	/**
	 * @return
	 */
	public ActivityDAO createActivityDAO() {
	    // TODO implement here
		return new ActivityDAOMySQL(conn);
	}
	
	/**
	 * @return
	 */
	public ResourceDAO createResourceDAO(String type) {
		
		switch (type) {
        case "Consomable":
        	return new ConsomableDAOMySQL(conn);
        case "Material":
        	return new MaterialDAOMySQL(conn);
        case "Vehicle" :
        	return new VehicleDAOMySQL(conn);
   	 }
	    return null;
	}
	
	/**
	 * @return
	 */
	public MessageDAO createMessageDAO() {
	    // TODO implement here
	    return new MessageDAOMySql(conn);
	}
	
	/**
	 * @return
	 */
	public ConservationDAO createConcervationDAO() {
	    // TODO implement here
	    return null;
	}
	
	/**
	 * @return
	 */
	public ChatDAO createChatDAO() {
	    // TODO implement here
	    return new ChatDAOMySql(conn);
	}
	
	/**
	 * @return
	 */
	public NotificationDAO createNotificationDAO() {
	    // TODO implement here
		return new NotificationDAOMySql(conn);
	}
	
	/**
	 * @return
	 */
	public TaskDAO createTaskDAO() {
	    // TODO implement here
		return new TaskDAOMySQL(conn);
	}
  
}

