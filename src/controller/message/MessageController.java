package controller.message;

import java.sql.SQLException;
import java.util.List;

import controller.chat.ChatListViewCell;
import controller.event.MessageListViewCell;
import facade.LoginFacade;
import facade.MessageFacade;
import facade.exception.DisconnectedUserException;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import model.Message;
import model.MessageCell;
import ui.Router;

/**
 * @author lucadebeir
 */
public class MessageController {
	
	@FXML
	private ListView<Message> messageListView;
	
	@FXML
	private ListView<Message> messagesListView;
	
	int idEvent = (int) Router.getInstance().getParams()[0];
	
	MessageFacade mF = null;
	
	List<Message> listMessages;
	List<Message> listMessagesCell;
	ObservableList<Message> myMessageObservableList;
	//protected ListProperty<MessageCell> listPropertyMessages = new SimpleListProperty<>();

    /**
     * Default constructor
     */
    public MessageController() {
    }
    
    private void updateListView() {
    	myMessageObservableList.clear();
    	myMessageObservableList.addAll(listMessages);
		this.messageListView.setItems(myMessageObservableList);
	}
	
	private void fetchListMessageView() throws DisconnectedUserException {
		listMessages = mF.getMessageOfReceiver(idEvent);
	}
	
	@FXML
    public void initialize() throws SQLException, DisconnectedUserException {
		mF = new MessageFacade();
		
		myMessageObservableList = FXCollections.observableArrayList();
		
		fetchListMessageView();
		updateListView();
		
		this.messageListView.setCellFactory(messageListView -> new MessageListViewCell());
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
    	
    }
    
    @FXML
    public void sentMessage() {
    	
    }
    
    @FXML
    public void deleteMessage() {
    	
    }
    
    @FXML
    public void displayInbox() {
    	
    }
    
    @FXML
    public void displaySentMessage() {
    	
    }
 
}