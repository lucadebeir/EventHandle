package model;


/**
 * 
 */
public class Vehicle extends Resource {

	public Vehicle(int idResource, String nameResource, String locationResource, String descriptionResource,
			String stateResource, float volumeResource, int quantityResource, float priceResource) {
		super(idResource, nameResource, locationResource, descriptionResource, stateResource, volumeResource, quantityResource,
				priceResource);
		// TODO Auto-generated constructor stub
	}
	
	/**
     * constructor Vehicle as VehicleDTO
     */
	public Vehicle(String nameResource, String locationResource, String descriptionResource, String stateResource,
			float volumeResource, int quantityResource, float priceResource) {
		super(nameResource, locationResource, descriptionResource, stateResource, volumeResource, quantityResource,
				priceResource);
		// TODO Auto-generated constructor stub
	}

}