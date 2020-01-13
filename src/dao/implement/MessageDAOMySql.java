package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    public ArrayList<Message> getMessageSentByReceiver(int id, int idEvent) {
    	ArrayList<Message> messages = new ArrayList<Message>();

		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM message WHERE idUserSender = " + id + " AND idEvent = " + idEvent);

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
    
    public Message getMessageById(int id) {
    	Message message = null;
    	try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM message WHERE idMessage = " + id);

			while (result.next()) {
				message = new Message(result.getInt("idMessage"), result.getString("objectMessage"),
						result.getString("contentMessage"), result.getInt("idUserSender"), result.getInt("idUserReceiver"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
    }

    public void sentMessage(int idFrom, int idTo, String messageObject, String messageContent, int idEvent) {
    	String sql = "INSERT INTO message VALUES (NULL, ?, ?, ?, ?, ?)";
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = this.connect.prepareStatement(sql);
			preparedStatement.setInt(1,idFrom);
			preparedStatement.setInt(2,idTo);
			preparedStatement.setInt(3,idEvent);
			preparedStatement.setString(4,messageContent);
			preparedStatement.setString(5,messageObject);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
    	String sql = "DELETE FROM message WHERE idMessage = ?";
		try {
			PreparedStatement preparedStatement = this.connect.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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