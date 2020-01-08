package dao.implement;

import java.sql.Connection;
import java.util.ArrayList;

import model.Event;

/*
 * 
 * @author lucadebeir
 * 
 */

public abstract class EventDAO {
	
	protected Connection connect = null;
	
    /**
     * Default constructor
     */
    public EventDAO(Connection conn) {
    	this.connect = conn;
    }
    
    public abstract void createEvent(Event obj);

	public abstract ArrayList<Event> getAllPastEventByIdStudent(int id);

	public abstract ArrayList<Event> getAllFuturEventByIdStudent(int id);
	
	public abstract ArrayList<Event> getAllEventByIdStudent(int id);
	
	public abstract Event findEventById(int id);
	
	public abstract void updateEvent(int idE, Event event);

	public abstract void deleteEvent(int idE);
}
