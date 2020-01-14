package model;

import java.util.*;

/**
 * 
 */
public class Consomable extends Resource {

    private Date limiteDate;
    private int idConservation;

    
    public Consomable(int idResource, String nameResource, String locationResource, String descriptionResource,
			String stateResource, float volumeResource, int quantityResource, float priceResource, int eventId, Date limiteDate,
			int idConservation) {
    	
		super(idResource, nameResource, locationResource, descriptionResource, stateResource, volumeResource,
				quantityResource, priceResource, eventId);
		this.limiteDate = limiteDate;
		this.idConservation = idConservation;
	}
    

    /**
     * constructor Consomable as ConsomableDTO
     * @param eventId 
     */
    public Consomable(String nameResource, String locationResource, String descriptionResource,
			String stateResource, float volumeResource, int quantityResource, float priceResource,int eventId, Date limiteDate,
			int idConservation) {
    	
		super(nameResource, locationResource, descriptionResource, stateResource, volumeResource,
				quantityResource, priceResource, eventId);
		this.limiteDate = limiteDate;
		this.idConservation = idConservation;
	}
     
    
    public String getClassName() {
    	return "Consomable";
    }


	public Date getLimiteDate() {
		return limiteDate;
	}


	public void setLimiteDate(Date limiteDate) {
		this.limiteDate = limiteDate;
	}


	public int getidConservation() {
		return idConservation;
	}


	public void setidConservation(int idConservation) {
		this.idConservation = idConservation;
	} 
    
	

}