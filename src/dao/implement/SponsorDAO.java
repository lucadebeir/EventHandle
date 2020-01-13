package dao.implement;

import java.sql.Connection;

import database.BdConnector;
import model.Sponsor;

/**
 * 
 */
public abstract class SponsorDAO {

	protected Connection connect = null;
	
    /**
     * Default constructor
     */
    public SponsorDAO(Connection conn) {
    	this.connect = conn;
    }
    
    /**
     * Default constructor
     */
    public SponsorDAO() {
    }


    /**
     * @param connect
     */
    public void SponsorDAO(BdConnector connect) {
        // TODO implement here
    }



}