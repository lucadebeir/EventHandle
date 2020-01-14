package controller.task;

import java.sql.SQLException;

import facade.TaskFacade;
import facade.exception.DisconnectedUserException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Task;
import ui.Router;

public class TaskDetail {
	
	TaskFacade tf = new TaskFacade();
	int idTask = (int) Router.getInstance().getParams()[0];
	Task t;
	
	@FXML private Label nameTask;
	@FXML private Label dateStartTask;
	@FXML private Label dateEndTask;
	@FXML private Label description;
	@FXML private Label statusTask;
	
	@FXML private ListView<Task> listCollab;
	
	
	@FXML
	public void initialize() throws SQLException, DisconnectedUserException {
		this.t = tf.findTask(idTask);
		nameTask.setText(t.getTaskName());
		dateStartTask.setText(t.getStartDateTask().getShowingDate());
		dateEndTask.setText(t.getEndDateTask().getShowingDate());
		description.setText(t.getDescriptionTask());
		String status = t.isStatusTask() ? "Effectuate" : "not effectuate";
		System.out.println(status);
		statusTask.setText(status);
	}
	
	@FXML
    private void goBack(ActionEvent event) {
		Object[] params = Router.getInstance().getParams();
		params[0] = t.getIdActivity();
		Router.getInstance().activate("ActivityDetail", params);
	}
	@FXML
    private void modifyTask(ActionEvent event) {
		Object[] params = Router.getInstance().getParams();
		params[0] = idTask;
		Router.getInstance().activate("TaskModify", params);
	}
	
	@FXML
    private void deleteTask(ActionEvent event) {
		
	}
	
}
