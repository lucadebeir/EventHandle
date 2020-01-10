package src.controller.event;

import src.model.Event;
import src.model.EventCell;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.controller.event.EventListViewCell;
import src.controller.event.UpdateEvent;
import src.facade.EventFacade;
import src.facade.exception.DisconnectedUserException;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import src.ui.Router;

public class MyEventsController {
	
	@FXML private ListView<EventCell> pastEvent;
	@FXML private ListView<EventCell> futurEvent;
	
	private int eventSelectedId = -1;
	
	List<Event> myPastEvent;
	protected List<Integer> listPastEventId = new ArrayList<>();
	List<Event> myFuturEvent;
	protected List<Integer> listFuturEventId = new ArrayList<>();
	List<EventCell> listPastEvent;
	List<EventCell> listFuturEvent;
	ObservableList<EventCell> myPastEventObservableList;
	ObservableList<EventCell> myFuturEventObservableList;
	
	protected ListProperty<EventCell> listPropertyPastEvents = new SimpleListProperty<>();
	protected ListProperty<EventCell> listPropertyFuturEvents = new SimpleListProperty<>();

	EventFacade eF = null;
	
	@FXML
    private Button exitButton;
	
	@FXML
    private Button addEventButton;
	
	@FXML
    private Button displayEventButton;
	
	@FXML
    private Button updateEventButton;
	
	@FXML
    private Button deleteEventButton;
    
