package facade;

import model.User;
import model.Event;
import model.MyDate;
import facade.LoginFacade;
import facade.exception.DisconnectedUserException;
import java.util.ArrayList;
import dao.AbstractDAOFactory;
import dao.implement.EventDAO;

/**
 * 
 * @author lucadebeir
 *
 */

public class EventFacade {
	
	private AbstractDAOFactory factory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private EventDAO eventDAO = factory.createEventDAO();
	private Event event;
	
	/**
	 * Add an event
	 * @param nameEvent, locationEvent, descriptionEvent, dateStart, dateEnd
	 * @return
	 * @throws DisconnectedUserException
	 */
	public void addEvent(String nameEvent, String locationEvent, String descriptionEvent, MyDate dateStart, MyDate dateEnd) throws DisconnectedUserException {
		int idCreator = LoginFacade.getInstance().getConnectedUser().getId();
		event = new Event(0, nameEvent, dateStart, locationEvent, dateEnd, descriptionEvent, idCreator);
		eventDAO.createEvent(event);
	}
	
	/**
	 * Get all the past events
	 * @param idUser
	 * @return 
	 * @throws DisconnectedUserException 
	 */
	public ArrayList<Event> getAllPastEventConnectedUser() throws DisconnectedUserException {
		User co = LoginFacade.getInstance().getConnectedUser();
		return eventDAO.getAllPastEventByIdStudent(co.getId());
	}
	
	/**
	 * Get all the futur events
	 * @param idUser
	 * @return 
	 * @throws DisconnectedUserException 
	 */
	public ArrayList<Event> getAllFuturEventConnectedUser() throws DisconnectedUserException {
		User co = LoginFacade.getInstance().getConnectedUser();
		return eventDAO.getAllFuturEventByIdStudent(co.getId());
	}
	
	/**
	 * Get all the events
	 * @param idUser
	 * @return 
	 * @throws DisconnectedUserException 
	 */
	public ArrayList<Event> getAllEventConnectedUser() throws DisconnectedUserException {
		User co = LoginFacade.getInstance().getConnectedUser();
		return eventDAO.getAllEventByIdStudent(co.getId());
	}
	
	/**
	 * Get all the event
	 * @param idE
	 * @return 
	 */
	public Event findEventById(int idE) {
		Event e = eventDAO.findEventById(idE);
		return e;
	}
	
	/**
	 * Update an event
	 * @param idE, Event
	 * @return 
	 */
	public void updateEvent(int idE, Event event) {
		eventDAO.updateEvent(idE, event);
	}
	
	/**
	 * Delete a Topic with an ID
	 * @param id the id of the researched Topic
	 */
	public void deleteEvent(int id) {
		eventDAO.deleteEvent(id);
	}
	
	

}
