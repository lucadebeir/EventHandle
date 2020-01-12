package model;

import java.util.*;

/**
 * 
 */
public class Consomable extends Resource {

    private Date limiteDate;
    private Conservation conservation;

    
    public Consomable(int idResource, String nameResource, String locationResource, String descriptionResource,
			String stateResource, float volumeResource, int quantityResource, float priceResource, Date limiteDate,
			Conservation conservation) {
    	
		super(idResource, nameResource, locationResource, descriptionResource, stateResource, volumeResource,
				quantityResource, priceResource);
		this.limiteDate = limiteDate;
		this.conservation = conservation;
	}
    

    /**
     * constructor Consomable as ConsomableDTO
     */
    public Consomable(String nameResource, String locationResource, String descriptionResource,
			String stateResource, float volumeResource, int quantityResource, float priceResource, Date limiteDate,
			Conservation conservation) {
    	
		super(nameResource, locationResource, descriptionResource, stateResource, volumeResource,
				quantityResource, priceResource);
		this.limiteDate = limiteDate;
		this.conservation = conservation;
	}
     
    
    
	/**
     * @return
     */
    public Date getLimiteDate() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setLimiteDate(Date value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Conservation getConservation() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setConservation(Conservation value) {
        // TODO implement here
    }

}