package facade;

import java.util.List;

import dao.AbstractDAOFactory;
import dao.implement.ResourceDAO;
import dao.implement.SponsorDAO;
import javafx.scene.control.ListView;
import model.Consomable;
import model.Material;
import model.Resource;
import model.Sponsor;
import model.Vehicle;

/**
 * 
 */
public class SponsorFacade {

	public AbstractDAOFactory factory;
    public SponsorDAO sponsorDAO;

    public SponsorFacade() {
    	factory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
    	sponsorDAO = factory.createSponsorDAO();
    }
	
	public SponsorFacade getInstance() {
        return null;
    }

	public List<Sponsor> getSponsorsForEvent(int eventId) {

		return sponsorDAO.getAllSponsor(eventId);
	}
	
    public void addSponsor(Sponsor sponsor) {
    	this.sponsorDAO.createSponsor(sponsor);       
    }

}