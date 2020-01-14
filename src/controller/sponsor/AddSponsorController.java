package controller.sponsor;

import java.sql.SQLException;
import java.util.function.UnaryOperator;

import facade.ResourceFacade;
import facade.SponsorFacade;
import facade.exception.DisconnectedUserException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import model.Resource;
import ui.Router;

public class AddSponsorController {
	
	SponsorFacade sponsorFacade; 
	
	private int eventId;

	@FXML private TextField nameSponsor;
	@FXML private TextField numSiretSponsor;
	@FXML private TextArea lastNameSponsor;
	@FXML private TextField firstNameSponsor;
	@FXML private TextField emailSponsor;
	
	
	@FXML
	public void AddSponsorController() {
		this.eventId = (int) Router.getInstance().getParams()[0];
	}
	
	@FXML
    public void initialize() throws SQLException, DisconnectedUserException {
		
		this.sponsorFacade = (SponsorFacade) Router.getInstance().getParams()[1];  
		
		UnaryOperator<Change> intfilter = intChange -> {
		    String text = intChange.getText();

		    if (text.matches("[0-9]*")) {
		        return intChange;
		    }

		    return null;
		};
		
		UnaryOperator<Change> floatfilter = floatChange -> {
		    String text = floatChange.getText();

		    if (text.matches("[\\-\\+]?[0-9]*(\\,[0-9]+)?")) {
		        return floatChange;
		    }

		    return null;
		};
	}
	
	
	@FXML
	private void backToMySponsor(ActionEvent event) {
		Router.getInstance().activate("Sponsors", Router.getInstance().getParams());
		
	}
	
	@FXML
	private void addSponsor() {
	}
	
	
	
	
}
