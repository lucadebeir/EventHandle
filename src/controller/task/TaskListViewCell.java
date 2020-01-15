package controller.task;

import java.io.IOException;

import facade.TaskFacade;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import model.Task;

public class TaskListViewCell extends ListCell<Task> {
	
	private MyTasksController controller;
	
	TaskFacade tF = null;
	
	@FXML private Label cellNameTask;
	@FXML private Label cellDateStart;
	@FXML private Label cellDateEnd;
	@FXML private TextArea textAreaTask;
	@FXML private CheckBox checkboxStatus;
	@FXML private BorderPane cellLayout;
	
	FXMLLoader mLLoader;
	
	public TaskListViewCell() {
		super();
	}
	
	@Override
	protected void updateItem(Task ec, boolean empty) {
        super.updateItem(ec, empty);
        
        tF = new TaskFacade();
        
        if(empty || ec == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../../ui/event/task/TaskListViewCell.fxml"));
                mLLoader.setController(this);
                try {
					mLLoader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            }
            
            this.cellNameTask.setText(String.valueOf(ec.getTaskName()));
            this.cellDateStart.setText(String.valueOf(ec.getStartDateTask().getShowingDate()));
            this.cellDateEnd.setText(String.valueOf(ec.getEndDateTask().getShowingDate()));
            this.textAreaTask.setText(String.valueOf(ec.getDescriptionTask()));
            this.textAreaTask.setEditable(false);           
            this.checkboxStatus.setSelected(ec.isStatusTask());
            
            this.checkboxStatus.selectedProperty().addListener(new ChangeListener<Boolean>() {
                public void changed(ObservableValue ov,Boolean old_val, Boolean new_val) {
                    tF.setTaskStatus(ec.getIdTask(), new_val);
                }
            });
            
            setText(null);
            setGraphic(cellLayout);
        }

    }

}
