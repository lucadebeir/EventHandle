package dao.implement;

import java.sql.Connection;
import java.util.*;

import database.BdConnector;
import model.Activity;
import model.Task;
import model.User;

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
    
    public List<User> getPotentialExecutor(int event){
    	return null;
    }
    
    public int findIdEventTaskByID(int idTask) {
    	return -1;
    }
    
    public List<User> participantTask(int idTask){
    	return null;
    }
    
    public void deleteParticipant(int idUser,int idTask) {
    	
    }
    
    public void addParticipant(int idUser,int idTask) {
    	
    }
    
    public abstract List<Task> getListTask(int idActivity);

}