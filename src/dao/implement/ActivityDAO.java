package dao.implement;

import java.sql.Connection;
import java.util.*;

import model.Activity;
import model.Task;
/**
 * 
 */
public abstract class ActivityDAO {
	
	protected Connection connect = null;

	/**
     * Default constructor
     */
	public ActivityDAO(Connection conn) {
		this.connect = conn;
	}
	
	/**
	 * Get all activity for a event 
	 * @param	idEvent of the event 
	 * @return	list of all activity of the event
	 */
	public abstract List<Activity> getListActivity(int idEvent);
	


    /**
     * @param obj 
     * @return
     */
    public void createActivity(Activity obj) {
        // TODO implement here
    }

    /**
     * @param id 
     * @return
     */
    public Activity findActivity(int id) {
		return null;
        // TODO implement here
       
    }

    /**
     * @param obj 
     * @return
     */
    public void updateActivity(Activity obj) {
        // TODO implement here
    }

    /**
     * @param obj 
     * @return
     */
    public void deleteActivity(Activity obj) {
        // TODO implement here
    }

    /**
     * @param a 
     * @return
     */
    public Set<Task> getTasks(Activity a) {
		return null;
        // TODO implement here
    }

    /**
     * @param a 
     * @param t 
     * @return
     */
    public void addTask(Activity a, Task t) {
        // TODO implement here
    }

}