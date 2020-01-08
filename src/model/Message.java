package model;

/**
 * @author lucadebeir
 */
public class Message {
	
	/**
     * 
     */
    private int idMessage;

    /**
     * 
     */
    private String titleMessage;

    /**
     * 
     */
    private String contentMessage;

    /**
     * 
     */
    private int idSender;

    /**
     * 
     */
    private int idReceiver;

    /**
     * Default constructor
     */
    public Message(int id, String title, String content, int idS, int idR) {
    	this.idMessage = id;
    	this.titleMessage = title;
    	this.contentMessage = content;
    	this.idSender = idS;
    	this.idReceiver = idR;
    }

    




    /**
     * @return
     */
    public int getIdMessage() {
        // TODO implement here
        return this.idMessage;
    }

    /**
     * @param value
     */
    public void setIdMessage(int value) {
        // TODO implement here
    	this.idMessage = value;
    }

    /**
     * @return
     */
    public String getTitleMessage() {
        // TODO implement here
        return this.titleMessage;
    }

    /**
     * @param value
     */
    public void setTitleMessage(String value) {
        // TODO implement here
    	this.titleMessage = value;
    }

    /**
     * @return
     */
    public String getContentMessage() {
        // TODO implement here
        return this.contentMessage;
    }

    /**
     * @param value
     */
    public void setContentMessage(String value) {
        // TODO implement here
    	this.contentMessage = value;
    }

    /**
     * @return
     */
    public int getIdSender() {
        // TODO implement here
        return this.idSender;
    }

    /**
     * @param value
     */
    public void setIdSender(int value) {
        // TODO implement here
    	this.idSender = value;
    }

    /**
     * @return
     */
    public int getIdReceiver() {
        // TODO implement here
        return this.idReceiver;
    }

    /**
     * @param value
     */
    public void setIdReceiver(int value) {
        // TODO implement here
    	this.idReceiver = value;
    }

}