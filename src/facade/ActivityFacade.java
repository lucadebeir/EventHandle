package facade;

import java.util.*;

import dao.AbstractDAOFactory;
import dao.implement.ActivityDAO;
import model.Activity;

/**
 * 
 */
public class ActivityFacade {

    /**
     * Default constructor
     */
    public ActivityFacade() {
    }

    /**
     * 
     */
    public AbstractDAOFactory factory;

    /**
     * 
     */
    private Set<Activity> activitys;

    /**
     * 
     */
    private ActivityDAO activityDAO;




    /**
     * @return
     */
    public ActivityFacade getInstance() {
        // TODO implement here
        return null;
    }

}