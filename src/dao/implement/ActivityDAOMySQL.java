package src.dao.implement;

import java.util.*;
import src.database.BdConnector;
import src.model.Activity;
import src.model.Task;

/**
 * 
 */
public class ActivityDAOMySQL extends ActivityDAO {

    /**
     * Default constructor
     */
    public ActivityDAOMySQL() {
    }

    /**
     * 
     */
    public BdConnector connect;

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
        // TODO implement here
        return null;
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
        // TODO implement here
        return null;
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