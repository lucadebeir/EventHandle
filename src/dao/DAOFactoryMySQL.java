package src.dao;

import java.sql.Connection;

import src.dao.implement.ActivityDAO;
import src.dao.implement.ChatDAO;
import src.dao.implement.ConservationDAO;
import src.dao.implement.EventDAO;
import src.dao.implement.EventDAOMySQL;
import src.dao.implement.MessageDAO;
import src.dao.implement.NotificationDAO;
import src.dao.implement.RessourceDAO;
import src.dao.implement.SponsorDAO;
import src.dao.implement.TaskDAO;
import src.dao.implement.UserDAO;
import src.dao.implement.UserDAOMySQL;
import src.database.BdConnector;

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
	    return null;
	}
	
	/**
	 * @return
	 */
	public ActivityDAO createActivityDAO() {
	    // TODO implement here
	    return null;
	}
	
	/**
	 * @return
	 */
	public RessourceDAO createRessourceDAO() {
	    // TODO implement here
	    return null;
	}
	
	/**
	 * @return
	 */
	public MessageDAO createMessageDAO() {
	    // TODO implement here
	    return null;
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
	    return null;
	}
	
	/**
	 * @return
	 */
	public NotificationDAO createNotificationDAO() {
	    // TODO implement here
	    return null;
	}
	
	/**
	 * @return
	 */
	public TaskDAO createTaskDAO() {
	    // TODO implement here
	    return null;
	}
  
}

