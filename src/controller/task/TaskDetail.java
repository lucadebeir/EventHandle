package controller.task;

import java.sql.SQLException;
import java.util.List;

import facade.TaskFacade;
import facade.exception.DisconnectedUserException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Task;
import model.User;
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
	
	@FXML private ListView<User> listCollab;
	private ObservableList<User> listParticipant;
	
	
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
		
		// initialize list of participant
		listParticipant = FXCollections.observableArrayList();
		List<User> listPart = tf.participantTask(idTask);
		listParticipant.addAll(listPart);
		listCollab.setItems(listParticipant);
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
