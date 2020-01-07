package src.dao;

import java.sql.Connection;

import src.dao.implement.EventDAO;
import src.dao.implement.EventDAOMySQL;
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
  
}

