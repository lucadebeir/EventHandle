package controller.sponsor;

import java.io.IOException;
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
import model.Consomable;
import model.Resource;
import model.Sponsor;
import ui.Router;

public class AddSponsorController {
	
	SponsorFacade sponsorFacade; 
	
	private int eventId;

	@FXML private TextField nameSponsor;
	@FXML private TextField numSiretSponsor;
	@FXML private TextField lastNameSponsor;
	@FXML private TextField firstNameSponsor;
	@FXML private TextField emailSponsor;
	
	@FXML private Label errorLabel;
	
	@FXML
	public void AddSponsorController() {
		this.eventId = (int) Router.getInstance().getParams()[0];
	}
	
	@FXML
    public void initialize() throws SQLException, DisconnectedUserException {
		System.out.println("init");
		this.sponsorFacade = new SponsorFacade();  
		System.out.println(sponsorFacade);
		this.eventId = (int) Router.getInstance().getParams()[0];
	}
	
	@FXML
	private void backToMySponsor(ActionEvent event) {
		Router.getInstance().activate("Sponsors", Router.getInstance().getParams());
		
	}
	
	@FXML
    private void addSponsor(ActionEvent event) throws IOException, DisconnectedUserException {
		
		System.out.println("on rentre bien dans le addSponsor");
		if (formValidator()) {	
			
			Sponsor sponsor = this.createSponsorDTO();
			System.out.println(sponsor +", on a bien l'objet");
			System.out.println(sponsorFacade + ", sponsor facade");
			this.sponsorFacade.addSponsor(sponsor);  //ici ça plante
			
			Router.getInstance().activate("Sponsors", Router.getInstance().getParams());
		} else {
			errorLabel.setText("Error : Missing Field");
    	}
	}
	
	private boolean formValidator() {
		
		boolean filled = !nameSponsor.getText().isBlank() 
				&& !numSiretSponsor.getText().isBlank() 
				&& !lastNameSponsor.getText().isBlank()
				&& !firstNameSponsor.getText().isBlank()
				&& !emailSponsor.getText().isBlank();
		return filled;
	}
	
	@FXML
	public Sponsor createSponsorDTO() {
		Sponsor sponsorDTO;
		
		String nameSponsor = this.nameSponsor.getText();
		int numSiretSponsor = Integer.parseInt(this.numSiretSponsor.getText());
		String lastNameSponsor = this.lastNameSponsor.getText();
		String firstNameSponsor = this.firstNameSponsor.getText();
		String emailSponsor = this.emailSponsor.getText();
		
		System.out.println(nameSponsor);
		System.out.println(numSiretSponsor);
		System.out.println(lastNameSponsor);
		System.out.println(firstNameSponsor);
		System.out.println(emailSponsor);

    	sponsorDTO = new Sponsor(eventId,nameSponsor,numSiretSponsor,lastNameSponsor,firstNameSponsor,emailSponsor);
    	System.out.println(eventId);
    	System.out.println(sponsorDTO +", objet crée, donc on le renvoi pour l'addSponsor");
    	
    	return sponsorDTO;
	}
	
	
}
