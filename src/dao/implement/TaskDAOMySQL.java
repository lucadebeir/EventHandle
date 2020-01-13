package dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import database.BdConnector;
import model.Task;

/**
 * 
 */
public class TaskDAOMySQL extends TaskDAO {

    /**
     * Default constructor
     */
    public TaskDAOMySQL(Connection conn) {
    	super(conn);
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
    
    /**
	 * Get all task for a activity 
	 * @param	idActivity of the activity
	 * @return	list of all task of the activity
	 */
	public List<Task> getListTask(int idActivity){
		List<Task> lTask= new ArrayList<Task>();
		String query = "SELECT * FROM task WHERE idActivity = " + idActivity;
		Task task = null;
		
		try {
		    ResultSet result = this.connect.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE,
		    ResultSet.CONCUR_READ_ONLY).executeQuery(query);
		    
		    System.out.println(result);
		    while(result.next()) {
		    	task = map(result);
		    	lTask.add(task);
		    }
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		
		return lTask;
	}
	
	/*
	 * Match/map a row in the table to the Task bean
	 */
	private static Task map(ResultSet resultSet ) throws SQLException {
	    Task task = new Task();
	    task.setIdTask(resultSet.getInt("idTask"));
	    task.setTaskName(resultSet.getString("nameTask"));
	    task.setStartDateTask(resultSet.getDate("startDateTask"));
	    task.setEndDateTask(resultSet.getDate("endDateTask"));
	    task.setStatusTask(resultSet.getInt("statusTask") == 1);
	    task.setDescriptionTask(resultSet.getString("descriptionTask"));
	    task.setIdActivity(resultSet.getInt("idActivity"));
	    return task;
	}
	
}