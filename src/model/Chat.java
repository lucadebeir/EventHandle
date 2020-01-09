package model;

/**
 * 
 */
public class Chat {

    /**
     * Default constructor
     */
    public Chat(int id, String content, int idSender) {
    	this.idMessage = id;
    	this.contentMessage = content;
    	this.idSender = idSender;
    }

    /**
     * 
     */
    private int idMessage;

    /**
     * 
     */
    private String contentMessage;

    /**
     * 
     */
    private int idSender;



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

}