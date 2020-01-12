package dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.Resource;
import database.BdConnector;

/**
 * 
 */
public class MaterialDAOMySQL extends ResourceDAO {

    /**
     * Default constructor
     */
	public MaterialDAOMySQL(Connection conn) {
		this.connect = conn; 
    }

    /**
     * 
     */
    public Connection connect;


    /**
     * @return
     */
    public void createResource(Resource resource) {
    	try {
			this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    private static final String SQL_INSERT = "INSERT INTO Utilisateur (email, mot_de_passe, nom, date_inscription) VALUES (?, ?, ?, NOW())";
    

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