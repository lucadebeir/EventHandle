package controller.event;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import facade.EventFacade;
import facade.LoginFacade;
import facade.MessageFacade;
import facade.NotificationFacade;
import facade.exception.DisconnectedUserException;
import model.Chat;
import model.Event;
import model.Message;
import model.MessageCell;
import model.Notification;
import model.NotificationCell;
import ui.Router;

public class EventController {
	
	@FXML private ListView<Chat> chatEvent;
	@FXML private ListView<MessageCell> messageEvent;
	@FXML private ListView<NotificationCell> listNotifEvent;
	
	@FXML private Label nameEvent;
	
	EventFacade eF = null;
	NotificationFacade nF = null;
	MessageFacade mF = null;
	LoginFacade lF = null;
	
	List<Notification> listNotifs;
	List<NotificationCell> listNotifsCell;
	ObservableList<NotificationCell> myNotifObservableList;
	protected ListProperty<NotificationCell> listPropertyNotifs = new SimpleListProperty<>();
	
	List<Message> listMessages;
	List<MessageCell> listMessagesCell;
	ObservableList<MessageCell> myMessageObservableList;
	protected ListProperty<MessageCell> listPropertyMessages = new SimpleListProperty<>();
	
	/**
     * Default constructor
     */
	public EventController() {
	}
	
	@FXML
    public void initialize() throws SQLException, DisconnectedUserException {
		eF = new EventFacade();
		nF = new NotificationFacade();
		mF = new MessageFacade();
		lF = new LoginFacade();
		
		//initialisation du nom de l'event
		int idEvent = (int) Router.getInstance().getParams()[0];
		Event event = eF.findEventById(idEvent);
		this.nameEvent.setText(event.getNameEvent());
		this.nameEvent.setWrapText(true);
		
		//initialisation des notifications dans la tableView listNotifEvent
		listNotifs = nF.getNotificationsOfEvent(idEvent);
		
		listNotifsCell = new ArrayList<>();
		
		for (Notification notif : listNotifs) {
			NotificationCell nCell = new NotificationCell(notif.getTitleMessage(), notif.getContentMessage());
			listNotifsCell.add(nCell);
		}
		
		myNotifObservableList = FXCollections.observableArrayList();
		myNotifObservableList.addAll(listNotifsCell);
		
		this.listNotifEvent.setItems(myNotifObservableList);
    	this.listNotifEvent.setCellFactory(notifListView -> new NotificationListViewCell());
    	
    	listNotifEvent.itemsProperty().bind(listPropertyNotifs);
    	listPropertyNotifs.set(FXCollections.observableArrayList(listNotifsCell));
    	
    	
    	
    	//initialisation des notifications dans la tableView listMessageEvent
    	listMessages = mF.getMessageOfReceiver(idEvent);
    			
    	listMessagesCell = new ArrayList<>();
    			
    	for (Message message : listMessages) {
    		MessageCell mCell = new MessageCell(lF.find(message.getIdSender()).getFirstNameUser(), message.getTitleMessage());
    		listMessagesCell.add(mCell);
    	}
    			
    	myMessageObservableList = FXCollections.observableArrayList();
    	myMessageObservableList.addAll(listMessagesCell);
    			
    	this.messageEvent.setItems(myMessageObservableList);
    	this.messageEvent.setCellFactory(messageListView -> new MessageListViewCell());
    	    	
    	messageEvent.itemsProperty().bind(listPropertyMessages);
    	listPropertyMessages.set(FXCollections.observableArrayList(listMessagesCell));
    	
	}
	
	@FXML
	private void backToMyEvents() {
    	Router.getInstance().activate("HomePage");

	}
	
	@FXML
	public void goToCollaborators() throws DisconnectedUserException, IOException {
	
		int idEvent = (int) Router.getInstance().getParams()[0];
		Object[] params = new Object[1];
		params[0] = idEvent;
		
		Router.getInstance().activate("ListOfCollaborators", params);
	
	}
	
	@FXML
	public void goToActivities() throws DisconnectedUserException, IOException {
	
		int idEvent = (int) Router.getInstance().getParams()[0];
		Object[] params = new Object[1];
		params[0] = idEvent;
		
		Router.getInstance().activate("ListOfActivities", params);
	
	}
	
	@FXML
	public void goToResources() throws DisconnectedUserException, IOException {
	
		int idEvent = (int) Router.getInstance().getParams()[0];
		Object[] params = new Object[1];
		params[0] = idEvent;
		
		Router.getInstance().activate("ListOfResources", params);
	
	}
	
	@FXML
	public void goToSponsors() throws DisconnectedUserException, IOException {
	
		int idEvent = (int) Router.getInstance().getParams()[0];
		Object[] params = new Object[1];
		params[0] = idEvent;
		
		Router.getInstance().activate("ListOfSponsors", params);
	
	}
	
	@FXML
	public void goToChat() throws DisconnectedUserException, IOException {
		
		int idEvent = (int) Router.getInstance().getParams()[0];
		Object[] params = new Object[1];
		params[0] = idEvent;
		
		Router.getInstance().activate("Chat", params);
		
	}

}
