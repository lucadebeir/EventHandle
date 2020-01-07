package src.dao.implement;

import java.util.*;

import src.database.BdConnector;
import src.model.Message;

/**
 * 
 */
public class MessageDAOMySql extends MessageDAO {

    /**
     * Default constructor
     */
    public MessageDAOMySql(BdConnector cnt) {
    }


    /**
     * 
     */
    public BdConnector connect;

    /**
     * @return
     */
    public Message createMassage() {
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