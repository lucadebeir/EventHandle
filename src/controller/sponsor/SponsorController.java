package controller.sponsor;

import java.io.IOException;
import java.util.*;

import facade.SponsorFacade;
import facade.exception.DisconnectedUserException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Sponsor;
import ui.Router;


public class SponsorController {

	public SponsorFacade sponsorFacade;
	public int eventId;
	public Sponsor selectedSponsor;
	
	@FXML public ListView<Sponsor> sponsorList;  // attention, en privé pê problème avec FXML
    @FXML public Button deleteButton;
    @FXML public Button displayButton;
	List<Sponsor> sponsors;
	public ObservableList<Sponsor> sponsorObservableList;
    
    public SponsorController() {
    	eventId = (int) Router.getInstance().getParams()[0];
    	
    	this.sponsorFacade = new SponsorFacade();
    	System.out.println(eventId);
    }
    
    
    
    public void fetchSponsorsLists() {
		System.out.println("ici ça foire1");
		sponsors = sponsorFacade.getSponsorForEvent("sponsor",this.eventId);	
	}
    
	public void initialize() {
    	// fetchSponsorsLists(); // problème entre le daoMySQL et le dao, on ne rentre pas dans getAllSponsor 
		
    	deleteButton.setDisable(true);
    	displayButton.setDisable(true);
		
    	ChangeListener listenerSponsor = new ChangeListener() {  
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
    
	public void backToMyEvent(ActionEvent event) {
		Router.getInstance().activate("Event", Router.getInstance().getParams());
	}
	
	public void goToAddSponsor(ActionEvent event) {	
		Router.getInstance().activate("addSponsor", Router.getInstance().getParams());
	}
	
	public void deleteSponsor(ActionEvent event) {
	
	}
	
	public void displaySponsor(ActionEvent event) {
		
	}
	
	
}
    
    
    
