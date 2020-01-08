package dao.implement;

import database.BdConnector;
import model.Chat;

/**
 * 
 */
public class ChatDAOMySql extends ChatDAO {

    /**
     * Default constructor
     */
	public ChatDAOMySql(BdConnector cnt) {
    }

    /**
     * 
     */
    public BdConnector connector;


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