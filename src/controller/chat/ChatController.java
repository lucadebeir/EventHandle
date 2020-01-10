package controller.chat;

import java.util.List;

import facade.ChatFacade;
import facade.LoginFacade;
import facade.exception.DisconnectedUserException;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import model.*;
import ui.Router;

/**
 * @author lucadebeir
 */
public class ChatController {
	
	@FXML ListView<Chat> chatListView;
	@FXML TextArea messageArea;
	
	ChatFacade chF = null;
	LoginFacade lF = null;
	
	List<Chat> chatList;
	ObservableList<Chat> chatObservableList;
	protected ListProperty<Chat> listPropertyChats = new SimpleListProperty<>();
	
	int idEvent = (int) Router.getInstance().getParams()[0];
	

    /**
     * Default constructor
     */
    public ChatController() {
    }    	
        
    @FXML
    private void goBack() {
    	int idEvent = (int) Router.getInstance().getParams()[0];
		Object[] params = new Object[1];
		params[0] = idEvent;
    	Router.getInstance().activate("Event", params);
    }
        
    @FXML
    public void initialize() {        	
	    chF = new ChatFacade();
	    
	    chatObservableList = FXCollections.observableArrayList();
	    
	    fetchListChatView();
    	updateListView();
    	
    	this.chatListView.setCellFactory(chatListView -> new ChatListViewCell());
	    
    }
    	
    @FXML
    public void addMessageToChat() throws DisconnectedUserException {
    	String content = this.messageArea.getText().toString();
    	this.messageArea.clear();
    	
    	int idUser = LoginFacade.getInstance().getConnectedUser().getId();
    	Chat newChat = new Chat(content, idUser, idEvent);
    	chF.addMessageToChat(newChat);
    		
    	fetchListChatView();
    	updateListView();
   	}
    
    private void updateListView () {
    	chatObservableList.clear();
    	chatObservableList.addAll(chatList);
		this.chatListView.setItems(chatObservableList);
		
	}
	
	private void fetchListChatView() {
		chatList = this.chF.getAllChatOfAnEvent(idEvent);
    	
	}

}