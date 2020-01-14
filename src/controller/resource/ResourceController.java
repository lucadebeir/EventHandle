package controller.resource;

import java.io.IOException;
import java.util.*;
import facade.LoginFacade;
import facade.ResourceFacade;
import facade.exception.DisconnectedUserException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Resource;
import model.User;
import ui.Router;

/**
 * @author simongayet
 */
public class ResourceController {


	private ResourceFacade resourceFacade;
	private LoginFacade lF;
	private int eventId;
	private Resource selectedResource;
	
	@FXML private ListView<Resource> consomableList;
	@FXML private ListView<Resource> materialList;
	@FXML private ListView<Resource> vehicleList;
    @FXML private Button deleteButton;
    @FXML private Button displayButton;
    @FXML private Button addButton;
	List<Resource> materials;
	private ObservableList<Resource> materialObservableList;
	
	//pour la partie manager vs volunteer vs intervener
	List<User> listVolunteer;
	List<User> listIntervener;
		
	boolean isVolunteer;
	boolean isIntervener;
	
    
    public ResourceController() {	
    	eventId = (int) Router.getInstance().getParams()[0];
    	
    	this.resourceFacade = new ResourceFacade();
    	
    	this.materialObservableList = FXCollections.observableArrayList();
	}
    
    private void fetchResourceLists() {
		materials = resourceFacade.getResourcesForEvent("material",this.eventId);	
	}
    
    public void initialize() throws DisconnectedUserException {
    	//pour la partie manager vs volunteer vs intervener
    	lF = new LoginFacade();
    			
    	listVolunteer = lF.getAllVolunteerOfAnEvent(eventId);
    	listIntervener = lF.getAllIntervenerOfAnEvent(eventId);
    			
    	isVolunteer = lF.isVolunteer(listVolunteer);
    	isIntervener = lF.isIntervener(listIntervener);
    	
    	fetchResourceLists(); 
    	materialObservableList = FXCollections.observableArrayList();
    	for (Resource resource : materials) {
    		materialObservableList.add(resource);
		}
    	
    	materialList.setItems(this.materialObservableList);
    	materialList.setCellFactory(resourceListView -> new ResourceListViewCell());
    	
    	if(isVolunteer || isIntervener) {
    		addButton.setVisible(false);
    		deleteButton.setVisible(false);
    		displayButton.setVisible(false);
    	}
    	
    	deleteButton.setDisable(true);
    	displayButton.setDisable(true);
    	
    	ChangeListener listenerMaterial = new ChangeListener() {  
    		@Override
    		public void changed(ObservableValue arg0, Object arg1, Object arg2) {
    			try {
    				selectedResource = materialList.getSelectionModel().getSelectedItem();
    				deleteButton.setDisable(false);	
    				displayButton.setDisable(false);
    			} catch (Exception e) {
    				deleteButton.setDisable(true);
    				displayButton.setDisable(true);
    			}
    		}  
    	}; 	
    	materialList.getSelectionModel().selectedIndexProperty().addListener(listenerMaterial);
    }
    
    @FXML
	private void backToMyEvent(ActionEvent event) {
		Router.getInstance().activate("Event", Router.getInstance().getParams());
	}

    @FXML
	public void goToAddResources() throws DisconnectedUserException, IOException {
	
		int idEvent = (int) Router.getInstance().getParams()[0];
		Object[] params = new Object[2];
		params[0] = idEvent;
		params[1] = this.resourceFacade;
		
		Router.getInstance().activate("AddResource", params);
	
	}
    
    
    public void displayResource()  throws DisconnectedUserException, IOException {
    	int idEvent = (int) Router.getInstance().getParams()[0];
		Object[] params = new Object[3];
		params[0] = idEvent;
		params[1] = this.resourceFacade;
		params[2] = selectedResource;
		
		Router.getInstance().activate("DisplayResource", params);
    }

    /**
     * @return
     * @throws DisconnectedUserException 
     */
    public void deleteResource() throws DisconnectedUserException {
        resourceFacade.deleteResource("material",selectedResource.getIdResource());
        initialize();
    }

    /**
     * @return
     */
    public Set<Resource> getAllResources() {
        // TODO implement here
        return null;
    }

}