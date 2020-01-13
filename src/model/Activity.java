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