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
		r.add("ListOfActivities", "/ui/event/activities/ListOfActivities.fxml");
		r.add("ListOfSponsors", "/ui/event/sponsors/ListOfSponsors.fxml");
		r.add("ListOfResources", "/ui/event/resources/ListOfResources.fxml");
		r.add("Chat", "/ui/event/chat/Chat.fxml");
		r.add("Inbox", "/ui/event/message/MyMessages.fxml");
		
	}
}
