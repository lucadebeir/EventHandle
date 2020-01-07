package src.ui.loginSignUp;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * @author lucadebeir
 *
 */

public class LoginUI extends Application {

	private Stage primaryStage;
	private VBox loginLayout;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		initLoginLayout();
	}

	private void initLoginLayout() throws IOException {

		try {

			FXMLLoader root = new FXMLLoader(getClass().getResource("Login.fxml"));
			loginLayout = (VBox) root.load();
			Scene scene = new Scene(loginLayout);
			primaryStage.setTitle("Login Interface");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}      
        
	}

	public static void main(String[] args) {
		launch(args);
	}
}
