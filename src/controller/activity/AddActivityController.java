package controller.activity;

import java.io.IOException;

import facade.ActivityFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ui.Router;

public class AddActivityController {
	
	ActivityFacade af =  new ActivityFacade();
	int idEvent = (int) Router.getInstance().getParams()[0];
	
	@FXML
    private TextField nameActivity;
	
	@FXML
    private TextArea descriptionActivity;
	
	
	@FXML
	private void addActivity(ActionEvent e) throws IOException{
		af.addActivity(nameActivity.getText(),descriptionActivity.getText(),idEvent);
		Object[] params = Router.getInstance().getParams();
		System.out.println("idEvent:" + idEvent);
		Router.getInstance().activate("ActivityList", params);
	}
	
	
	@FXML
	private void backHomePage(ActionEvent e) throws IOException{
		Object[] params = Router.getInstance().getParams();
		Router.getInstance().activate("ActivityList", params);
	}
}
