package dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import dao.implement.NotificationDAO;
import model.Notification;

/**
 * 
 * @author lucadebeir
 * 
 */

public class NotificationDAOMySql extends NotificationDAO {

    /**
     * Default constructor
     */
	public NotificationDAOMySql(Connection conn) {
		super(conn);
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

	public ArrayList<Notification> getAllNotificationByIdEvent(int idEvent) {
		// TODO Auto-generated method stub
		ArrayList<Notification> notifs = new ArrayList<Notification>();

		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM notification WHERE idEvent = " + idEvent);

			while (result.next()) {
				Notification notif = new Notification(result.getInt("idNotification"), result.getString("titleNotification"),
						result.getString("contentNotification"));
				notifs.add(notif);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notifs;
	}

}