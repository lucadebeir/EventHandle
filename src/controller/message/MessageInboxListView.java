package controller.message;

import java.io.IOException;

import controller.event.EventController;
import facade.LoginFacade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import model.Message;

public class MessageInboxListView extends ListCell<Message> {
	
	private MessageController controller;
	
	@FXML 
	private Label cellNameSender;
	
	@FXML 
	private Label cellObject;
	
	@FXML
	private TextArea cellContentMessage;
	
	@FXML 
	private BorderPane cellLayout;
	
	FXMLLoader mLLoader;
	
	LoginFacade lF = new LoginFacade();

	public MessageInboxListView() {
		super();
	}
	

	@Override
	protected void updateItem(Message mc, boolean empty) {
        super.updateItem(mc, empty);
        
        if(empty || mc == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../../ui/event/MessageListViewCell.fxml"));
                mLLoader.setController(this);
                try {
					mLLoader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            }
            
            this.cellNameSender.setText(String.valueOf(lF.find(mc.getIdSender()).getFirstNameUser()));
            this.cellObject.setText(String.valueOf(mc.getTitleMessage()));
            this.cellObject.setWrapText(true);
            
            setText(null);
            setGraphic(cellLayout);
        }

    }

}
