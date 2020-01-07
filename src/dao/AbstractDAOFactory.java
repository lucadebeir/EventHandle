package src.dao;

import src.dao.implement.EventDAO;
import src.dao.implement.UserDAO;

/**
 * 
 * @author lucadebeir
 *
 */

public abstract class AbstractDAOFactory {
  public static final int DAO_FACTORY = 0;
  public static final int XML_DAO_FACTORY = 1;

  //Retourne un objet Classe interagissant avec la BDD
  public abstract UserDAO createUserDAO();
  
  public abstract EventDAO createEventDAO();
   
  //Méthode permettant de récupérer les Factory
  public static AbstractDAOFactory getFactory(int type){
    switch(type){
      case DAO_FACTORY:
        return new DAOFactoryMySQL();
      default:
        return null;
    }
  }
}
