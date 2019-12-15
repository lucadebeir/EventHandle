package ui.loginSignUp;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * @author lucadebeir
 *
 */

public class SignUpUI extends Application {

		private Stage primaryStage;

		@Override
		public void start(Stage primaryStage) throws IOException {
			this.primaryStage = primaryStage;
			initSignUpLayout();
		}

		private void initSignUpLayout() throws IOException {

			FXMLLoader root = new FXMLLoader(getClass().getResource("UserForm.fxml"));
			Parent parent = root.load();
			Scene scene = new Scene(parent);
			primaryStage.setTitle("Create an account");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}

		public static void main(String[] args) {
			launch(args);
		}
}

