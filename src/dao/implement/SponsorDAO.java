package dao.implement;

import java.sql.Connection;
import java.util.List;

import database.BdConnector;
import model.Resource;
import model.Sponsor;


public abstract class SponsorDAO {

	protected Connection connect = null;
	
    public SponsorDAO( Connection connect) {
    	this.connect=connect;
    }

    public abstract void createSponsorDAO();
	public abstract List<Sponsor> getAllSponsor(int eventId);


}