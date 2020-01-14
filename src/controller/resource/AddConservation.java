package controller.resource;

import java.io.IOException;
import java.sql.SQLException;
import java.util.function.UnaryOperator;

import facade.ConservationFacade;
import facade.exception.DisconnectedUserException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import model.Conservation;
import ui.Router;

public class AddConservation {
	
	ConservationFacade conservationFacade; 
	
	private int eventId;
	

	@FXML private TextField nameConservation;
	@FXML private TextArea descriptionConservation;
	@FXML private TextField storageTempConservation;
	@FXML private Label errorLabel;
	
	
	public AddConservation() {
		this.eventId = (int) Router.getInstance().getParams()[0];
		this.conservationFacade = (ConservationFacade) Router.getInstance().getParams()[1];
	}
	
	@FXML
    public void initialize() throws SQLException, DisconnectedUserException {
		
		UnaryOperator<Change> intfilter = intChange -> {
		    String text = intChange.getText();

		    if (text.matches("[\\-\\+]?[0-9]*")) {
		        return intChange;
		    }

		    return null;
		};
		
		TextFormatter<String> textFormatterTemp = new TextFormatter<>(intfilter);
		this.storageTempConservation.setTextFormatter(textFormatterTemp);
	}
	
	@FXML
	private void backToMyResource(ActionEvent event) {
		Router.getInstance().activate("AddResource", Router.getInstance().getParams());
		
	}
	
	@FXML
    private void addResource(ActionEvent event) throws IOException, DisconnectedUserException {
		
		if (formValidator()) {	

			try {
				this.conservationFacade.addConservation(this.createConservationDTO());
			}
			catch(Error e) {
				errorLabel.setText("Database Error : Please retry after");
			}
			Router.getInstance().activate("AddResource", Router.getInstance().getParams());
			
			
		} else {
			errorLabel.setText("Error : Missing Field");
    	}
	}
	
	/**
	 * check if form is well filled
     * @return boolean 
     */
	private boolean formValidator() {
		
		boolean filled = !nameConservation.getText().isBlank() && !storageTempConservation.getText().isBlank();
		return filled;
	}
	
	private Conservation createConservationDTO() {
		
		String description = !(descriptionConservation.getText().isBlank()) ? descriptionConservation.getText() : "" ; 
		return new Conservation(nameConservation.getText(), description, Integer.parseInt(storageTempConservation.getText()));
	 }

}
