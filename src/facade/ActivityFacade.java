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
    public List<Activity> getListActivity(){
    	return activityDAO.getListActivity(3);
    }
    
    // TO DO
    public Activity getActivityById(int id) {
    	return activityDAO.findActivity(id);
    }

    /**
     * 
     */
    public AbstractDAOFactory factory;

    /**
     * 
     */
    private Set<Activity> activitys;



}