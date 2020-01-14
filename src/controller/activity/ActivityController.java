package controller.activity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import application.Main;
import facade.ActivityFacade;
import facade.TaskFacade;
import facade.exception.DisconnectedUserException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Activity;
import ui.Router;

/**
 * 
 */
public class ActivityController {

	public ActivityFacade activityFacade;
	int idEvent = (int) Router.getInstance().getParams()[0];
	
	@FXML
	private Button btnAddActivity;
	
	@FXML
	private ListView<Activity> activityList;
	private ObservableList<Activity> activityObsList;
	
	@FXML
	private void addActivity(ActionEvent e) throws IOException{
		Router.getInstance().activate("addActivity");
	}
	
	@FXML
	public void goBack() {
		Router.getInstance().activate("Event", Router.getInstance().getParams());
	}
	
	@FXML
	public void initialize() throws SQLException, DisconnectedUserException {
		activityObsList = FXCollections.observableArrayList();
		activityFacade = new ActivityFacade();
		
		List<Activity> listA = activityFacade.getListActivity(idEvent);
		activityObsList.addAll(listA);
		activityList.setItems(activityObsList);
		this.itemSelected();
	}
	
	@FXML 
	public void itemSelected() {
		activityList.getSelectionModel().selectedItemProperty().addListener(observable -> {			
			Activity selectedA = activityList.getSelectionModel().getSelectedItem();
			Object[] params = Router.getInstance().getParams();
			params[0] = selectedA.getIdActivity();
			Router.getInstance().activate("ActivityDetail", params);
		});
	}		

}