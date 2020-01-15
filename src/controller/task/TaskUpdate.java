package controller.task;

import java.sql.SQLException;
import java.util.List;

import facade.TaskFacade;
import facade.exception.DisconnectedUserException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.MyDate;
import model.Task;
import model.User;
import ui.Router;

public class TaskUpdate {
	
	TaskFacade tf = new TaskFacade();
	int idTask = (int) Router.getInstance().getParams()[2];
	Task t;
	
	@FXML private TextField nameTask;
	@FXML private DatePicker dateStartTask;
	@FXML private DatePicker dateEndTask;
	@FXML private TextArea description;
	
	@FXML private CheckBox statusDone;
	@FXML private CheckBox statusNotDone;
	
	@FXML private ComboBox<User> listPotential;
	private ObservableList<User> potentialObsList;
	
	
	
	@FXML private ListView<User> listCollab;
	private ObservableList<User> listParticipant;
	
	@FXML
	public void initialize() throws SQLException, DisconnectedUserException {
		this.t = tf.findTask(idTask);
		nameTask.setText(t.getTaskName());
		dateStartTask.setValue(dateStartTask.getConverter().fromString(t.getStartDateTask().getShowingDatePicker()));
		dateEndTask.setValue(dateEndTask.getConverter().fromString(t.getEndDateTask().getShowingDatePicker()));
		description.setText(t.getDescriptionTask());
		statusDone.setSelected(t.isStatusTask());
		statusNotDone.setSelected(!t.isStatusTask());
		
		// initialize list of participant
		listParticipant = FXCollections.observableArrayList();
		List<User> listPart = tf.participantTask(idTask);
		listParticipant.addAll(listPart);
		listCollab.setItems(listParticipant);
		
		// initialize potential participant user add Combobox
		int idEvent = tf.findIdEventTaskByID(idTask);
		List<User> listP = tf.getPotentialExecutor(idEvent);
		User userDelete = null;
		for(User u : listPart) {
			for(User user : listP) {
				System.out.println(user.getId() == u.getId());
				if(user.getId() == u.getId()) {
					userDelete = user;
				}
			}
		}
		if (userDelete != null) {
			listP.remove(userDelete);
		}
		potentialObsList = FXCollections.observableArrayList();
		potentialObsList.addAll(listP);
		listPotential.setItems(potentialObsList);
		
		
		
	}
	
	@FXML
    private void addBenevole(ActionEvent event) {
		User selected = listPotential.getSelectionModel().getSelectedItem();
		if (selected != null) {
			final int selectedIdx = listPotential.getSelectionModel().getSelectedIndex();
			if (selectedIdx != -1) {
				listPotential.getItems().remove(selectedIdx);
				listCollab.getItems().add(selected);
				tf.addParticipant(selected.getId(),idTask);
				Object[] params = Router.getInstance().getParams();
				params[2] = idTask;
				Router.getInstance().activate("TaskModify", params);
			}
		}
	}
	
	@FXML
    private void deleteBenevole(ActionEvent event) {
		User selectedUser;
		final int selectedIdx = listCollab.getSelectionModel().getSelectedIndex();
		if (selectedIdx != -1) {
			selectedUser = listCollab.getSelectionModel().getSelectedItem();
			listCollab.getItems().remove(selectedIdx);
			tf.deleteParticipant(selectedUser.getId(), idTask);
			Object[] params = Router.getInstance().getParams();
			params[2] = idTask;
			Router.getInstance().activate("TaskModify", params);
		}
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
		params[2] = idTask;
		Router.getInstance().activate("TaskDetail", params);
	}
	
	@FXML
    private void goBack(ActionEvent event) {
		Object[] params = Router.getInstance().getParams();
		params[2] = t.getIdTask();
		Router.getInstance().activate("TaskDetail", params);
	}
	
	@FXML
    private void deleteTask(ActionEvent event) {
		
	}
	

}
