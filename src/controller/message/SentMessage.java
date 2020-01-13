package controller.message;

import java.io.IOException;
import java.util.ArrayList;

import facade.LoginFacade;
import facade.MessageFacade;
import facade.exception.DisconnectedUserException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.MyDate;
import ui.Router;

/*
 * @author lucadebeir
 */

public class SentMessage {
	
	MessageFacade mF = new MessageFacade();
	
	@FXML private TextField cellFrom;
	@FXML private ChoiceBox<String> cellTo;
	@FXML private TextField cellObject;
	@FXML private TextArea cellTextArea;
	@FXML private Label errorLabel;
	
	@FXML
	private void goBack(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
		Router.getInstance().activate("Inbox", Router.getInstance().getParams());
	}
	
	@FXML
    private void goSent(ActionEvent event) throws IOException, DisconnectedUserException {
		int idEvent = (int) Router.getInstance().getParams()[0];
		if (!cellFrom.getText().isEmpty() && !cellTo.getSelectionModel().getSelectedItem().isEmpty() && !cellObject.getText().isEmpty() && !cellTextArea.getText().isEmpty()) {
			mF.sentMessage(cellFrom.getText(), cellTo.getSelectionModel().getSelectedItem(), cellObject.getText(), cellTextArea.getText(), idEvent);
			
			Node source = (Node) event.getSource();
			Stage stage = (Stage) source.getScene().getWindow();
			stage.close();
			
			Router.getInstance().activate("Inbox", Router.getInstance().getParams());
		} else {
    		errorLabel.setText("Error : Missing Field");
    	}
	}
	
	@FXML
	private void initialize() throws DisconnectedUserException {
		int idSender = LoginFacade.getInstance().getConnectedUser().getId();
		LoginFacade lF = new LoginFacade();
		String mailSender = lF.find(idSender).getEmailUser();
		this.cellFrom.setText(mailSender);
		this.cellFrom.setEditable(false);
		
		ArrayList<String> listChoiceBox = new ArrayList<String>();
		listChoiceBox = lF.getAllEmailUserOfEvent((int) Router.getInstance().getParams()[0]);
		ObservableList<String> availableChoices = FXCollections.observableArrayList(listChoiceBox); 
		cellTo.setItems(availableChoices);
	}

}
