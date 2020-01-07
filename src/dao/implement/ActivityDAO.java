package src.dao.implement;

import java.util.*;

import src.model.Activity;
import src.model.Task;
import src.database.BdConnector;
/**
 * 
 */
public abstract class ActivityDAO {

    /**
     * Default constructor
     */
    public ActivityDAO() {
    }


    /**
     * @param connect 
     * @return
     */
    public ActivityDAO ActivityDAO(BdConnector connect) {
        // TODO implement here
        return null;
    }

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