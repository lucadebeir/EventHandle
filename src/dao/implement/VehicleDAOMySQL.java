package dao.implement;

import java.sql.Connection;
import java.util.*;

import database.BdConnector;
import model.Resource;

/**
 * 
 */
public class VehicleDAOMySQL extends ResourceDAO {

    /**
     * Default constructor
     * @param conn 
     */
    public VehicleDAOMySQL(Connection conn) {
    	this.connect = conn;
    }

    /**
     * 
     */
    public Connection connect;

    /**
     * @param connect 
     * @return
     */
    public VehicleDAOMySQL VehicleDAOMySQL(BdConnector connect) {
        // TODO implement here
        return null;
    }

   
    public Resource getResource(int id) {
        // TODO implement here
        return null;
    }

	@Override
	public void createResource(Resource resource) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Resource updateResource(Resource resource) {
		// TODO Auto-generated method stub
		return null;
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