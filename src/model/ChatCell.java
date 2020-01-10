package model;

/*
 * @author lucadebeir
 */

public class ChatCell {
	
	private String nameSender;
	private String content;
	
	public ChatCell(String nameSender, String object) {
		this.nameSender = nameSender;
		this.content = object;
	}

	public String getNameSender() {
		return this.nameSender;
	}

	public void setNameSender(String nameSender) {
		this.nameSender = nameSender;
	}

	public String getContentMessage() {
		return this.content;
	}

	public void setContentMessage(String object) {
		this.content = object;
	}

	

}
