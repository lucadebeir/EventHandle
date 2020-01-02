package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Event;
import model.MyDate;

public class EventDAOMySQL extends EventDAO {
	
	/**
	 * Default constructor
	 */
	public EventDAOMySQL(Connection conn) {
		super(conn);
	}
	
	@Override
	public void createEvent(Event obj) {
		try {
			this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO event VALUES (NULL,'" + obj.getNameEvent() + "','" + obj.getDateStartEvent().getSQLDate() + "','" + obj.getLocationEvent() + "','" + obj.getDateEndEvent().getSQLDate() + "','" + obj.getDescriptionEvent() + "','" + obj.getIdCreator() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param idUser - the id of the connected user
	 * @return the list of past event of the connected user
	 */
	public ArrayList<Event> getAllPastEventByIdStudent(int idUser) {
		ArrayList<Event> events = new ArrayList<Event>();

		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM event WHERE idCreator = " + idUser + " AND dateStartEvent < NOW()");

			while (result.next()) {
				Event event = new Event(result.getInt("idEvent"), result.getString("nameEvent"), new MyDate(result.getString("dateStartEvent")),
						result.getString("locationEvent"), new MyDate(result.getString("dateEndEvent")), result.getString("descriptionEvent"),
						result.getInt("idCreator"));
				events.add(event);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return events;

	}
	
	public ArrayList<Event> getAllFuturEventByIdStudent(int idUser) {
		ArrayList<Event> events = new ArrayList<Event>();

		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM event WHERE idCreator = " + idUser + " AND dateStartEvent >= NOW()");

			while (result.next()) {
				Event event = new Event(result.getInt("idEvent"), result.getString("nameEvent"), new MyDate(result.getString("dateStartEvent")),
						result.getString("locationEvent"), new MyDate(result.getString("dateEndEvent")), result.getString("descriptionEvent"),
						result.getInt("idCreator"));
				events.add(event);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return events;
	}
	
	public ArrayList<Event> getAllEventByIdStudent(int idUser) {
		ArrayList<Event> events = new ArrayList<Event>();

		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM event WHERE idCreator = " + idUser);

			while (result.next()) {
				Event event = new Event(result.getInt("idEvent"), result.getString("nameEvent"), new MyDate(result.getString("dateStartEvent")),
						result.getString("locationEvent"), new MyDate(result.getString("dateEndEvent")), result.getString("descriptionEvent"),
						result.getInt("idCreator"));
				events.add(event);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return events;
	}
	
	public Event findEventById(int idE) {
		Event event = new Event(idE, null, null, null, null, null, 0);
	    try {
	  	    ResultSet result = this.connect.createStatement(
	  	    ResultSet.TYPE_SCROLL_INSENSITIVE,
	  	    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM event WHERE idEvent = " + idE);
	  	    if(result.first()) {
	  	    	event = new Event(result.getInt("idEvent"), result.getString("nameEvent"), new MyDate(result.getString("dateStartEvent")),
						result.getString("locationEvent"), new MyDate(result.getString("dateEndEvent")), result.getString("descriptionEvent"),
						result.getInt("idCreator"));     
	  	    }
	  	  } catch (SQLException e) {
	  	    e.printStackTrace();
	  	  }
	  	  return event;
	}
	
	@Override
	public void updateEvent(int idE, Event event) {
		String sql = "UPDATE event SET nameEvent = ?, dateStartEvent = ?, locationEvent = ?, dateEndEvent = ?, descriptionEvent = ? WHERE idEvent = ?";
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = this.connect.prepareStatement(sql);
			preparedStatement.setString(1,event.getNameEvent());
			preparedStatement.setString(2, event.getDateStartEvent().getSQLDate());
			preparedStatement.setString(3,event.getLocationEvent());
			preparedStatement.setString(4, event.getDateEndEvent().getSQLDate());
			preparedStatement.setString(5, event.getDescriptionEvent());
			preparedStatement.setInt(6, idE);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteEvent(int idE) {
		String sql = "DELETE FROM event WHERE idEvent = ?";
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = this.connect.prepareStatement(sql);
			preparedStatement.setInt(1, idE);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
