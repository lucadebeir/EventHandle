package controller.resource;

import java.io.IOException;
import java.sql.SQLException;
import java.util.function.UnaryOperator;

import facade.ResourceFacade;
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
import javafx.stage.Stage;
import model.Consomable;
import model.Material;
import model.Resource;
import model.Vehicle;
import javafx.scene.Node;
import ui.Router;

public class AddResourceController {
	
	ResourceFacade resourceFacade; 
	
	private int eventId;
	

	@FXML private TextField nameResource;
	@FXML private TextField locationResource;
	@FXML private TextArea descriptionResource;
	@FXML private TextField quantityResource;
	@FXML private TextField priceResource;
	@FXML private TextField volumeResource;
	@FXML private Label errorLabel;
	
	@FXML private ChoiceBox<String> typeResource;
	@FXML private ChoiceBox<String> stateResource;
	
	
	public AddResourceController() {
		this.eventId = (int) Router.getInstance().getParams()[0];
	}
	
	@FXML
    public void initialize() throws SQLException, DisconnectedUserException {
		
		this.resourceFacade = (ResourceFacade) Router.getInstance().getParams()[1];
		typeResource.setItems(FXCollections.observableArrayList(Resource.getTyperesourcelist()));
		stateResource.setItems(FXCollections.observableArrayList(Resource.getStateresourcelist()));	
		
		UnaryOperator<Change> intfilter = intChange -> {
		    String text = intChange.getText();

		    if (text.matches("[0-9]*")) {
		        return intChange;
		    }

		    return null;
		};
		
		//regex not working it just let interger
		UnaryOperator<Change> floatfilter = floatChange -> {
		    String text = floatChange.getText();

		    if (text.matches("[\\-\\+]?[0-9]*(\\,[0-9]+)?")) {
		        return floatChange;
		    }

		    return null;
		};
		
		TextFormatter<String> textFormatterQuantity = new TextFormatter<>(intfilter);
		TextFormatter<String> textFormatterPrice = new TextFormatter<>(floatfilter);
		TextFormatter<String> textFormatterVolume = new TextFormatter<>(floatfilter);
		this.quantityResource.setTextFormatter(textFormatterQuantity);
		this.priceResource.setTextFormatter(textFormatterPrice);
		this.volumeResource.setTextFormatter(textFormatterVolume);
	}
	
	@FXML
	private void backToMyResource(ActionEvent event) {
		Router.getInstance().activate("Resources", Router.getInstance().getParams());
		
	}
	
	@FXML
    private void addResource(ActionEvent event) throws IOException, DisconnectedUserException {
		
		if (formValidator()) {	

			try {
				this.resourceFacade.addResource(this.createResourceDTO());
			}
			catch(Error e) {
				errorLabel.setText("Database Error : Please retry after");
			}
			
			Router.getInstance().activate("Resources", Router.getInstance().getParams());
			
			
		} else {
			errorLabel.setText("Error : Missing Field");
    	}
	}
	
	/**
	 * check if form is well filled. Description, volume and price can be empty
     * @return boolean 
     */
	private boolean formValidator() {
		
		boolean filled = !nameResource.getText().isBlank() 
				&& !locationResource.getText().isBlank() 
				&& !quantityResource.getText().isBlank()
				&& !(this.typeResource.getSelectionModel().getSelectedItem().isBlank())
				&& !(this.stateResource.getSelectionModel().getSelectedItem().isBlank());
		return filled;
	}
	
	private Resource createResourceDTO() {
		
		Resource resourceDTO;
		
		int quantity = !(quantityResource.getText().isBlank()) ? Integer.parseInt(quantityResource.getText()) : null; 
		float price = !(priceResource.getText().isBlank()) ? Float.parseFloat(priceResource.getText()) : null ;
		float volume = !(volumeResource.getText().isBlank()) ? Float.parseFloat(volumeResource.getText()) : null ;
		
		switch (this.typeResource.getSelectionModel().getSelectedItem()) {
	    case "Consomable":	
	    	return resourceDTO = new Consomable(nameResource.getText(),
	    			locationResource.getText(),
	    			descriptionResource.getText(),
	    			this.stateResource.getSelectionModel().getSelectedItem(),
	    			volume,
	    			quantity,
	    			price,
	    			this.eventId,
	    			null,
	    			null);
	    	
	    case "Material":
	    	return resourceDTO = new Material(nameResource.getText(),
	    			locationResource.getText(),
	    			descriptionResource.getText(),
	    			this.stateResource.getSelectionModel().getSelectedItem(),
	    			volume,
	    			quantity,
	    			price,
	    			this.eventId);
	    	
	    case "Vehicle" :
	    	return resourceDTO = new Vehicle(nameResource.getText(),
	    			locationResource.getText(),
	    			descriptionResource.getText(),
	    			this.stateResource.getSelectionModel().getSelectedItem(),
	    			volume,
	    			quantity,
	    			price,
	    			this.eventId);
	    default: 
	    	throw new Error("Unexpected resource type");
		}
	 }

}

