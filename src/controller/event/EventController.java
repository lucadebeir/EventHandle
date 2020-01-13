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
import javafx.scene.control.TextField;
import facade.ChatFacade;
import facade.EventFacade;
import facade.LoginFacade;
import facade.MessageFacade;
import facade.NotificationFacade;
import facade.exception.DisconnectedUserException;
import model.Chat;
import model.Event;
import model.Message;
import model.Notification;
import model.NotificationCell;
import ui.Router;

/*
 * @author lucadebeir
 */

public class EventController {
	
	@FXML private ListView<Chat> chatEvent;
	@FXML private ListView<Message> messageEvent;
	@FXML private ListView<NotificationCell> listNotifEvent;
	
	@FXML private Label nameEvent;
	@FXML private TextField cellTextField;
	
	int idEvent = (int) Router.getInstance().getParams()[0];
	
	EventFacade eF = null;
	NotificationFacade nF = null;
	MessageFacade mF = null;
	ChatFacade cF = null;
	LoginFacade lF = null;
	
	List<Notification> listNotifs;
	List<NotificationCell> listNotifsCell;
	ObservableList<NotificationCell> myNotifObservableList;
	protected ListProperty<NotificationCell> listPropertyNotifs = new SimpleListProperty<>();
	
	List<Message> listMessages;
	ObservableList<Message> myMessageObservableList;
	protected ListProperty<Message> listPropertyMessages = new SimpleListProperty<>();
	
	List<Chat> listChat;
	protected ListProperty<Chat> listPropertyChat = new SimpleListProperty<>();
	
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
		cF = new ChatFacade();
		lF = new LoginFacade();
		
		//initialisation du nom de l'event
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
    	
    	
    	
    	//initialisation des messages dans la tableView listMessageEvent
    	listMessages = mF.getMessageOfReceiver(idEvent);
    			
    	myMessageObservableList = FXCollections.observableArrayList();
    	
    	fetchListMessageView();
		updateListView();
    	
    	this.messageEvent.setCellFactory(messageListView -> new MessageListViewCell(false));
    	    	
    	
    	//initialisation des chat dans la tableview
		fetchListChatView();
    	
	}
	
	private void updateListView() {
    	myMessageObservableList.clear();
    	myMessageObservableList.addAll(listMessages);
		this.messageEvent.setItems(myMessageObservableList);
	}
	
	private void fetchListMessageView() throws DisconnectedUserException {
		listMessages = mF.getMessageOfReceiver(idEvent);
	}
	
	private void fetchListChatView() throws DisconnectedUserException {
		listChat = cF.getAllChatOfAnEvent(idEvent);
		
		this.chatEvent.setCellFactory(chatListView -> new ChatListViewCell());
		
		
		chatEvent.itemsProperty().bind(listPropertyChat);
		listPropertyChat.set(FXCollections.observableArrayList(listChat));
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
		
		Router.getInstance().activate("Resources", params);
	
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
	
	@FXML
	public void goToInbox() throws DisconnectedUserException, IOException {
		
		int idEvent = (int) Router.getInstance().getParams()[0];
		Object[] params = new Object[1];
		params[0] = idEvent;
		
		Router.getInstance().activate("Inbox", params);
		
	}
	
	@FXML
	public void addChat() throws DisconnectedUserException {
		String content = this.cellTextField.getText().toString();
    	this.cellTextField.clear();
    	
    	int idUser = LoginFacade.getInstance().getConnectedUser().getId();
    	Chat newChat = new Chat(content, idUser, idEvent);
    	cF.addMessageToChat(newChat);
    	
    	fetchListChatView();
	}

}
