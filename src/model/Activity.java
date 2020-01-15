package model;

/**
 * 
 */
public class Activity {
	
	private int idActivity;
	private String nameActivity;
	private String descriptionActivity;
	private boolean statusActivity;
	private int idEvent;

    /**
     * Default constructor
     */
    public Activity() {
    }
    
    
    
    public Activity(int idActivity, String nameActivity, String descriptionActivity, boolean statusActivity,
			int idEvent) {
		this.idActivity = idActivity;
		this.nameActivity = nameActivity;
		this.descriptionActivity = descriptionActivity;
		this.statusActivity = statusActivity;
		this.idEvent = idEvent;
	}

	public int getIdActivity() {
		return idActivity;
	}
	
	public void setIdActivity(int idActivity) {
		this.idActivity = idActivity;
	}
	
	public String getNameActivity() {
		return nameActivity;
	}

	public void setNameActivity(String nameActivity) {
		this.nameActivity = nameActivity;
	}

	public boolean isStatusActivity() {
		return statusActivity;
	}

	public void setStatusActivity(boolean statusActivity) {
		this.statusActivity = statusActivity;
	}
	
	public String getDescriptionActivity() {
		return descriptionActivity;
	}
	
	public void setDescriptionActivity(String descriptionActivity) {
		this.descriptionActivity = descriptionActivity;
	}
	
	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
	
	@Override
	public String toString() {
		return  nameActivity;
	}
		
}