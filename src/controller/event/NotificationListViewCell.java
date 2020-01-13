package controller.event;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import model.NotificationCell;

/*
 * @author lucadebeir
 */

public class NotificationListViewCell extends ListCell<NotificationCell> {
	
	
	private EventController controller;
	
	@FXML 
	private Label cellLabelTitle;
	
	@FXML 
	private TextArea cellTextArea;
	
	@FXML 
	private BorderPane cellLayout;
	
	FXMLLoader mLLoader;

	public NotificationListViewCell() {
		super();
	}
	

	@Override
	protected void updateItem(NotificationCell nc, boolean empty) {
        super.updateItem(nc, empty);
        
        if(empty || nc == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../../ui/event/NotificationListViewCell.fxml"));
                mLLoader.setController(this);
                try {
					mLLoader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            }
            
            this.cellLabelTitle.setText(String.valueOf(nc.getTitle()));
            this.cellTextArea.setText(String.valueOf(nc.getContent()));
            this.cellTextArea.setEditable(false);
            this.cellTextArea.setWrapText(true);
            
            setText(null);
            setGraphic(cellLayout);
        }

    }
	
}
