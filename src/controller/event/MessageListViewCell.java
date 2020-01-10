package controller.event;

import java.io.IOException;

import facade.LoginFacade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import model.Message;

public class MessageListViewCell extends ListCell<Message> {
	
	
	private EventController controller;
	
	@FXML 
	private Label cellNameSender;
	
	@FXML 
	private Label cellObject;
	
	@FXML 
	private BorderPane cellLayout;
	
	FXMLLoader mLLoader;
	
	LoginFacade lF = new LoginFacade();

	public MessageListViewCell() {
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
