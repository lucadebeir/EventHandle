package controller.sponsor;

import java.io.IOException;
import java.util.*;
import facade.SponsorFacade;
import facade.exception.DisconnectedUserException;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Sponsor;
import ui.Router;


public class SponsorController {

	private SponsorFacade sponsorFacade = null;
	private int eventId = (int) Router.getInstance().getParams()[0];;
	private Sponsor selectedSponsor;
		
	@FXML private ListView<Sponsor> sponsorList; 
    @FXML private Button deleteButton;
    @FXML private Button displayButton;
	List<Sponsor> sponsors = new ArrayList<Sponsor>();
	//private ObservableList<Sponsor> sponsorObservableList;
	protected ListProperty<Sponsor> listPropertySponsor = new SimpleListProperty<>();
    
    public SponsorController() {
    	
    }
    
    
    
    public void fetchSponsorsLists() {
		sponsors = sponsorFacade.getSponsorsForEvent(eventId);	
	}
    
	public void initialize() {
		sponsorFacade = new SponsorFacade();
		
		sponsorList.itemsProperty().bind(listPropertySponsor);
		listPropertySponsor.set(FXCollections.observableArrayList());
		
    	fetchSponsorsLists(); // probl�me entre le daoMySQL et le dao, on ne rentre pas dans getAllSponsor // c'est bon c'�tait le daofactory et le connect qui foirait

    	this.sponsorList.setCellFactory(sponsorListView -> new SponsorListViewCell());
    	
    	sponsorList.itemsProperty().bind(listPropertySponsor);
		listPropertySponsor.set(FXCollections.observableArrayList(sponsors));

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
    
    
    
