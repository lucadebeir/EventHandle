package src.dao.implement;

import java.util.*;

import src.database.BdConnector;
import src.model.Task;

/**
 * 
 */
public class TaskDAOMySQL extends TaskDAO {

    /**
     * Default constructor
     */
    public TaskDAOMySQL() {
    }

    /**
     * 
     */
    private BdConnector connect;

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
    public Task createTask() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Task updateTask() {
        // TODO implement here
        return null;
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
    public Task findTask(int id) {
        // TODO implement here
        return null;
    }

}