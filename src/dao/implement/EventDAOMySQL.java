package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Event;
import model.MyDate;

/*
 * @author lucadebeir
 */

public class EventDAOMySQL extends EventDAO {
	
	/**
	 * Default constructor
	 */
	public EventDAOMySQL(Connection conn) {
		super(conn);
	}
	
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
		Event event;

		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM event WHERE idEvent IN (SELECT isManager.idEvent FROM isManager WHERE isManager.idUser = " + idUser + ") AND dateStartEvent < NOW()");
			while (result.next()) {
				event = new Event(result.getInt("idEvent"), result.getString("nameEvent"), new MyDate(result.getString("dateStartEvent")),
						result.getString("locationEvent"), new MyDate(result.getString("dateEndEvent")), result.getString("descriptionEvent"),
						result.getInt("idCreator"), "Manager");
				events.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM event WHERE idEvent IN (SELECT isVolunteer.idEvent FROM isVolunteer WHERE isVolunteer.idUser = " + idUser + ") AND dateStartEvent < NOW()");
			while (result.next()) {
				event = new Event(result.getInt("idEvent"), result.getString("nameEvent"), new MyDate(result.getString("dateStartEvent")),
						result.getString("locationEvent"), new MyDate(result.getString("dateEndEvent")), result.getString("descriptionEvent"),
						result.getInt("idCreator"), "Volunteer");
				events.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM event WHERE idEvent IN (SELECT isIntervener.idEvent FROM isIntervener WHERE isIntervener.idUser = " + idUser + ") AND dateStartEvent < NOW()");
			while (result.next()) {
				event = new Event(result.getInt("idEvent"), result.getString("nameEvent"), new MyDate(result.getString("dateStartEvent")),
						result.getString("locationEvent"), new MyDate(result.getString("dateEndEvent")), result.getString("descriptionEvent"),
						result.getInt("idCreator"), "Intervener");
				events.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return events;

	}
	
	public ArrayList<Event> getAllFuturEventByIdStudent(int idUser) {
		ArrayList<Event> events = new ArrayList<Event>();
		Event event;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM event WHERE idEvent IN (SELECT isManager.idEvent FROM isManager WHERE isManager.idUser = " + idUser + ") AND dateStartEvent >= NOW()");
			while (result.next()) {
				event = new Event(result.getInt("idEvent"), result.getString("nameEvent"), new MyDate(result.getString("dateStartEvent")),
						result.getString("locationEvent"), new MyDate(result.getString("dateEndEvent")), result.getString("descriptionEvent"),
						result.getInt("idCreator"), "Manager");
				events.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM event WHERE idEvent IN (SELECT isVolunteer.idEvent FROM isVolunteer WHERE isVolunteer.idUser = " + idUser + ") AND dateStartEvent >= NOW()");
			while (result.next()) {
				event = new Event(result.getInt("idEvent"), result.getString("nameEvent"), new MyDate(result.getString("dateStartEvent")),
						result.getString("locationEvent"), new MyDate(result.getString("dateEndEvent")), result.getString("descriptionEvent"),
						result.getInt("idCreator"), "Volunteer");
				events.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM event WHERE idEvent IN (SELECT isIntervener.idEvent FROM isIntervener WHERE isIntervener.idUser = " + idUser + ") AND dateStartEvent >= NOW()");
			while (result.next()) {
				event = new Event(result.getInt("idEvent"), result.getString("nameEvent"), new MyDate(result.getString("dateStartEvent")),
						result.getString("locationEvent"), new MyDate(result.getString("dateEndEvent")), result.getString("descriptionEvent"),
						result.getInt("idCreator"), "Intervener");
				events.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return events;
	}
	
	public ArrayList<Event> getAllEventByIdStudent(int idUser) {
		ArrayList<Event> events = new ArrayList<Event>();
		Event event;

		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM event WHERE idEvent IN (SELECT isManager.idEvent FROM isManager WHERE isManager.idUser = " + idUser + ")");
			while (result.next()) {
				event = new Event(result.getInt("idEvent"), result.getString("nameEvent"), new MyDate(result.getString("dateStartEvent")),
						result.getString("locationEvent"), new MyDate(result.getString("dateEndEvent")), result.getString("descriptionEvent"),
						result.getInt("idCreator"), "Manager");
				events.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM event WHERE idEvent IN (SELECT isVolunteer.idEvent FROM isVolunteer WHERE isVolunteer.idUser = " + idUser + ")");
			while (result.next()) {
				event = new Event(result.getInt("idEvent"), result.getString("nameEvent"), new MyDate(result.getString("dateStartEvent")),
						result.getString("locationEvent"), new MyDate(result.getString("dateEndEvent")), result.getString("descriptionEvent"),
						result.getInt("idCreator"), "Volunteer");
				events.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM event WHERE idEvent IN (SELECT isIntervener.idEvent FROM isIntervener WHERE isIntervener.idUser = " + idUser + ")");
			while (result.next()) {
				event = new Event(result.getInt("idEvent"), result.getString("nameEvent"), new MyDate(result.getString("dateStartEvent")),
						result.getString("locationEvent"), new MyDate(result.getString("dateEndEvent")), result.getString("descriptionEvent"),
						result.getInt("idCreator"), "Intervener");
				events.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return events;
	}
	
	public Event findEventById(int idE) {
		Event event = new Event(idE, null, null, null, null, null, 0, null);
	    try {
	  	    ResultSet result = this.connect.createStatement(
	  	    ResultSet.TYPE_SCROLL_INSENSITIVE,
	  	    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM event WHERE idEvent = " + idE);
	  	    if(result.first()) {
	  	    	ResultSet result2 = this.connect
						.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
						.executeQuery("SELECT * FROM isManager WHERE idUser = " + result.getInt("idCreator") + " AND idEvent = " + result.getInt("idEvent"));
				if (result2.first()) {
					event = new Event(result.getInt("idEvent"), result.getString("nameEvent"), new MyDate(result.getString("dateStartEvent")),
							result.getString("locationEvent"), new MyDate(result.getString("dateEndEvent")), result.getString("descriptionEvent"),
							result.getInt("idCreator"), "Manager");
				} else {
					ResultSet result3 = this.connect
							.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
							.executeQuery("SELECT * FROM isVolunteer WHERE idUser = " + result.getInt("idCreator") + " AND idEvent = " + result.getInt("idEvent"));
					if (result3.first()) {
						event = new Event(result.getInt("idEvent"), result.getString("nameEvent"), new MyDate(result.getString("dateStartEvent")),
								result.getString("locationEvent"), new MyDate(result.getString("dateEndEvent")), result.getString("descriptionEvent"),
								result.getInt("idCreator"), "Volunteer");
					} else {
						ResultSet result4 = this.connect
								.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
								.executeQuery("SELECT * FROM isIntervener WHERE idUser = " + result.getInt("idCreator") + " AND idEvent = " + result.getInt("idEvent"));
						if (result4.first()) {
							event = new Event(result.getInt("idEvent"), result.getString("nameEvent"), new MyDate(result.getString("dateStartEvent")),
									result.getString("locationEvent"), new MyDate(result.getString("dateEndEvent")), result.getString("descriptionEvent"),
									result.getInt("idCreator"), "Intervener");
						} else {
							event = new Event(result.getInt("idEvent"), result.getString("nameEvent"), new MyDate(result.getString("dateStartEvent")),
									result.getString("locationEvent"), new MyDate(result.getString("dateEndEvent")), result.getString("descriptionEvent"),
									result.getInt("idCreator"), "");
						}
					}
				}     
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
