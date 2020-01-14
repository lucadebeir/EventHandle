package dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.BdConnector;
import model.Material;
import model.Resource;
import model.Sponsor;


public class SponsorDAOMySQL extends SponsorDAO {
	
	
    public SponsorDAOMySQL(Connection connect) {
		super(connect);
		// TODO Auto-generated constructor stub
	}
    
	public Connection connect;

    public void createSponsor(Sponsor sponsor) {
    	try {
			this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO `sponsor`(`idSponsor`, `nameSponsor`, `numSiretSponsor`, `lastNameSponsor`, `firstNameSponsor`, `emailSponsor`,'idEvent') VALUES (NULL,'" 
			+ sponsor.getNameSponsor() + "','" + sponsor.getNumSiretSponsor() + "','" + sponsor.getLastNameContactSponsor() + "','" 
			+ sponsor.getFirstNameContactSponsor() + "','" + sponsor.getEmailContactSponsor() + "','" + sponsor.getIdEvent() +"')" );
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error("insert into database error");
		}
    }

    public Sponsor findSponsor(int id) {
        return null;
    }

    public void updateSponsor(Sponsor obj) {
    }

    public void deleteSponsor(Sponsor obj) {
    }
    
	public List<Sponsor> getAllSponsor(int eventId) {
		ArrayList<Sponsor> sponsors = new ArrayList<Sponsor>();
		Sponsor sponsor;

		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM `sponsor` WHERE `idEvent`= " + eventId );
			while (result.next()) {
				sponsor = new Sponsor(result.getInt("idSponsor"),result.getInt("idEvent"),result.getString("nameSponsor"),result.getString("numSiretSponsor"),
						result.getString("lastNameSponsor"), result.getString("firstNameSponsor"), result.getString("emailSponsor"));
				sponsors.add(sponsor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sponsors;
	}


	@Override
	public void createSponsorDAO() {
	}

}