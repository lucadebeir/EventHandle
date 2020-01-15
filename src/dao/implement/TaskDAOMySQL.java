package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import database.BdConnector;
import model.MyDate;
import model.Task;
import model.User;

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
			preparedStatement.executeUpdate();
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
	
	
	/**
	 * Get potential participants of a event 
	 * @param	idEvent of the Event
	 * @return	list of all task of the activity
	 */
	public List<User> getPotentialExecutor(int idEvent){
		List<User> lUser= new ArrayList<User>();
		String[] query = new String[3];
		query[0] = "select u.idUser,lastNameUser,firstNameUser,email,password FROM isvolunteer v, user u where v.idUser = u.idUser and v.idEvent = " + idEvent;
		query[1] = "select u.idUser,lastNameUser,firstNameUser,email,password FROM ismanager v, user u where v.idUser = u.idUser and v.idEvent = " + idEvent;
		query[2] = "select u.idUser,lastNameUser,firstNameUser,email,password FROM isintervener v, user u where v.idUser = u.idUser and v.idEvent = " + idEvent;
		User u;
		
		for(String q : query) {
			try {
			    ResultSet result = this.connect.createStatement(
			    ResultSet.TYPE_SCROLL_INSENSITIVE,
			    ResultSet.CONCUR_READ_ONLY).executeQuery(q);
			    while (result.next()) {
			    	int i = 0;
			    	u = new User(
					    	result.getInt("idUser"),
					        result.getString("lastNameUser"),
					        result.getString("firstNameUser"),
					        result.getString("email"),
					        result.getString("password"));
			    	if (!lUser.contains(u)) {
			    		lUser.add(u);
			    	}
			    }
			} catch (SQLException e) {
		  	    e.printStackTrace();
		  	}
		}
		
		return lUser;
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
	
	public int findIdEventTaskByID(int idTask) {
		String query = "select e.idEvent from event e, activity a, task t WHERE e.idEvent = a.idEvent and a.idActivity = t.idActivity and t.idTask =" + idTask;
		int res = -1;
		try {
			ResultSet result = this.connect.createStatement(
			  	    ResultSet.TYPE_SCROLL_INSENSITIVE,
			  	    ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			if(result.first()) {
				res = result.getInt("idEvent");
			}
		} catch (SQLException e) {
	  	    e.printStackTrace();
	  	  }
		return res;
	}
	
	public List<User> participantTask(int idTask){
		List<User> lUser= new ArrayList<User>();
		User u;
		String query = "select p.idUser, lastNameUser, firstNameUser , email, password, idTask from participatetask p, user u where p.idUser = u.idUser and p.idTask = " + idTask;
		try {
		    ResultSet result = this.connect.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE,
		    ResultSet.CONCUR_READ_ONLY).executeQuery(query);
		    while (result.next()) {
		    	u = new User(
				    	result.getInt("idUser"),
				        result.getString("lastNameUser"),
				        result.getString("firstNameUser"),
				        result.getString("email"),
				        result.getString("password"));
		    	lUser.add(u);
		    }
		} catch (SQLException e) {
	  	    e.printStackTrace();
	  	}
		return lUser;
    }
	
	public void addParticipant(int idUser,int idTask) {
    	String query = "INSERT INTO participatetask VALUES (" + idUser + "," + idTask + ")";
    	try {
        	this.connect.createStatement(
        			ResultSet.TYPE_SCROLL_INSENSITIVE,
        			ResultSet.CONCUR_READ_ONLY).executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteParticipant(int idUser,int idTask) {
		String query = "Delete from participatetask WHERE idTask = ? and idUser= ?";
        try {
			PreparedStatement preparedStatement = this.connect.prepareStatement(query);
			preparedStatement.setInt(1,idTask);
			preparedStatement.setInt(2,idUser);
			preparedStatement.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Task> getAllTaskOfOnUser(int idEvent, int idConnectedUser) {
		List<Task> list = new ArrayList<Task>();
		Task task;
		String sql = "SELECT * FROM task WHERE idTask IN (SELECT idTask FROM participatetask WHERE participatetask.idUser = ? AND participatetask.idTask IN "
				+ "(SELECT task.idTask FROM task WHERE task.idActivity IN (SELECT activity.idActivity FROM activity WHERE activity.idEvent = ?)))";
		try {
			PreparedStatement preparedStatement = this.connect.prepareStatement(sql);
			preparedStatement.setInt(1,idConnectedUser);
			preparedStatement.setInt(2, idEvent);
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()) {
				task = new Task(
				    	result.getInt("idTask"),
				    	result.getString("nameTask"),
				        new MyDate(result.getString("startDateTask")),
				        new MyDate(result.getString("endDateTask")),
				        result.getString("descriptionTask"),
				        result.getBoolean("statusTask"),
				        result.getInt("idActivity"));
				list.add(task);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public void setTaskStatus(int idTask, boolean statusTask) {
		String sql = "UPDATE task SET statusTask=? WHERE idTask=?";
		try {
			PreparedStatement preparedStatement = this.connect.prepareStatement(sql);
			preparedStatement.setBoolean(1, statusTask);
			preparedStatement.setInt(2,idTask);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Task t = findTask(idTask);
		int ide = findIdEventTaskByID(idTask);
		
		if(statusTask) {
			sql = "INSERT INTO notification VALUES (NULL, ?, 'La tâche est finie', ?)";
			try {
				PreparedStatement preparedStatement = this.connect.prepareStatement(sql);
				preparedStatement.setString(1, t.getTaskName());
				preparedStatement.setInt(2, ide);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}