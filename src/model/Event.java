package model;

/*
 * @author lucadebeir
 */

public class Event {
	
	private int idEvent = 0;
	private String nameEvent = "";
	private MyDate dateStartEvent;
	private String locationEvent = "";
	private MyDate dateEndEvent;
	private String descriptionEvent = "";
	private int idCreator;
	private String roleUser;
	
	public Event(int idEvent, String nameEvent, MyDate dateStartEvent, String locationEvent, MyDate dateEndEvent,
			String descriptionEvent, int idCreator, String roleUser) {
		this.idEvent = idEvent;
		this.nameEvent = nameEvent;
		this.dateStartEvent = dateStartEvent;
		this.locationEvent = locationEvent;
		this.dateEndEvent = dateEndEvent;
		this.descriptionEvent = descriptionEvent;
		this.idCreator = idCreator;
		this.roleUser = roleUser;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public String getNameEvent() {
		return nameEvent;
	}

	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}

	public MyDate getDateStartEvent() {
		return dateStartEvent;
	}

	public void setDateStartEvent(MyDate dateStartEvent) {
		this.dateStartEvent = dateStartEvent;
	}

	public String getLocationEvent() {
		return locationEvent;
	}

	public void setLocationEvent(String locationEvent) {
		this.locationEvent = locationEvent;
	}

	public MyDate getDateEndEvent() {
		return dateEndEvent;
	}

	public void setDateEndEvent(MyDate dateEndEvent) {
		this.dateEndEvent = dateEndEvent;
	}

	public String getDescriptionEvent() {
		return descriptionEvent;
	}

	public void setDescriptionEvent(String descriptionEvent) {
		this.descriptionEvent = descriptionEvent;
	}

	public int getIdCreator() {
		return idCreator;
	}

	public void setIdCreator(int idCreator) {
		this.idCreator = idCreator;
	}

	public String getRoleUser() {
		return roleUser;
	}

	public void setRoleUser(String roleUser) {
		this.roleUser = roleUser;
	}

}
