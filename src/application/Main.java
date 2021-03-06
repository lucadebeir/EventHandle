package application;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.Router;

/**
 * 
 * @author lucadebeir
 *
 */

public class Main extends Application {
	
	public static Stage primaryStage = null;
	
	@Override
	public void start(Stage primaryStage) {
		Main.primaryStage = primaryStage;
		
		try {
			FXMLLoader root = new FXMLLoader(getClass().getResource("/ui/loginSignUp/Login.fxml"));
		    Parent skillLayout = root.load();
	        Scene scene = new Scene(skillLayout, 1000, 800);
	        
	        primaryStage.setTitle("EventHandle");
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void init() {
		Router r = Router.getInstance();
		r.add("HomePage", "/ui/event/MyEvents.fxml");
		r.add("Login", "/ui/loginSignUp/Login.fxml");
		r.add("SignUp", "/ui/loginSignUp/UserForm.fxml");
		r.add("AddEvent", "/ui/event/AddEvent.fxml");
		r.add("Event", "/ui/event/Event.fxml");
		r.add("ListOfCollaborators", "/ui/event/collaborators/ListOfCollaborators.fxml");
		r.add("ListOfSponsors", "/ui/event/sponsors/ListOfSponsors.fxml");
		r.add("Chat", "/ui/event/chat/Chat.fxml");
		r.add("Inbox", "/ui/event/message/MyMessages.fxml");
		r.add("ActivityList", "/ui/event/activities/ActivityList.fxml");
		r.add("ActivityDetail", "/ui/event/activities/ActivityDetail.fxml");
		r.add("TaskDetail", "/ui/event/task/TaskDetail.fxml");
		r.add("TaskModify", "/ui/event/task/UpdateTask.fxml");
		r.add("addTask", "/ui/event/task/TaskCreation.fxml");
		r.add("Resources", "/ui/event/resources/Resources.fxml");
		r.add("AddResource", "/ui/event/resources/AddResource.fxml");
		r.add("DisplayResource", "/ui/event/resources/DisplayResource.fxml");
		r.add("SentMessage", "/ui/event/message/SentMessage.fxml");
		r.add("Sponsors", "/ui/event/sponsors/Sponsors.fxml");
		r.add("AddSponsor", "/ui/event/sponsors/AddSponsor.fxml");
		r.add("TasksOfOneUser", "/ui/event/task/TasksOfOneUser.fxml");
		r.add("AddActivity", "/ui/event/activities/AddActivity.fxml");
	}
}
