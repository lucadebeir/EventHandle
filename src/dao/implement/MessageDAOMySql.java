package dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.Message;

/**
 * @author lucadebeir
 */
public class MessageDAOMySql extends MessageDAO {

    /**
     * Default constructor
     */
	public MessageDAOMySql(Connection conn) {
		super(conn);
	}
    
    public ArrayList<Message> getMessageOfReceiver(int id, int idEvent) {
    	ArrayList<Message> messages = new ArrayList<Message>();

		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM message WHERE idUserReceiver = " + id + " AND idEvent = " + idEvent);

			while (result.next()) {
				Message message = new Message(result.getInt("idMessage"), result.getString("objectMessage"),
						result.getString("contentMessage"), result.getInt("idUserSender"), result.getInt("idUserReceiver"));
				messages.add(message);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return messages;
    }


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