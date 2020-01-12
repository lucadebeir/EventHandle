package controller.event;

import java.io.IOException;

import model.MyDate;
import ui.Router;
import facade.EventFacade;
import facade.exception.DisconnectedUserException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * 
 * @author lucadebeir
 *
 */

public class AddEvent {
	
	EventFacade eF = new EventFacade();
	
	@FXML private TextField nameEvent;
	@FXML private TextField locationEvent;
	@FXML private TextArea descriptionEvent;
	@FXML private DatePicker dateStart;
	@FXML private DatePicker dateEnd;
	@FXML private Label errorLabel;
	
	@FXML
	private void backHomePage() {
		Router.getInstance().activate("HomePage",Router.getInstance().getParams());
	}
	
	@FXML
    private void addEvent(ActionEvent event) throws IOException, DisconnectedUserException {
		if (!nameEvent.getText().isEmpty() && !locationEvent.getText().isEmpty() && !descriptionEvent.getText().isEmpty() && !dateStart.getValue().toString().isEmpty() && !dateEnd.getValue().toString().isEmpty()) {
			String dateStartString = dateStart.getValue().toString();
			String dateEndString = dateEnd.getValue().toString();
    		MyDate dateStart = new MyDate(dateStartString);
    		MyDate dateEnd = new MyDate(dateEndString);
			eF.addEvent(nameEvent.getText(), locationEvent.getText(), descriptionEvent.getText(), dateStart, dateEnd);
			
			Node source = (Node) event.getSource();
			Stage stage = (Stage) source.getScene().getWindow();
			stage.close();
			
			Router.getInstance().activate("HomePage", Router.getInstance().getParams());
		} else {
    		errorLabel.setText("Error : Missing Field");
    	}
	}

}
