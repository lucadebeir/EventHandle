package controller.chat;

import java.util.ArrayList;
import java.util.List;

import facade.ChatFacade;
import facade.LoginFacade;
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
	
	@FXML ListView<ChatCell> chatListView;
	@FXML TextArea chatContent;
	
	ChatFacade chF = null;
	LoginFacade lF = null;
	
	List<Chat> chatList;
	List<ChatCell> listChatsCell;
	ObservableList<ChatCell> chatObservableList;
	protected ListProperty<ChatCell> listPropertyChats = new SimpleListProperty<>();
	

    /**
     * Default constructor
     */
    public ChatController() {
    }    	
        
    @FXML
    private void close() {
    	int idEvent = (int) Router.getInstance().getParams()[0];
		Object[] params = new Object[1];
		params[0] = idEvent;
    	Router.getInstance().activate("Event", params);
    }
        
    @FXML
    public void initialize() {        	
	    chF = new ChatFacade();
	    lF = new LoginFacade();
        	
	    chatObservableList = FXCollections.observableArrayList();
	    
	    int idEvent = (int) Router.getInstance().getParams()[0];
	    chatList = chF.getAllChatOfAnEvent(idEvent);
	    
	    listChatsCell = new ArrayList<>();
	    
	    for (Chat chat : chatList) {
			ChatCell chCell = new ChatCell(lF.find(chat.getIdSender()).getFirstNameUser(), chat.getContentMessage());
			listChatsCell.add(chCell);
		}
        
        this.chatListView.setCellFactory(chatListView -> new ChatListViewCell(this));
        
        chatObservableList = FXCollections.observableArrayList();
        chatObservableList.addAll(listChatsCell);
		
		this.chatListView.setItems(chatObservableList);
    	this.chatListView.setCellFactory(chatListView -> new ChatListViewCell(this));
    	
    	chatListView.itemsProperty().bind(listPropertyChats);
    	listPropertyChats.set(FXCollections.observableArrayList(listChatsCell));
    }
    	
    @FXML
    public void addAnswer() {
    	String content = this.chatContent.getText();
    	this.chatContent.clear();
    	//chF.addAnswer(this.question.getId(), content);
    		
    	//fetchListAnswerView();
    	//updateListView();
   	}

}