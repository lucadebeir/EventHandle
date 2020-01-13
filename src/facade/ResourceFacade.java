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
    	vehicleDAO = factory.createResourceDAO("Vehicle");
    	materialDAO = factory.createResourceDAO("Material");
    	consomableDAO = factory.createResourceDAO("Consomable");
    }


    /**
     * you find the resource type in the resource model
     * @return
     */
    public void addResource(Resource resource) {
    	
    	if (resource instanceof Material) {
    		System.out.println("Material");
    		this.materialDAO.createResource(resource);
    	}
    	if (resource instanceof Consomable) {
    		System.out.println("Consomable");
    		this.consomableDAO.createResource(resource);
    	}
    	if (resource instanceof Vehicle) {
    		System.out.println("Vehicle");
    		this.vehicleDAO.createResource(resource);
    	}
        
    }

    /**
     * @param r 
     * @param idEvent 
     * @return
     */
    public void updateResource(Resource resource) {
    	if (resource instanceof Material) {
    		System.out.println("Material");
    		this.materialDAO.updateResource(resource);
    	}
    	if (resource instanceof Consomable) {
    		System.out.println("Consomable");
    		this.consomableDAO.updateResource(resource);
    	}
    	if (resource instanceof Vehicle) {
    		System.out.println("Vehicle");
    		this.vehicleDAO.updateResource(resource);
    	}
        
    }

    /**
     * @param r 
     * @param idEvent 
     * @return
     */
    public void deleteResource(String type, int idResource) {
    	switch (type) {
		case "Material" : 
			materialDAO.deleteResource(idResource);
			break;
		case "Consomable" : 
			consomableDAO.deleteResource(idResource);
			break;
		case "Vehicle" : 
			vehicleDAO.deleteResource(idResource);
			break;
		default :
			throw new Error("Unexpected resource type give to facade"); 
		}
    }



	public List<Resource> getResourcesForEvent(String type, int idEvent) {
		
		switch (type) {
		case "Material" : 
			return materialDAO.getAllResource(idEvent);
		case "Consomable" : 
			return consomableDAO.getAllResource(idEvent);
		case "Vehicle" : 
			return vehicleDAO.getAllResource(idEvent);
		default :
			throw new Error("Unexpected resource type give to facade"); 
		}
	}

}