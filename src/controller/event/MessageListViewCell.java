package controller.event;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import model.MessageCell;

public class MessageListViewCell extends ListCell<MessageCell> {
	
	
	private EventController controller;
	
	@FXML 
	private Label cellNameSender;
	
	@FXML 
	private Label cellObject;
	
	@FXML 
	private BorderPane cellLayout;
	
	FXMLLoader mLLoader;

	public MessageListViewCell() {
		super();
	}
	

	@Override
	protected void updateItem(MessageCell mc, boolean empty) {
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
            
            this.cellNameSender.setText(String.valueOf(mc.getNameSender()));
            this.cellObject.setText(String.valueOf(mc.getObjectMessage()));
            this.cellObject.setWrapText(true);
            
            setText(null);
            setGraphic(cellLayout);
        }

    }

}
