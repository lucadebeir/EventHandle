package controller.sponsor;

import java.io.IOException;
import java.util.*;

import controller.resource.ResourceListViewCell;
import facade.ResourceFacade;
import facade.SponsorFacade;
import facade.exception.DisconnectedUserException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Resource;
import model.Sponsor;
import ui.Router;


public class SponsorController {

	private SponsorFacade sponsorFacade;
	private int eventId;
	private Sponsor selectedSponsor;
	
	@FXML private ListView<Sponsor> sponsorList;  // attention, en privé pê problème avec FXML
    @FXML private Button deleteButton;
    @FXML private Button displayButton;
	List<Sponsor> sponsors;
	private ObservableList<Sponsor> sponsorObservableList;
    
    public SponsorController() {
    	eventId = (int) Router.getInstance().getParams()[0];
    	
    	this.sponsorFacade = new SponsorFacade();

    }
    
    private void fetchSponsorsLists() {
		sponsors = sponsorFacade.getSponsorForEvent("sponsor",this.eventId);	
	}
    
	public void initialize() {
	    	
	    	fetchSponsorsLists(); 
	    	sponsorObservableList = FXCollections.observableArrayList();
	
	    	sponsorList.setItems(this.sponsorObservableList);
	    	//sponsorList.setCellFactory(resourceListView -> new SponsorListViewCell());  // ListViewCell = vue, pas encore implémentée 
	    	
	    	deleteButton.setDisable(true);
	    	displayButton.setDisable(true);
	    	
	    	ChangeListener listenerSponsor = new ChangeListener() {  // à quoi sert ce listener ?
	    		@Override
	    		public void changed(ObservableValue arg0, Object arg1, Object arg2) {
	    			try {
	    				selectedSponsor = sponsorList.getSelectionModel().getSelectedItem();
	    				deleteButton.setDisable(false);	
	    				displayButton.setDisable(false);
	    			} catch (Exception e) {
	    				deleteButton.setDisable(true);
	    				displayButton.setDisable(true);
	    			}
	    		}
	    		
	    	};
	}
	
    public void displayResource()  throws DisconnectedUserException, IOException {
    	int idEvent = (int) Router.getInstance().getParams()[0];
		Object[] params = new Object[3];
		params[0] = idEvent;
		params[1] = this.sponsorFacade;
		params[2] = selectedSponsor;
		
		Router.getInstance().activate("DisplaySponsor", params);
    }
    
    
    
}