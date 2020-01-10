package model;

/**
 * @author lucadebeir
 */
public class Notification {

    /**
     * Default constructor
     */
    public Notification(int idNotification, String title, String content) {
    	this.idNotification = idNotification;
    	this.titleMessage = title;
    	this.contentMessage = content;
    }

    /**
     * 
     */
    private int idNotification;

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
    private User receiver;



    /**
     * @return
     */
    public int getIdNotification() {
        // TODO implement here
        return this.idNotification;
    }

    /**
     * @param value
     */
    public void setIdNotification(int value) {
        // TODO implement here
    	this.idNotification = value;
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
    public User getReceiver() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setReceiver(User value) {
        // TODO implement here
    }

}