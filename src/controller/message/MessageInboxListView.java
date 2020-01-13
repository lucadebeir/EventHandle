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

/*
 * @author lucadebeir
 */

public class MessageInboxListView extends ListCell<Message> {
	
	private MessageController controller;
	
	@FXML
	private Label cellFromOrTo;
	
	@FXML 
	private Label cellNameSender;
	
	@FXML 
	private Label cellObject;
	
	@FXML
	private TextArea cellContentMessage;
	
	@FXML 
	private BorderPane cellLayout;
	
	boolean isSent;
	
	FXMLLoader mLLoader;
	
	LoginFacade lF = new LoginFacade();

	public MessageInboxListView(boolean isSent) {
		super();
		this.isSent = isSent;
	}
	

	@Override
	protected void updateItem(Message mc, boolean empty) {
        super.updateItem(mc, empty);
        
        if(empty || mc == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../../ui/event/message/MessageListViewInbox.fxml"));
                mLLoader.setController(this);
                try {
					mLLoader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            }            
            
            this.cellObject.setText(String.valueOf(mc.getTitleMessage()));
            this.cellContentMessage.setText(String.valueOf(mc.getContentMessage()));
            this.cellContentMessage.setWrapText(true);
            
            if (this.isSent) {
            	this.cellFromOrTo.setText(String.valueOf("To"));
            	this.cellNameSender.setText(String.valueOf(lF.find(mc.getIdReceiver()).getFirstNameUser()));
            } else {
            	this.cellFromOrTo.setText(String.valueOf("From"));
            	this.cellNameSender.setText(String.valueOf(lF.find(mc.getIdSender()).getFirstNameUser()));
            }
            
            setText(null);
            setGraphic(cellLayout);
        }

    }

}
