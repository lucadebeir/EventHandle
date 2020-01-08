package facade;

import java.util.*;

import dao.AbstractDAOFactory;
import dao.implement.TaskDAO;
import model.Task;

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