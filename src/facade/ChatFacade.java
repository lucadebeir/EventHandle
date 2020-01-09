package facade;

import java.util.*;

import dao.AbstractDAOFactory;
import dao.implement.ChatDAO;
import model.Chat;

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
    private AbstractDAOFactory factory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);

    /**
     * 
     */
    private ChatDAO chatDAO = factory.createChatDAO();

    
    public ArrayList<Chat> getAllChatOfAnEvent(int idEvent) {
    	return chatDAO.getAllChatOfAnEvent(idEvent);
    }



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