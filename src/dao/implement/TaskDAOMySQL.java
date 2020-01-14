package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import database.BdConnector;
import model.MyDate;
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
    public int createTask(Task t) {
    	int idTask = -1;
    	String query = "INSERT INTO task VALUES (NULL,'" + t.getTaskName() + "','" + t.getStartDateTask().getSQLDate() + "','" + t.getEndDateTask().getSQLDate() + "','" + t.getDescriptionTask() + "', 0,'" + t.getIdActivity() + "')";
    	System.out.println(query);
        try {
        	this.connect.createStatement(
        			ResultSet.TYPE_SCROLL_INSENSITIVE,
        			ResultSet.CONCUR_READ_ONLY).executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return idTask;
    }

    /**
     * @return
     */
    public void updateTask(Task t) {
        // TODO implement here
        String query = "UPDATE task SET nameTask = ?, startDateTask = ?, endDateTask = ?, descriptionTask = ?, statusTask = ? WHERE idTask = ?";
        try {
			PreparedStatement preparedStatement = this.connect.prepareStatement(query);
			preparedStatement.setString(1,t.getTaskName());
			preparedStatement.setString(2,t.getStartDateTask().getSQLDate());
			preparedStatement.setString(3,t.getEndDateTask().getSQLDate());
			preparedStatement.setString(4,t.getDescriptionTask());
			preparedStatement.setInt(5,t.isStatusTask() ? 1 : 0);
			preparedStatement.setInt(6,t.getIdTask());
        } catch (SQLException e) {
			e.printStackTrace();
		}
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
    	String query = "SELECT * FROM task WHERE idTask = " + idTask;
		Task task = null;
		try {
			ResultSet result = this.connect.createStatement(
			  	    ResultSet.TYPE_SCROLL_INSENSITIVE,
			  	    ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			if(result.first()) {
				task = map(result);
			}
		} catch (SQLException e) {
	  	    e.printStackTrace();
	  	  }
		return task;
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
	    task.setStartDateTask(new MyDate(resultSet.getDate("startDateTask").toString()));
	    task.setEndDateTask(new MyDate(resultSet.getDate("endDateTask").toString()));
	    task.setStatusTask(resultSet.getInt("statusTask") == 1);
	    task.setDescriptionTask(resultSet.getString("descriptionTask"));
	    task.setIdActivity(resultSet.getInt("idActivity"));
	    return task;
	}
	
}