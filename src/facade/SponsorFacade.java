package facade;

import java.util.List;

import dao.AbstractDAOFactory;
import dao.implement.ResourceDAO;
import dao.implement.SponsorDAO;
import javafx.scene.control.ListView;
import model.Sponsor;

/**
 * 
 */
public class SponsorFacade {

	public AbstractDAOFactory factory;
    private SponsorDAO sponsorDAO;

    public SponsorFacade() {
    	factory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
    	sponsorDAO = factory.createSponsorDAO();
    }
	
	public SponsorFacade getInstance() {
        return null;
    }

	public List<Sponsor> getSponsorForEvent(String string, int eventId) {
		return sponsorDAO.getAllSponsor(eventId);
	}

}