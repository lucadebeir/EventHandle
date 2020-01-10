package model;

/*
 * @author lucadebeir
 */

public class EventCell {
	
	private String nameEvent;
	private MyDate dateStartEvent;
	private MyDate dateEndEvent;
	private String locationEvent;
	
	public EventCell(String nameEvent, MyDate myDate, MyDate myDate2, String locationEvent) {
		this.nameEvent = nameEvent;
		this.dateStartEvent = myDate;
		this.dateEndEvent = myDate2;
		this.locationEvent = locationEvent;
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

	public MyDate getEndStartEvent() {
		return dateEndEvent;
	}

	public void setEndStartEvent(MyDate dateEndEvent) {
		this.dateEndEvent = dateEndEvent;
	}

	public String getLocationEvent() {
		return locationEvent;
	}

	public void setLocationEvent(String locationEvent) {
		this.locationEvent = locationEvent;
	}
	
	

}
