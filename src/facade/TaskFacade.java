package src.facade;

import java.util.*;

import src.dao.AbstractDAOFactory;
import src.dao.implement.TaskDAO;
import src.model.Task;

/**
 * 
 */
public class TaskFacade {

    /**
     * Default constructor
     */
    public TaskFacade() {
    }

    /**
     * 
     */
    private AbstractDAOFactory factory;

    /**
     * 
     */
    private Set<Task> tasks;

    /**
     * 
     */
    private TaskDAO taskDAO;




}