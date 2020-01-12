package controller.resource;

import java.io.IOException;
import java.util.*;

import facade.ResourceFacade;
import facade.exception.DisconnectedUserException;
import javafx.fxml.FXML;
import model.Resource;
import ui.Router;

/**
 * 
 */
public class ResourceController {

    /**
     * Default constructor
     */
    public ResourceController() {
    }

    /**
     * 
     */
    private ResourceFacade resourceFacade;


    
    
    public void initialize() {
    	this.resourceFacade = new ResourceFacade();
	}
    
    
    /**
     * 
     */
    public void addFormResource() {
        // TODO implement here
    }

    @FXML
	public void goToAddResources() throws DisconnectedUserException, IOException {
	
		int idEvent = (int) Router.getInstance().getParams()[0];
		Object[] params = new Object[2];
		params[0] = idEvent;
		params[1] = this.resourceFacade;
		
		Router.getInstance().activate("AddResource", params);
	
	}

    /**
     * @return
     */
    public void updateResource() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void deleteResource() {
        // TODO implement here
    }

    /**
     * @return
     */
    public Set<Resource> getAllResources() {
        // TODO implement here
        return null;
    }

}