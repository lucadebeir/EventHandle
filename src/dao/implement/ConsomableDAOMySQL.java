package src.dao.implement;

import java.util.*;

import src.model.Conservation;
import src.model.Ressource;
import src.database.BdConnector;

/**
 * 
 */
public class ConsomableDAOMySQL extends RessourceDAO {

    /**
     * Default constructor
     */
	public ConsomableDAOMySQL(BdConnector connect) {
      
    }

    public BdConnector connect;
    public Conservation conservationType;

    

    /**
     * @return
     */
    public Ressource createRessource() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Ressource updateRessource() {
        // TODO implement here
        return null;
    }

    /**
     * @param id 
     * @return
     */
    public boolean deleteRessource(int id) {
        // TODO implement here
        return false;
    }

    /**
     * @param id 
     * @return
     */
    public Ressource getRessource(int id) {
        // TODO implement here
        return null;
    }

}