package src.facade;

import java.util.*;

import src.dao.AbstractDAOFactory;
import src.dao.implement.NotificationDAO;
import src.model.Notification;

/**
 * 
 */
public class NotificationFacade {

    /**
     * Default constructor
     */
    public NotificationFacade() {
    }

    /**
     * 
     */
    private Set<Notification> notifications;

    /**
     * 
     */
    private NotificationDAO notificationDAO;

    /**
     * 
     */
    private AbstractDAOFactory factory;




    /**
     * @return
     */
    public Notification getNotifications() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setNotifications(Notification value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public NotificationDAO getNotificationDAO() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setNotificationDAO(NotificationDAO value) {
        // TODO implement here
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

}