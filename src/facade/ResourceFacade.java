package facade;

import java.util.*;

import dao.AbstractDAOFactory;
import dao.implement.EventDAO;
import dao.implement.ResourceDAO;
import model.Consomable;
import model.Event;
import model.Material;
import model.Resource;
import model.Vehicle;

/**
 * 
 */
public class ResourceFacade {
	
	
    private AbstractDAOFactory factory;
    private ResourceDAO vehicleDAO;
    private ResourceDAO materialDAO;
    private ResourceDAO consomableDAO;
    
    
    
    /**
     * Default constructor
     */
    public ResourceFacade() {
    	factory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
    	vehicleDAO = factory.createResourceDAO("Consommable");
    	materialDAO = factory.createResourceDAO("Material");
    	consomableDAO = factory.createResourceDAO("Vehicle");
    }




    /**
     * @return
     */
    public ResourceFacade getInstance() {
    	return null;
        
    }

    /**
     * you find the resource type in the resource model
     * @return
     */
    public Resource addResource(Resource resource) {
    	
    	if (resource instanceof Material) {
    		System.out.println("Material");
    		this.materialDAO.createResource(resource);
    	}
    	if (resource instanceof Consomable) {
    		System.out.println("Consomable");
    	}
    	if (resource instanceof Vehicle) {
    		System.out.println("Vehicle");
    	}
        return null;
    }

    /**
     * @param r 
     * @param idEvent 
     * @return
     */
    public void updateResource(Resource r, int idEvent) {
        // TODO implement here
    }

    /**
     * @param r 
     * @param idEvent 
     * @return
     */
    public void deleteResource(Resource r, int idEvent) {
        // TODO implement here
    }

    /**
     * @param idEvent 
     * @return
     */
    public Set<Resource> getAllResources(int idEvent) {
        // TODO implement here
        return null;
    }

}