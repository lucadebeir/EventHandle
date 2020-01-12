package dao.implement;

import java.sql.Connection;
import java.util.*;

import model.Conservation;
import model.Resource;
import database.BdConnector;

/**
 * 
 */
public class ConsomableDAOMySQL extends ResourceDAO {

    /**
     * Default constructor
     */
	public ConsomableDAOMySQL(Connection conn) {
      this.connect = conn;
    }

    public Connection connect;
    public Conservation conservationType;

    

    /**
     * @return
     */
    public void createResource() {
    }

    /**
     * @return
     */
    public Resource updateResource() {
        // TODO implement here
        return null;
    }

    /**
     * @param id 
     * @return
     */
    public boolean deleteResource(int id) {
        // TODO implement here
        return false;
    }

    /**
     * @param id 
     * @return
     */
    public Resource getResource(int id) {
        // TODO implement here
        return null;
    }

}