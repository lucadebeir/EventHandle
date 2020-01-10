package model;

/*
 * @author lucadebeir
 */

public class MessageCell {
	
	private String nameSender;
	private String object;
	
	public MessageCell(String nameSender, String object) {
		this.nameSender = nameSender;
		this.object = object;
	}

	public String getNameSender() {
		return nameSender;
	}

	public void setNameSender(String nameSender) {
		this.nameSender = nameSender;
	}

	public String getObjectMessage() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	

}
