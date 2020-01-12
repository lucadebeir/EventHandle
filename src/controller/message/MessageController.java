package controller.message;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.chat.ChatListViewCell;
import controller.event.MessageListViewCell;
import controller.event.UpdateEvent;
import facade.LoginFacade;
import facade.MessageFacade;
import facade.exception.DisconnectedUserException;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Event;
import model.Message;
import model.MessageCell;
import ui.Router;

/**
 * @author lucadebeir
 */
public class MessageController {
	
	@FXML Button buttonDelete;
	@FXML Button buttonAnswer;
	
	@FXML
	private ListView<Message> messageListView;
	
	@FXML
	private ListView<Message> messagesListView;
	
	int idEvent = (int) Router.getInstance().getParams()[0];
	
	private int messageSelectedId = -1;
	Message selectMessage;
	
	MessageFacade mF = null;
	
	List<Message> listMessages = new ArrayList<Message>();
	protected List<Integer> listMessagesId = new ArrayList<>();
	List<Message> listMessage = new ArrayList<Message>();
	
	List<Message> listMessagesSent = new ArrayList<Message>();
	
	protected ListProperty<Message> listPropertyMessages = new SimpleListProperty<>();
	protected ListProperty<Message> listPropertyMessage = new SimpleListProperty<>();
	protected ListProperty<Message> listPropertyMessagesSent = new SimpleListProperty<>();

    /**
     * Default constructor
     */
    public MessageController() {
    }
	
	private void fetchMessagesListView() throws DisconnectedUserException {
		listMessages = mF.getMessageOfReceiver(idEvent);
	}
	
	private void fetchMessagesSentListView() throws DisconnectedUserException {
		listMessagesSent = mF.getMessageSentByReceiver(idEvent);
	}
	
	@FXML
    public void initialize() throws SQLException, DisconnectedUserException {
		mF = new MessageFacade();
				
		listMessagesId.clear();
		messagesListView.itemsProperty().bind(listPropertyMessages);
		listPropertyMessages.set(FXCollections.observableArrayList());
		
		fetchMessagesListView();
		
		this.messagesListView.setCellFactory(messageListView -> new MessageListViewCell(false));
		
		for (Message message : listMessages) {
			listMessagesId.add(message.getIdMessage());
		}
		
		messagesListView.itemsProperty().bind(listPropertyMessages);
		listPropertyMessages.set(FXCollections.observableArrayList(listMessages));
		
		buttonAnswer.setDisable(true);
		buttonDelete.setDisable(true);
		
		//To know the selected past event
    	ChangeListener listenerMessage = new ChangeListener<Object>() {  
    		@Override
    		public void changed(ObservableValue arg0, Object arg1, Object arg2) {
    			// TODO Auto-generated method stub
    			
    			listMessage.clear();
    			messageListView.itemsProperty().bind(listPropertyMessage);
    			listPropertyMessage.set(FXCollections.observableArrayList());
    			    			
				messageSelectedId = listMessagesId.get(messagesListView.getSelectionModel().getSelectedIndex());
				//Get update and delete buttons visible
				selectMessage = mF.getMessageById(messageSelectedId);
				listMessage.add(selectMessage);
				
				messageListView.itemsProperty().bind(listPropertyMessage);
				listPropertyMessage.set(FXCollections.observableArrayList(listMessage));	
				
				messageListView.setCellFactory(messageListView -> new MessageInboxListView(false));
				
				buttonAnswer.setDisable(false);
				buttonDelete.setDisable(false);
					
    		}  
    	}; 
    				
    	//Listener for selecting a Subject in the ListView
    	messagesListView.getSelectionModel().selectedIndexProperty().addListener(
    		listenerMessage
    	);
		
	}
    
    @FXML
    public void goBackToEvent() {
    	int idEvent = (int) Router.getInstance().getParams()[0];
		Object[] params = new Object[1];
		params[0] = idEvent;
    	Router.getInstance().activate("Event", params);
    }
    
