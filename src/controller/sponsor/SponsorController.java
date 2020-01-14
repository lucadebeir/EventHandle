package controller.sponsor;

import java.io.IOException;
import java.util.*;

import controller.resource.ResourceListViewCell;
import facade.SponsorFacade;
import facade.exception.DisconnectedUserException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Resource;
import model.Sponsor;
import ui.Router;


public class SponsorController {

	private SponsorFacade sponsorFacade;
	private int eventId;
	private Sponsor selectedSponsor;
	
	@FXML private ListView<Sponsor> sponsorList; 
    @FXML private Button deleteButton;
    @FXML private Button displayButton;
	List<Sponsor> sponsors;
	private ObservableList<Sponsor> sponsorObservableList;
    
    public SponsorController() {
    	eventId = (int) Router.getInstance().getParams()[0];
    	
    	this.sponsorFacade = new SponsorFacade();

    	this.sponsorObservableList = FXCollections.observableArrayList();
    }
    
    
    
    public void fetchSponsorsLists() {
		sponsors = sponsorFacade.getSponsorsForEvent(this.eventId);	
	}
    
	public void initialize() {
    	fetchSponsorsLists(); // problème entre le daoMySQL et le dao, on ne rentre pas dans getAllSponsor // c'est bon c'était le daofactory et le connect qui foirait
    	sponsorObservableList = FXCollections.observableArrayList();
    	System.out.println("juste avant le for "+sponsorObservableList);

    	for (Sponsor sponsor : sponsors) {
    		sponsorObservableList.add(sponsor);
		}
    	
    	System.out.println("juste avant le set "+sponsorObservableList);
    	//sponsorList.setItems(this.sponsorObservableList);
    	//sponsorList.setCellFactory(sponsorListView -> new SponsorListViewCell());

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
    	//sponsorList.getSelectionModel().selectedIndexProperty().addListener(listenerSponsor);
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
		Router.getInstance().activate("AddSponsor", Router.getInstance().getParams());
	}
	
	public void deleteSponsor(ActionEvent event) {
	
	}
	
	public void displaySponsor(ActionEvent event) {
		
	}
	
	
}
    
    
    
