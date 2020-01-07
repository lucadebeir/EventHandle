package src.facade;

import java.util.*;

import src.dao.AbstractDAOFactory;
import src.dao.implement.ChatDAO;
import src.model.Chat;

/**
 * 
 */
public class ChatFacade {

    /**
     * Default constructor
     */
    public ChatFacade() {
    }

    /**
     * 
     */
    private Set<Chat> chats;

    /**
     * 
     */
    private AbstractDAOFactory factory;

    /**
     * 
     */
    private ChatDAO chatDAO;




    /**
     * @return
     */
    public Chat getChats() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setChats(Chat value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public AbstractDAOFactory getAb() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setAb(AbstractDAOFactory value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public ChatDAO getChatDAO() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setChatDAO(ChatDAO value) {
        // TODO implement here
    }

}