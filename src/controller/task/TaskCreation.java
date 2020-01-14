package controller.task;

import java.io.IOException;

import facade.TaskFacade;
import facade.exception.DisconnectedUserException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ui.Router;
import model.MyDate;


public class TaskCreation {
	
	TaskFacade taskFacade = new TaskFacade();
	int idActivity = (int) Router.getInstance().getParams()[0];
	
	@FXML private TextField nameTask;
	@FXML private DatePicker dateStartTask;
	@FXML private DatePicker dateEndTask;
	@FXML private TextArea description;
	
	
	@FXML
    private void validateAdd(ActionEvent event) throws IOException, DisconnectedUserException {
		//if(!nameTask.getText().isEmpty() && !dateStartTask.getValue().toString().isEmpty() && !dateEndTask.getValue().toString().isEmpty() && description.getText().isEmpty()) {
			MyDate dStart = new MyDate(dateStartTask.getValue().toString());
			MyDate dEnd = new MyDate(dateEndTask.getValue().toString());
			
			taskFacade.addTask(nameTask.getText(), dStart, dEnd, description.getText(), idActivity);
			
			Object[] params = Router.getInstance().getParams();
			params[0] = idActivity;
			
			Router.getInstance().activate("ActivityDetail", params);
	
		//}
	}
	
	@FXML
    private void cancelAdd(ActionEvent event) {
		Object[] params = Router.getInstance().getParams();
		params[0] = idActivity;
		Router.getInstance().activate("ActivityDetail", params);
	}

}
