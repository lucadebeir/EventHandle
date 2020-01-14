package controller.resource;

import java.io.IOException;
import java.sql.Date;
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
import model.Consomable;
import model.Material;
import model.Resource;
import model.Vehicle;
import ui.Router;

public class DisplayResourceController {
	
ResourceFacade resourceFacade; 
	
	private int eventId;
	private Resource resource;
	

	@FXML private TextField nameResource;
	@FXML private TextField locationResource;
	@FXML private TextArea descriptionResource;
	@FXML private TextField quantityResource;
	@FXML private TextField priceResource;
	@FXML private TextField volumeResource;
	@FXML private Label errorLabel;
	
	@FXML private ChoiceBox<String> stateResource;
	
	
	public DisplayResourceController() {
		this.eventId = (int) Router.getInstance().getParams()[0];
		this.resource = (Resource) Router.getInstance().getParams()[2];
	}
	
	@FXML
    public void initialize() throws SQLException, DisconnectedUserException {
		
		stateResource.setItems(FXCollections.observableArrayList(Resource.getStateresourcelist()));	
		
		nameResource.setText(resource.getNameResource());
		locationResource.setText(resource.getLocationResource());
		descriptionResource.setText(resource.getDescriptionResource());
		quantityResource.setText(Integer.toString(resource.getQuantityResource()));
		priceResource.setText(Float.toString(resource.getPriceResource()));
		volumeResource.setText(Float.toString(resource.getVolumeResource()));
		stateResource.setValue(resource.getStateResource());
		
		
		this.resourceFacade = (ResourceFacade) Router.getInstance().getParams()[1];
	
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
    private void updateResource(ActionEvent event) throws IOException, DisconnectedUserException {
		
		if (formValidator()) {	

			try {
				this.resourceFacade.updateResource(this.updateResourceDTO());
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
				&& !(this.stateResource.getSelectionModel().getSelectedItem().isBlank());
		return filled;
	}
	
	private Resource updateResourceDTO() {
		
		int quantity = !(quantityResource.getText().isBlank()) ? Integer.parseInt(quantityResource.getText()) : null; 
		float price = !(priceResource.getText().isBlank()) ? Float.parseFloat(priceResource.getText()) : null ;
		float volume = !(volumeResource.getText().isBlank()) ? Float.parseFloat(volumeResource.getText()) : null ;
		
		switch (resource.getClassName()) {
	    case "Consomable":	
	    	return new Consomable(this.resource.getIdResource(), 
	    			nameResource.getText(),
	    			locationResource.getText(),
	    			descriptionResource.getText(),
	    			this.stateResource.getSelectionModel().getSelectedItem(),
	    			volume,
	    			quantity,
	    			price,
	    			this.eventId,
	    			new Date(10,10,10),
	    			3);
	    	
	    case "Material":
	    	return new Material(this.resource.getIdResource(),
	    			nameResource.getText(),
	    			locationResource.getText(),
	    			descriptionResource.getText(),
	    			this.stateResource.getSelectionModel().getSelectedItem(),
	    			volume,
	    			quantity,
	    			price,
	    			this.eventId);
	    	
	    case "Vehicle" :
	    	return new Vehicle(this.resource.getIdResource(),
	    			nameResource.getText(),
	    			locationResource.getText(),
	    			descriptionResource.getText(),
	    			this.stateResource.getSelectionModel().getSelectedItem(),
	    			volume,
	    			quantity,
	    			price,
	    			this.eventId);
	    default: 
	    	throw new Error("Unexpected resource type on switch case");
		}
	 }
}
