package model;


/**
 * 
 */
public class Vehicle extends Resource {

	public Vehicle(int idResource, String nameResource, String locationResource, String descriptionResource,
			String stateResource, float volumeResource, int quantityResource, float priceResource, int eventId) {
		super(idResource, nameResource, locationResource, descriptionResource, stateResource, volumeResource, quantityResource,
				priceResource, eventId);
		// TODO Auto-generated constructor stub
	}
	
	/**
     * constructor Vehicle as VehicleDTO
	 * @param eventId 
     */
	public Vehicle(String nameResource, String locationResource, String descriptionResource, String stateResource,
			float volumeResource, int quantityResource, float priceResource, int eventId) {
		super(nameResource, locationResource, descriptionResource, stateResource, volumeResource, quantityResource,
				priceResource, eventId);
		// TODO Auto-generated constructor stub
	}
	
	 public String getClassName() {
	    	return "Vehicle";
	    } 
	    

}