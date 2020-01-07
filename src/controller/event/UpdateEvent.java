package src.controller.event;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import src.facade.EventFacade;
import src.facade.exception.DisconnectedUserException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.model.Event;
import src.model.MyDate;
import src.ui.Router;

public class UpdateEvent implements Initializable {
	
	private int idEvent;
	
	private EventFacade eventFacade = new EventFacade();
	
	@FXML private TextField nameEvent;
	@FXML private TextField locationEvent;
	@FXML private DatePicker dateStartEvent;
	@FXML private DatePicker dateEndEvent;
	@FXML private TextArea descriptionEvent;

    /**
     * Default constructor
     */
    public UpdateEvent() {
    }
    
    public void updateEvent(ActionEvent event) throws DisconnectedUserException {
    	
		Event currentEvent = eventFacade.findEventById(this.idEvent);
		Event newEvent = new Event(this.idEvent, nameEvent.getText(), new MyDate(dateStartEvent.getValue().toString()), locationEvent.getText(), new MyDate(dateEndEvent.getValue().toString()), descriptionEvent.getText(), 0);
		eventFacade.updateEvent(this.idEvent, newEvent);
		
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();

		Router.getInstance().activate("HomePage", Router.getInstance().getParams());
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//Remplissage du TextField avec le nom du topic � modifier
		nameEvent.setText(eventFacade.findEventById(this.idEvent).getNameEvent());
		locationEvent.setText(eventFacade.findEventById(this.idEvent).getLocationEvent());
		dateStartEvent.setValue(dateStartEvent.getConverter()
			    .fromString(eventFacade.findEventById(this.idEvent).getDateStartEvent().getShowingDatePicker()));
		dateEndEvent.setValue(dateEndEvent.getConverter()
			    .fromString(eventFacade.findEventById(this.idEvent).getDateEndEvent().getShowingDatePicker()));
		descriptionEvent.setText(eventFacade.findEventById(this.idEvent).getDescriptionEvent());
		
	}
	
	 public void init(int idE) {
		 this.idEvent = idE;
	 }

}
