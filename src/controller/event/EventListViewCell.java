package controller.event;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import model.EventCell;
import ui.Router;

public class EventListViewCell extends ListCell<EventCell> {
	
	
	private MyEventsController controller;
	
	@FXML 
	private Label cellLabelName;
	
	@FXML 
	private Label cellLabelLocation;
	
	@FXML 
	private Label cellLabelEndDate;
	
	@FXML 
	private Label cellLabelStartDate;
	
	@FXML 
	private HBox cellLayout;
	
	FXMLLoader mLLoader;

	public EventListViewCell() {
		super();
	}
	

	@Override
	protected void updateItem(EventCell ec, boolean empty) {
        super.updateItem(ec, empty);
        
        if(empty || ec == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../../ui/event/EventListViewCell.fxml"));
                mLLoader.setController(this);
                try {
					mLLoader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            }
            
            this.cellLabelName.setText(String.valueOf(ec.getNameEvent()));
            this.cellLabelLocation.setText(String.valueOf(ec.getLocationEvent()));
            this.cellLabelStartDate.setText(String.valueOf(ec.getDateStartEvent().getShowingDate()));
            this.cellLabelEndDate.setText(String.valueOf(ec.getEndStartEvent().getShowingDate()));
           
            
            setText(null);
            setGraphic(cellLayout);
        }

    }
	
}
