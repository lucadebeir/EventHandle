package controller.event;

import java.io.IOException;

import facade.LoginFacade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import model.Chat;

/*
 * @author lucadebeir
 */

public class ChatListView extends ListCell<Chat> {
	
	
	private EventController controller;
		
	@FXML 
	private Label cellName;
	
	@FXML 
	private TextArea cellTextArea;
	
	@FXML 
	private BorderPane cellLayout;
	
	FXMLLoader mLLoader;
	
	LoginFacade lF = new LoginFacade();

	public ChatListView() {
	}
	

	@Override
	protected void updateItem(Chat mc, boolean empty) {
        super.updateItem(mc, empty);
        
        if(empty || mc == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../../ui/event/ChatListViewCell.fxml"));
                mLLoader.setController(this);
                try {
					mLLoader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            }
            
            this.cellTextArea.setText(String.valueOf(mc.getContentMessage()));
            this.cellTextArea.setWrapText(true);
            this.cellName.setText(String.valueOf(lF.find(mc.getIdSender()).getFirstNameUser()));
            
            setText(null);
            setGraphic(cellLayout);
        }

    }

}

