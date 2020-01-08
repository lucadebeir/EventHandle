package dao.implement;

import java.util.*;

import database.BdConnector;
import model.Task;

/**
 * 
 */
public abstract class TaskDAO {

    /**
     * Default constructor
     */
    public TaskDAO() {
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