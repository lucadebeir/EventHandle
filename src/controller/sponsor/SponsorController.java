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
import javafx.event.ActionEvent;
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
	
	}
	
	public void deleteSponsor(ActionEvent event) {
	
	}
	
	public void displaySponsor(ActionEvent event) {
		
	}
	
	
}
    
    
    
