package facade;

import java.util.*;

import dao.AbstractDAOFactory;
import dao.implement.NotificationDAO;
import model.Notification;

/**
 * @author lucadebeir
 */
public class NotificationFacade {
	
	private AbstractDAOFactory factory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private NotificationDAO notifDAO = factory.createNotificationDAO();
	private Notification notif;

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
     * @return
     */
    public ArrayList<Notification> getNotificationsOfEvent(int idEvent) {
        // TODO implement here
        return notifDAO.getAllNotificationByIdEvent(idEvent);
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