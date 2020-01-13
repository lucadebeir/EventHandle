package ui.sponsor;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SponsorUI {
	
	private Stage primaryStage;
	
	public void start(Stage primaryStage) throws IOException {
		
		FXMLLoader root = new FXMLLoader(getClass().getResource("SponsorForm.fxml"));
		
		Parent parent = root.load();
		Scene scene = new Scene(parent);
		primaryStage.setTitle("SponsorHandler");
		Button btn = new Button();
		btn.setLayoutX(100);
	    btn.setLayoutY(80);
	}
}
