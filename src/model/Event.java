package model;

public class Event {
	
	private int idEvent = 0;
	private String nameEvent = "";
	private MyDate dateStartEvent;
	private String locationEvent = "";
	private MyDate dateEndEvent;
	private String descriptionEvent = "";
	private int idCreator;
	
	public Event(int idEvent, String nameEvent, MyDate dateStartEvent, String locationEvent, MyDate dateEndEvent,
			String descriptionEvent, int idCreator) {
		this.idEvent = idEvent;
		this.nameEvent = nameEvent;
		this.dateStartEvent = dateStartEvent;
		this.locationEvent = locationEvent;
		this.dateEndEvent = dateEndEvent;
		this.descriptionEvent = descriptionEvent;
		this.idCreator = idCreator;
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

}