    @FXML 
    public void exit() {
    	Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Default constructor
     */
	public MyEventsController() {
	}
	

	@FXML
    public void initialize() throws SQLException {
		
		eF = new EventFacade();
		try {
			myPastEvent = eF.getAllPastEventConnectedUser();
			myFuturEvent = eF.getAllFuturEventConnectedUser();
		} catch (DisconnectedUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listPastEvent = new ArrayList<>();
		listFuturEvent = new ArrayList<>();
		
		for (Event event : myPastEvent) {
			EventCell eventCell = new EventCell(event.getNameEvent(), event.getDateStartEvent(), event.getDateEndEvent(), event.getLocationEvent());
			listPastEvent.add(eventCell);
			listPastEventId.add(event.getIdEvent());
		}
		
		for (Event event : myFuturEvent) {
			EventCell eventCell = new EventCell(event.getNameEvent(), event.getDateStartEvent(), event.getDateEndEvent(), event.getLocationEvent());
			listFuturEvent.add(eventCell);
			listFuturEventId.add(event.getIdEvent());
		}
		
		myPastEventObservableList = FXCollections.observableArrayList();
		myPastEventObservableList.addAll(listPastEvent);
		
		this.pastEvent.setItems(myPastEventObservableList);
    	this.pastEvent.setCellFactory(eventListView -> new EventListViewCell());
    	
    	
    	myFuturEventObservableList = FXCollections.observableArrayList();
    	myFuturEventObservableList.addAll(listFuturEvent);
		
		this.futurEvent.setItems(myFuturEventObservableList);
    	this.futurEvent.setCellFactory(eventListView -> new EventListViewCell());
    	
    	pastEvent.itemsProperty().bind(listPropertyPastEvents);
		listPropertyPastEvents.set(FXCollections.observableArrayList(listPastEvent));
		
		futurEvent.itemsProperty().bind(listPropertyFuturEvents);
		listPropertyFuturEvents.set(FXCollections.observableArrayList(listFuturEvent));
    	
    	//Disabled buttons delete and update
    	displayEventButton.setDisable(true);
		//addEventButton.setDisable(true);
		updateEventButton.setDisable(true);
		deleteEventButton.setDisable(true);
    	
    	//To know the selected past event
    	ChangeListener listenerPastEvent = new ChangeListener() {  
    		@Override
    		public void changed(ObservableValue arg0, Object arg1, Object arg2) {
    			// TODO Auto-generated method stub
    			
    			//Get the ID of the selected Topic in the ListView
    			try {
    				eventSelectedId = listPastEventId.get(pastEvent.getSelectionModel().getSelectedIndex());
    				//Get update and delete buttons visible
    				updateEventButton.setDisable(false);
    				deleteEventButton.setDisable(false);
    				displayEventButton.setDisable(false);
    			} catch (Exception e) {
    				// TODO: handle exception
    				//After a deletion
    				updateEventButton.setDisable(true);
    				deleteEventButton.setDisable(true);
    				displayEventButton.setDisable(true);
    			}
    		}  
    	}; 
    				
    	//Listener for selecting a Subject in the ListView
    	pastEvent.getSelectionModel().selectedIndexProperty().addListener(
    		listenerPastEvent
    	);
	
    	
    	//To know the selected futur event
    	ChangeListener listenerFuturEvent = new ChangeListener() {  
    		@Override
    		public void changed(ObservableValue arg0, Object arg1, Object arg2) {
    			// TODO Auto-generated method stub
    			
    						
    			//Get the ID of the selected Topic in the ListView
    			try {
    				eventSelectedId = listFuturEventId.get(futurEvent.getSelectionModel().getSelectedIndex());
    				//Get update and delete buttons visible
    				updateEventButton.setDisable(false);
    				deleteEventButton.setDisable(false);
    				displayEventButton.setDisable(false);
    			} catch (Exception e) {
    				// TODO: handle exception
    				//After a deletion
    				updateEventButton.setDisable(true);
    				deleteEventButton.setDisable(true);
    				displayEventButton.setDisable(true);
    			}
    		}  
    	}; 
    				
    	//Listener for selecting a event in the ListView
    	futurEvent.getSelectionModel().selectedIndexProperty().addListener(
    		listenerFuturEvent
    	);
	}
	
	@FXML
	private void addEvent(ActionEvent event) {
		Stage nextStage = new Stage();
		nextStage.setTitle("Add en event");
		Pane myPane = null;
		try {
			myPane = FXMLLoader.load(getClass().getResource("/src/ui/event/AddEvent.fxml"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		Scene scene = new Scene(myPane);
		nextStage.setScene(scene);
		nextStage.show();
	}

	@FXML
	public void displayEvent() throws DisconnectedUserException, IOException {
	
		Object[] params = new Object[1];
		params[0] = eventSelectedId;
		
		Router.getInstance().activate("Event", params);
	
	}
	
	@FXML
	public void updateEvent() throws DisconnectedUserException {
		Stage nextStage = new Stage();
		nextStage.setTitle("");
		//Pane myPane = null;
		Parent sceneMain = null;
		try {
			FXMLLoader loader =new FXMLLoader(
					getClass().getResource("/src/ui/event/UpdateEvent.fxml"));
			UpdateEvent controllerU = new UpdateEvent();
			loader.setController(controllerU);
			
			controllerU.init(eventSelectedId);
			sceneMain = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(sceneMain);
		nextStage.setScene(scene);
		nextStage.show();
		//Ouvrir la fen�tre "UpdateEvent.fxml"
	
	}
	
	@FXML
	public void deleteEvent() throws DisconnectedUserException {
		//Get the name of the deleted Subject
    	String deletedEventName = eF.findEventById(eventSelectedId).getNameEvent();
    	int index = 0;
    	int past = 0;
    	EventCell event = null;
    	for (EventCell e : listPastEvent) {
    		if (e.getNameEvent().equals(deletedEventName)) {
    			index = listPastEvent.indexOf(e);
    			event = e;
    		}
    	}
    	for (EventCell e : listFuturEvent) {
    		if (e.getNameEvent().equals(deletedEventName)) {
    			index = listFuturEvent.indexOf(e);
    			event = e;
    			past=+1;
    		}
    	}
    	//Get the index of the deleted Subject in lists
    	if (past != 0) {
    		//Remove the deleted Event to lists
        	listFuturEvent.remove(event);
        	listFuturEventId.remove(index);
    	} else {
    		//Remove the deleted Event to lists
        	listPastEvent.remove(event);
        	listPastEventId.remove(index);
    	}
		
		//Delete the Topic from the database
		eF.deleteEvent(eventSelectedId);
		
		//Update the Subjects ListView
		pastEvent.itemsProperty().bind(listPropertyPastEvents);
		listPropertyPastEvents.set(FXCollections.observableArrayList(listPastEvent));
		
		futurEvent.itemsProperty().bind(listPropertyFuturEvents);
		listPropertyFuturEvents.set(FXCollections.observableArrayList(listFuturEvent));
	
	}
	
}