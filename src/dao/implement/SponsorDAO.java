package dao.implement;

import java.sql.Connection;
import java.util.List;

import database.BdConnector;
import model.Resource;
import model.Sponsor;


public abstract class SponsorDAO {

	protected Connection connect = null;

    public abstract void createSponsorDAO();
	public abstract List<Sponsor> getAllSponsor(int eventId);
	public abstract void createSponsor(Sponsor sponsor);
	public abstract void deleteSponsor(int id);



}