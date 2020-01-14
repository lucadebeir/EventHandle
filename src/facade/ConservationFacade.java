package facade;

import java.util.*;

import dao.AbstractDAOFactory;
import dao.implement.ConservationDAO;
import model.Conservation;

/**
 * 
 */
public class ConservationFacade {

	public ConservationDAO conservationDAO;
    public AbstractDAOFactory factory;
    
    
    public ConservationFacade() {
    	factory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
    	conservationDAO = factory.createConcervationDAO();
    }
    
    public void addConservation(Conservation conservationDTO) {
    	
    }
    
    public void updateConservation(Conservation conservationDTO) {
    	
    }
    
    public void deleteConservation(Conservation conservationDTO) {
    	
    }

    public void getConservation(int idConservation) {
    	
    }




}