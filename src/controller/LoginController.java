package controller;

import java.io.IOException;
import facade.LoginFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ui.Router;
import javafx.event.ActionEvent;

/**
 * 
 * @author lucadebeir
 *
 */

public class LoginController {

	
		// Java FX Implementation
		@FXML
		private Button btnLogin;
		
		@FXML
		private Button btnSignUp;
		
		@FXML
		private TextField txtEmailUser;
		
		@FXML
		private PasswordField txtPassWord;
		
		@FXML
		private Label errorText;
		
		
		// Config
		
		private String email;
		private String passWord;
		
		//
		
		private LoginFacade loginFacade = new LoginFacade();



		/**
		 * Method used by btnLogin from Java FX
		 * @throws IOException 
		 */
		 @FXML
		 private void login(ActionEvent e) throws IOException {
			 email = txtEmailUser.getText();
			 passWord = txtPassWord.getText();
		     if(email.equals("") || passWord.equals(""))
		     {
		    	 display("Enter email or password");
		     }
		     else
		     {
		    	 loginFacade.login(email, passWord);
		    	 if (loginFacade.isConnected())
		    	 {
		    		 Router.getInstance().activate("HomePage");
                 }
		    	 else
		    	 {
		    		 display("Wrong email/password");
		    	 }
		      }
		    }

		 
		 	@FXML
		 	private void signup(ActionEvent e) throws IOException{
		 		Router.getInstance().activate("SignUp");
		 	}
		 
			@FXML
			public void display(String msg)
			{
				errorText.setText(msg);
			}
		 	
			public void initialize() {
				// TODO Auto-generated method stub
				errorText.setText("");
			}
}
