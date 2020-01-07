package src.controller;

import java.io.IOException;
import src.facade.LoginFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import src.ui.Router;
import javafx.event.ActionEvent;

/**
 * 
 * @author lucadebeir
 *
 */

public class SignUpController {

		LoginFacade loginFacade = new LoginFacade();
			
		// Java FX Implementation
		@FXML
		private TextField lastNameField;
		
		@FXML
		private TextField firstNameField;
			
		@FXML
		private TextField emailField;
			
		@FXML
		private PasswordField passwordField;
			
		@FXML
		private PasswordField passwordConfirmField;
						
		@FXML
		private Button validateNewUserButton;
		
		@FXML
		private Label errorLabel;
		
		@FXML
		private void welcome(ActionEvent event) throws IOException {
	    	if(!firstNameField.getText().isEmpty() && !lastNameField.getText().isEmpty() && !emailField.getText().isEmpty() && !passwordField.getText().isEmpty() && !passwordConfirmField.getText().isEmpty()){
	    		if(passwordField.getText().equals(passwordConfirmField.getText())){
	    			loginFacade.signUp(lastNameField.getText(),firstNameField.getText(),emailField.getText(),passwordField.getText());
	    			Router.getInstance().activate("Login");
				} else {
					errorLabel.setText("Erreur : Invalid password confirmation");
				}
	    	} else {
	    		passwordField.setText("");
	    		passwordConfirmField.setText("");
	    		errorLabel.setText("Error : Missing Field");
	    	}
	    	
	    }
		
		@FXML
		private void backLogin() {
	    	Router.getInstance().activate("Login");

		}
}

