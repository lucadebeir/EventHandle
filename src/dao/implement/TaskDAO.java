package dao.implement;

import java.sql.Connection;
import java.util.*;

import database.BdConnector;
import model.Activity;
import model.Task;

/**
 * 
 */
public abstract class TaskDAO {
	
	protected Connection connect = null;

    /**
     * Default constructor
     */
    public TaskDAO(Connection conn) {
    	this.connect = conn;
    }

    /**
     * @param connect 
     * @return
     */
    public TaskDAO TaskDAO(BdConnector connect) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public abstract int createTask(Task t);

    /**
     * @return
     */
    public void updateTask(Task t) {
        // TODO implement here
    }

    /**
     * @param id
     */
    public void deleteTask(int id) {
        // TODO implement here
    }

    /**
     * @param id 
     * @return
     */
    public Task findTask(int idTask) {
        // TODO implement here
        return null;
    }
    
    public abstract List<Task> getListTask(int idActivity);

}