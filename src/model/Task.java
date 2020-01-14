package model;

import java.util.*;

/**
 * 
 */
public class Task {
	
	private int idTask;
	private String taskName;
    private MyDate startDateTask;
    private MyDate endDateTask;
    private String descriptionTask;
    private ArrayList volunteerList;
    private boolean statusTask;
    private int idActivity;

    /**
     * Default constructor
     */
    public Task() {
    }
    
    

	public Task(int idTask, String taskName, MyDate startDateTask, MyDate endDateTask, String descriptionTask, boolean statusTask, int idActivity) {
		this.idTask = idTask;
		this.taskName = taskName;
		this.startDateTask = startDateTask;
		this.endDateTask = endDateTask;
		this.descriptionTask = descriptionTask;
		this.statusTask = statusTask;
		this.idActivity = idActivity;
	}

	public int getIdTask() {
		return idTask;
	}

	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public MyDate getStartDateTask() {
		return startDateTask;
	}

	public void setStartDateTask(MyDate startDateTask) {
		this.startDateTask = startDateTask;
	}

	public MyDate getEndDateTask() {
		return endDateTask;
	}

	public void setEndDateTask(MyDate endDateTask) {
		this.endDateTask = endDateTask;
	}

	public String getDescriptionTask() {
		return descriptionTask;
	}

	public void setDescriptionTask(String descriptionTask) {
		this.descriptionTask = descriptionTask;
	}

	public ArrayList getVolunteerList() {
		return volunteerList;
	}

	public void setVolunteerList(ArrayList volunteerList) {
		this.volunteerList = volunteerList;
	}

	public boolean isStatusTask() {
		return statusTask;
	}

	public void setStatusTask(boolean statusTask) {
		this.statusTask = statusTask;
	}

	public int getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(int idActivity) {
		this.idActivity = idActivity;
	}
	
	@Override
	public String toString() {
		return this.taskName;
	}


}