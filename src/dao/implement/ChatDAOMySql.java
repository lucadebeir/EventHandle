package dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.BdConnector;
import model.Chat;
import model.Notification;

/**
 * @author lucadebeir
 */

public class ChatDAOMySql extends ChatDAO {

    /**
     * Default constructor
     */
	public ChatDAOMySql(Connection conn) {
		super(conn);
    }
	
	public ArrayList<Chat> getAllChatOfAnEvent(int idEvent) {
		ArrayList<Chat> chats = new ArrayList<Chat>();

		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM chat WHERE idEvent = " + idEvent);

			while (result.next()) {
				Chat chat = new Chat(result.getInt("idChat"), result.getString("contentMessage"),
						result.getInt("idUser"));
				chats.add(chat);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chats;
	}


    /**
     * @return
     */
    public Chat createChat() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Chat updateChat() {
        // TODO implement here
        return null;
    }

    /**
     * @param id
     */
    public void deleteChat(int id) {
        // TODO implement here
    }

    /**
     * @param id 
     * @return
     */
    public Chat getChat(int id) {
        // TODO implement here
        return null;
    }

}