package facade;

import java.util.*;

import dao.AbstractDAOFactory;
import dao.implement.TaskDAO;
import facade.exception.DisconnectedUserException;
import model.MyDate;
import model.Task;
import model.User;

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
    
    public int findIdEventTaskByID(int idTask) {
    	return taskDAO.findIdEventTaskByID(idTask);
    }
    
    public List<User> getPotentialExecutor(int idEvent){
    	return taskDAO.getPotentialExecutor(idEvent);
    }
    
    public List<User> participantTask(int idTask){
    	return taskDAO.participantTask(idTask);
    }
    
    public void deleteParticipant(int idUser,int idTask) {
    	taskDAO.deleteParticipant(idUser, idTask);
    }
    
    public void addParticipant(int idUser,int idTask) {
    	taskDAO.addParticipant(idUser, idTask);
    }

    public List<Task> getAllTaskOfOnUser(int idEvent) throws DisconnectedUserException {
    	int idConnectedUser = LoginFacade.getInstance().getConnectedUser().getId();
    	return taskDAO.getAllTaskOfOnUser(idEvent, idConnectedUser);
    }
    
    public void setTaskStatus(int idTask, boolean statusTask) {
    	taskDAO.setTaskStatus(idTask, statusTask);
    }

}