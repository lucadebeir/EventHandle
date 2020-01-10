package dao.implement;

import java.sql.Connection;
import java.util.*;

import model.Message;

/**
 * @author lucadebeir
 */
public abstract class MessageDAO {

	protected Connection connect = null;
	
    /**
     * Default constructor
     */
    public MessageDAO(Connection conn) {
    	this.connect = conn;
    }
    
    public abstract ArrayList<Message> getMessageOfReceiver(int id, int idEvent);


    /**
     * @return
     */
    public Message createMessage() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Message updateMessage() {
        // TODO implement here
        return null;
    }

    /**
     * @param id
     */
    public void deleteMessage(int id) {
        // TODO implement here
    }

    /**
     * @param id 
     * @return
     */
    public Message getMessage(int id) {
        // TODO implement here
        return null;
    }

}