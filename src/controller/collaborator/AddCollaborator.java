package controller.collaborator;

import java.io.IOException;
import java.util.ArrayList;

import facade.LoginFacade;
import facade.exception.DisconnectedUserException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import model.Message;
import ui.Router;

public class AddCollaborator {

	@FXML
	private ChoiceBox<String> user;
	
	@FXML 
	private ChoiceBox<String> role;
	
	LoginFacade lF = null;
	
	public AddCollaborator() {
		super();
	}

	@FXML
	public void add(ActionEvent event) throws IOException {
		int idEvent = (int) Router.getInstance().getParams()[0];
		if (!user.getSelectionModel().getSelectedItem().isEmpty() && !role.getSelectionModel().getSelectedItem().isEmpty()) {
			lF.addCollaborator(idEvent,lF.getUserByName(user.getSelectionModel().getSelectedItem()),role.getSelectionModel().getSelectedItem());
			Node source = (Node) event.getSource();
			Stage stage = (Stage) source.getScene().getWindow();
			stage.close();
			
			Router.getInstance().activate("ListOfCollaborators", Router.getInstance().getParams());
		}
	}
	
	@FXML
	public void cancel(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
		Router.getInstance().activate("ListOfCollaborators", Router.getInstance().getParams());
	}
	
	@FXML
	private void initialize() throws DisconnectedUserException {
		lF = new LoginFacade();
		
		int idEvent = (int) Router.getInstance().getParams()[0];

		ArrayList<String> listRoleBox = new ArrayList<String>();
		listRoleBox.add("Volunteer");
		listRoleBox.add("Intervener");
		ObservableList<String> availableChoices = FXCollections.observableArrayList(listRoleBox); 
		role.setItems(availableChoices);
		
		ArrayList<String> listUserBox = new ArrayList<String>();
		listUserBox = (lF.getAllUsersNotCollaborator((int) Router.getInstance().getParams()[0]));
		ObservableList<String> availableChoices2 = FXCollections.observableArrayList(listUserBox); 
		user.setItems(availableChoices2);
	}
}
