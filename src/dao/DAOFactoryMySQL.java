package dao;

import java.sql.Connection;

import dao.implement.EventDAO;
import dao.implement.EventDAOMySQL;
import dao.implement.UserDAO;
import dao.implement.UserDAOMySQL;
import database.bdConnector;

/**
 * 
 * @author lucadebeir
 *
 */

public class DAOFactoryMySQL extends AbstractDAOFactory {
  protected static final Connection conn = bdConnector.getInstance();   
   
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

