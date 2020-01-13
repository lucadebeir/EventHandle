package dao.implement;

import java.util.*;
import model.Activity;
import model.Task;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 */
public class ActivityDAOMySQL extends ActivityDAO {

    
    public ActivityDAOMySQL(Connection conn) {
		super(conn);
	}
    
    /**
	 * Get all activity for a event 
	 * @param	idEvent of the event 
	 * @return	list of all activity of the event
	 */
	public List<Activity> getListActivity(int idEvent) {
		List<Activity> lActivity= new ArrayList<Activity>() ;
		String query = "SELECT * FROM Activity WHERE idEvent = " + idEvent;
		Activity activity = null;
		
		try {
		    ResultSet result = this.connect.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE,
		    ResultSet.CONCUR_READ_ONLY).executeQuery(query);
		    
		    while(result.next()) {
		    	activity = map(result);
		    	lActivity.add(activity);
		    }
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		return lActivity;
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
     * @return Activity
     */
    public Activity findActivity(int idActivity) {
    	Activity a = new Activity();
    	String query = "SELECT * FROM Activity WHERE idActivity = " + idActivity;
    	
    	try {
		    ResultSet result = this.connect.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE,
		    ResultSet.CONCUR_READ_ONLY).executeQuery(query);
		    
		    if(result.first()) {
		    	a = ActivityDAOMySQL.map(result);
		    }
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
		
       return a;
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
    
    /*
	 * Match/map a row in the table to the Activity bean
	 */
	private static Activity map(ResultSet resultSet ) throws SQLException {
	    Activity activity = new Activity();
	    activity.setIdActivity(resultSet.getInt("idActivity"));
	    activity.setNameActivity(resultSet.getString("nameActivity"));
	    activity.setDescriptionActivity(resultSet.getString("descriptionActivity"));
	    activity.setStatusActivity(resultSet.getInt("statusActivity") == 1);
	    activity.setIdEvent(resultSet.getInt("idEvent"));
	    return activity;
	}
    

}