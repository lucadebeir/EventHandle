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

    /**
     * @return
     */
    public void createResource() {
        // TODO implement here
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