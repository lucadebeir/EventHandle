package facade;

import java.util.*;

import dao.AbstractDAOFactory;
import dao.implement.MessageDAO;
import facade.exception.DisconnectedUserException;
import model.Message;

/**
 * @author lucadebeir
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
    private AbstractDAOFactory factory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);

    /**
     * 
     */
    private Set<Message> messages;

    /**
     * 
     */
    private MessageDAO messageDAO = factory.createMessageDAO();


    public ArrayList<Message> getMessageOfReceiver(int id) throws DisconnectedUserException {
    	int idReceiver = LoginFacade.getInstance().getConnectedUser().getId();
    	return messageDAO.getMessageOfReceiver(idReceiver,id);
    }


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