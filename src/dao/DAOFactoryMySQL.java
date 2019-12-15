package dao;

import java.sql.Connection;

import connexion.Connexion;
import dao.implement.UserDAO;
import dao.implement.UserDAOMySQL;

/**
 * 
 * @author lucadebeir
 *
 */

public class DAOFactoryMySQL extends AbstractDAOFactory {
  protected static final Connection conn = Connexion.getInstance();   
   
  /**
  * Retourne un objet Classe interagissant avec la BDD
  * @return DAO
  */
  public UserDAO createUserDAO(){
    return new UserDAOMySQL(conn);
  }
  
}

