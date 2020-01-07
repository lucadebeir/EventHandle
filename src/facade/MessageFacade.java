package src.facade;

import java.util.*;

import src.dao.AbstractDAOFactory;
import src.dao.implement.MessageDAO;
import src.model.Message;

/**
 * 
 */
public class MessageFacade {

    /**
     * Default constructor
     */
    public MessageFacade() {
    }

    /**
     * 
     */
    private AbstractDAOFactory factory;

    /**
     * 
     */
    private Set<Message> messages;

    /**
     * 
     */
    private MessageDAO messageDao;




    /**
     * @return
     */
    public AbstractDAOFactory getAf() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setAf(AbstractDAOFactory value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Message getMessages() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setMessages(Message value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public MessageDAO getMessageDao() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setMessageDao(MessageDAO value) {
        // TODO implement here
    }

}