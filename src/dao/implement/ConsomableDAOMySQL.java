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
     * @param id 
     * @return
     */
    public Resource getResource(int id) {
        // TODO implement here
        return null;
    }

	@Override
	public void createResource(Resource resource) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateResource(Resource resource) {
		
	}

	@Override
	public void deleteResource(int idResource) {
	}

	@Override
	public List<Resource> getAllResource(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

}