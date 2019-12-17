package dao;

import java.sql.Connection;

import bdConnector.bdConnector;
import dao.implement.UserDAO;
import dao.implement.UserDAOMySQL;

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
  
}