    @FXML
    public void goAnswer() {
    	Stage nextStage = new Stage();
		nextStage.setTitle("Sent an answer");
		Parent myPane = null;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/event/message/SentAnswer.fxml"));
			SentAnswer controller = new SentAnswer();
			loader.setController(controller);
			controller.init(messageSelectedId);
			myPane = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		Scene scene = new Scene(myPane);
		nextStage.setScene(scene);
		nextStage.show();
    }
    
    @FXML
    public void sentMessage() {
    	Stage nextStage = new Stage();
		nextStage.setTitle("Sent a message");
		Pane myPane = null;
		try {
			myPane = FXMLLoader.load(getClass().getResource("/ui/event/message/SentMessage.fxml"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		Scene scene = new Scene(myPane);
		nextStage.setScene(scene);
		nextStage.show();
    }
    
    @FXML
    public void deleteMessage() throws DisconnectedUserException {
    	int index = 0;
    	Message message = null;
    	for (Message m : listMessages) {
    		if (m.getIdMessage()==(messageSelectedId)) {
    			index = listMessages.indexOf(m);
    			message = m;
    		}
    	}
    	listMessages.remove(message);
    	listMessagesId.remove(index);
    	mF.deleteMessage(messageSelectedId);
    	fetchMessagesListView();
    	
    	this.messagesListView.setCellFactory(messageListView -> new MessageListViewCell(false));
		
		for (Message m : listMessages) {
			//EventCell eventCell = new EventCell(event.getNameEvent(), event.getDateStartEvent(), event.getDateEndEvent(), event.getLocationEvent());
			listMessagesId.add(m.getIdMessage());
		}
		
		messagesListView.itemsProperty().bind(listPropertyMessages);
		listPropertyMessages.set(FXCollections.observableArrayList(listMessages));
		
		listMessage.clear();
		
		messageListView.itemsProperty().bind(listPropertyMessage);
		listPropertyMessage.set(FXCollections.observableArrayList(listMessage));	
		
		buttonAnswer.setDisable(true);
		buttonDelete.setDisable(true);
    	
    }
    
    @FXML
    public void displayInbox() throws SQLException, DisconnectedUserException {
    	initialize();
    }
    
    @FXML
    public void displaySentMessage() throws DisconnectedUserException {
    	mF = new MessageFacade();
    	    	
    	listMessagesId.clear();
    	messagesListView.itemsProperty().bind(listPropertyMessagesSent);
		listPropertyMessagesSent.set(FXCollections.observableArrayList());
		
		fetchMessagesSentListView();
		
		this.messagesListView.setCellFactory(messageListView -> new MessageListViewCell(true));
		
		for (Message message : listMessagesSent) {
			listMessagesId.add(message.getIdMessage());
		}
		
		messagesListView.itemsProperty().bind(listPropertyMessagesSent);
		listPropertyMessagesSent.set(FXCollections.observableArrayList(listMessagesSent));
		
		buttonAnswer.setDisable(true);
		buttonDelete.setDisable(true);
		
		//To know the selected past event
    	ChangeListener listenerMessageSent = new ChangeListener<Object>() {  
    		@Override
    		public void changed(ObservableValue arg0, Object arg1, Object arg2) {
    			// TODO Auto-generated method stub
    			
    			listMessage.clear();
    			messageListView.itemsProperty().bind(listPropertyMessage);
    			listPropertyMessage.set(FXCollections.observableArrayList());
    			    			
				messageSelectedId = listMessagesId.get(messagesListView.getSelectionModel().getSelectedIndex());
				//Get update and delete buttons visible
				selectMessage = mF.getMessageById(messageSelectedId);
				listMessage.add(selectMessage);
				
				messageListView.itemsProperty().bind(listPropertyMessage);
				listPropertyMessage.set(FXCollections.observableArrayList(listMessage));	
				
				messageListView.setCellFactory(messageListView -> new MessageInboxListView(true));
				
				buttonAnswer.setDisable(false);
				buttonDelete.setDisable(false);
					
    		}  
    	}; 
    				
    	//Listener for selecting a Subject in the ListView
    	messagesListView.getSelectionModel().selectedIndexProperty().addListener(
    		listenerMessageSent
    	);
    }
 
}