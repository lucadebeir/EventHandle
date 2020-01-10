package dao.implement;

import java.sql.Connection;
import java.util.*;

import model.Notification;

/**
 * @author lucadebeir
 */
public abstract class NotificationDAO {

	protected Connection connect = null;
	
    /**
     * Default constructor
     */
    public NotificationDAO(Connection conn) {
    	this.connect = conn;
    }
	
    /**
     * Default constructor
     */
    public NotificationDAO() {
    }

    /**
     * @return
     */
    public Notification createNotification() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Notification updateNotification() {
        // TODO implement here
        return null;
    }

    /**
     * @param id
     */
    public void deleteNotification(int id) {
        // TODO implement here
    }

    /**
     * @param id 
     * @return
     */
    public Notification getNotification(int id) {
        // TODO implement here
        return null;
    }
    
    public abstract ArrayList<Notification> getAllNotificationByIdEvent(int idEvent);

}