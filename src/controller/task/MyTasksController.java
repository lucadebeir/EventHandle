package controller.task;

import java.util.List;

import controller.event.ChatListView;
import facade.TaskFacade;
import facade.exception.DisconnectedUserException;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Chat;
import model.Task;
import ui.Router;

/**
 * @author lucadebeir
 */
public class MyTasksController {
	
	@FXML private Button buttonTaskDone;
	@FXML private Button goBackButton;
	
	@FXML ListView<Task> myTasksListView;
	
	TaskFacade tF = null;
	
	List<Task> listTask;
	protected ListProperty<Task> listPropertyTask = new SimpleListProperty<>();
	
	int idEvent = (int) Router.getInstance().getParams()[0];

    /**
     * Default constructor
     */
    public MyTasksController() {
    }
    
    @FXML
    public void initialize() throws DisconnectedUserException {
    	tF = new TaskFacade();
    	
    	fetchListTaskView();
    }
    
    public void fetchListTaskView() throws DisconnectedUserException {
    	listTask = tF.getAllTaskOfOnUser(idEvent);
		
		this.myTasksListView.setCellFactory(taskListView -> new TaskListViewCell());
		
		
		myTasksListView.itemsProperty().bind(listPropertyTask);
		listPropertyTask.set(FXCollections.observableArrayList(listTask));
    }
    
    @FXML
    public void goBack() {
    	Router.getInstance().activate("Event", Router.getInstance().getParams());
    }
    
    @FXML
    public void taskDone() {
    	
    }

}