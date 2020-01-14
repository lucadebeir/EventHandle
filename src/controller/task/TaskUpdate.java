package controller.task;

import java.sql.SQLException;

import facade.TaskFacade;
import facade.exception.DisconnectedUserException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.MyDate;
import model.Task;
import ui.Router;

public class TaskUpdate {
	
	TaskFacade tf = new TaskFacade();
	int idTask = (int) Router.getInstance().getParams()[0];
	Task t;
	
	@FXML private TextField nameTask;
	@FXML private DatePicker dateStartTask;
	@FXML private DatePicker dateEndTask;
	@FXML private TextArea description;
	
	@FXML private CheckBox statusDone;
	@FXML private CheckBox statusNotDone;
	
	
	
	@FXML private ListView<Task> listCollab;
	
	@FXML
	public void initialize() throws SQLException, DisconnectedUserException {
		this.t = tf.findTask(idTask);
		nameTask.setText(t.getTaskName());
		dateStartTask.setValue(dateStartTask.getConverter().fromString(t.getStartDateTask().getShowingDatePicker()));
		dateEndTask.setValue(dateEndTask.getConverter().fromString(t.getEndDateTask().getShowingDatePicker()));
		description.setText(t.getDescriptionTask());
		System.out.println(t.isStatusTask());
		statusDone.setSelected(t.isStatusTask());
		statusNotDone.setSelected(!t.isStatusTask());
	}
	
	@FXML
    private void addBenevole(ActionEvent event) {
		
	}
	
	@FXML
    private void deleteBenevole(ActionEvent event) {
		
	}
	
	@FXML
    private void modifyTask(ActionEvent event) {
		//Task t = new Task(t.getIdTask(),)
		MyDate dStart = new MyDate(dateStartTask.getValue().toString());
		MyDate dEnd = new MyDate(dateEndTask.getValue().toString());
		
		boolean status = statusDone.isSelected();
		int idActivity = t.getIdActivity();
		
		tf.updateTask(idTask,nameTask.getText(), dStart, dEnd, description.getText(),status, idActivity);
		
		Object[] params = Router.getInstance().getParams();
		params[0] = idTask;
		Router.getInstance().activate("TaskDetail", params);
	}
	
	@FXML
    private void deleteTask(ActionEvent event) {
		
	}
	

}
