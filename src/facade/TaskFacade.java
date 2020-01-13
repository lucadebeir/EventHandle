package facade;

import java.util.*;

import dao.AbstractDAOFactory;
import dao.implement.TaskDAO;
import model.Task;

/**
 * 
 */
public class TaskFacade {
	
	private AbstractDAOFactory af = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private TaskDAO taskDAO = af.createTaskDAO();
	
	
	/** Holder */
    private static class SingletonHolder
    {       
        /** Instance unique non préinitialisée */
        private final static TaskFacade instance = new TaskFacade();
    }

    /**
     * Default constructor
     */
    public TaskFacade() {
    }
    
    /** Point d'accès pour l'instance unique du singleton */
    public static TaskFacade getInstance()
    {
        return SingletonHolder.instance;
    }
    
    public List<Task> getTaskList(int idActivity){
    	return taskDAO.getListTask(idActivity);
    }

    

}