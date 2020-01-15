package facade;

import java.util.*;

import dao.AbstractDAOFactory;
import dao.implement.ActivityDAO;
import model.Activity;

/**
 * 
 */
public class ActivityFacade {
	
	private AbstractDAOFactory af = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private ActivityDAO activityDAO = af.createActivityDAO();
	// add attribute to get eventDAO
	
	/** Holder */
    private static class SingletonHolder
    {       
        /** Instance unique non préinitialisée */
        private final static ActivityFacade instance = new ActivityFacade();
    }

    /**
     * Default constructor
     */
    public ActivityFacade() {
    }
    
    /** Point d'accès pour l'instance unique du singleton */
    public static ActivityFacade getInstance()
    {
        return SingletonHolder.instance;
    }
    
    // TO DO : change idEvent !
    public List<Activity> getListActivity(int id){
    	return activityDAO.getListActivity(id);
    }
    
    // TO DO
    public Activity getActivityById(int id) {
    	return activityDAO.findActivity(id);
    }

    public void addActivity(String name, String description,int idEvent) {
    	Activity a = new Activity(0,name,description,false,idEvent);
    	activityDAO.createActivity(a);
    }

    /**
     * 
     */
    private Set<Activity> activitys;



}