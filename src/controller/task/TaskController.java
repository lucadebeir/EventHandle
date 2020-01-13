package controller.task;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import facade.TaskFacade;
import facade.exception.DisconnectedUserException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.Activity;
import model.Task;
import ui.Router;

/**
 * 
 */
public class TaskController {
	
	
	@FXML
	private void addTask(ActionEvent e) throws IOException{
		Router.getInstance().activate("addActivity");
	}


}