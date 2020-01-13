package model;

import java.util.*;

/**
 * 
 */
public class Task {
	
	private int idTask;
	private String taskName;
    private Date startDateTask;
    private Date endDateTask;
    private String descriptionTask;
    private ArrayList volunteerList;
    private boolean statusTask;
    private int idActivity;

    /**
     * Default constructor
     */
    public Task() {
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

	public Date getStartDateTask() {
		return startDateTask;
	}

	public void setStartDateTask(Date startDateTask) {
		this.startDateTask = startDateTask;
	}

	public Date getEndDateTask() {
		return endDateTask;
	}

	public void setEndDateTask(Date endDateTask) {
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