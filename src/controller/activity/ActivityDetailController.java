package controller.activity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import facade.ActivityFacade;
import facade.TaskFacade;
import facade.exception.DisconnectedUserException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import model.Activity;
import model.Task;
import ui.Router;

public class ActivityDetailController {
	
	TaskFacade taskFacade;
	ActivityFacade activityFacade;
	
	int idActivity = (int) Router.getInstance().getParams()[0];
	
	@FXML
	private ListView<Task> taskList;
	private ObservableList<Task> taskObsList;
	
	@FXML
    private Label nameLabel;
	
	//@FXML
    //private Label descriptionLabel;
	
	@FXML
	private TextArea descriptionArea;
	
	@FXML
	private ToggleButton statusButton;
	
	
	
	@FXML
	public void initialize() throws SQLException, DisconnectedUserException {
		
		
		// initialize list of task
		taskObsList = FXCollections.observableArrayList();
		taskFacade = new TaskFacade();
		List<Task> listT = taskFacade.getTaskList(idActivity);
		taskObsList.addAll(listT);
		taskList.setItems(taskObsList);
		this.itemSelected();
		
		//initialize details of the activity
		activityFacade = new ActivityFacade();
		Activity a = activityFacade.getActivityById(idActivity);
		nameLabel.setText(a.getNameActivity());
		//descriptionLabel.setText(a.getDescriptionActivity());
		descriptionArea.setText(a.getDescriptionActivity());
		descriptionArea.setWrapText(false);
		statusButton.setSelected(a.isStatusActivity());
		
	}
	
	private void itemSelected() {
		taskList.getSelectionModel().selectedItemProperty().addListener(observable -> {			
			Task selectedT = taskList.getSelectionModel().getSelectedItem();
			Object[] params = new Object[1];
			params[0] = selectedT.getIdTask();
			Router.getInstance().activate("TaskDetail", params);
		});
		
	}
	
	@FXML
	private void addTask(ActionEvent e) throws IOException{
		Object[] params = new Object[1];
		params[0] = idActivity;
		Router.getInstance().activate("addTask",params);
	}
	
	@FXML
	private void modifyActivity(ActionEvent e) throws IOException{
		
	}
	
	@FXML
	private void deleteActivity(ActionEvent e) throws IOException{
		
	}
	
	@FXML
	private void goBack() {
		Router.getInstance().activate("ActivityList", Router.getInstance().getParams());
	}
	
	
}
