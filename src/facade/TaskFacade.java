package facade;

import java.util.*;

import dao.AbstractDAOFactory;
import dao.implement.TaskDAO;
import model.MyDate;
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
    
    public int addTask(String name,MyDate start,MyDate end,String description,int idActivity) {
    	Task task = new Task(0, name, start, end, description, false, idActivity);
    	 int res = taskDAO.createTask(task);
    	 return res;
    }
    
    public Task findTask(int idTask) {
    	return taskDAO.findTask(idTask);
    }
    
    public void updateTask(int idTask, String name,MyDate start,MyDate end,String description,boolean status,int idActivity) {
    	Task task = new Task(idTask, name, start, end, description, status, idActivity);
    	taskDAO.updateTask(task);
    }

    

}