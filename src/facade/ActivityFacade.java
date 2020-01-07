package src.facade;

import java.util.*;

import src.dao.AbstractDAOFactory;
import src.dao.implement.ActivityDAO;
import src.model.Activity;

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