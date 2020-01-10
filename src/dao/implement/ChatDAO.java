package dao.implement;

import java.sql.Connection;
import java.util.*;

import model.Chat;

/**
 * 
 */
public abstract class ChatDAO {

    /**
     * Default constructor
     */
    public ChatDAO(Connection conn) {
    	this.connect = conn;
    }

    protected Connection connect = null;
    
    public abstract ArrayList<Chat> getAllChatOfAnEvent(int idEvent);
    
    public abstract void addMessageToChat(Chat newChat);
    
    /**
     * @return
     */
    public Chat createChat() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Chat updateChat() {
        // TODO implement here
        return null;
    }

    /**
     * @param id
     */
    public void deleteChat(int id) {
        // TODO implement here
    }

    /**
     * @param id 
     * @return
     */
    public Chat getChat(int id) {
        // TODO implement here
        return null;
    }

}