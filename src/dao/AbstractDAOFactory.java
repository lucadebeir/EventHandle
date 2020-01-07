package src.dao;

import src.dao.implement.*;

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
  public abstract SponsorDAO createSponsorDAO();
  public abstract ActivityDAO createActivityDAO();
  public abstract RessourceDAO createRessourceDAO(); 
  public abstract MessageDAO createMessageDAO(); 
  public abstract ConservationDAO createConcervationDAO(); 
  public abstract ChatDAO createChatDAO();
  public abstract NotificationDAO createNotificationDAO(); 
  public abstract TaskDAO createTaskDAO(); 
   
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
