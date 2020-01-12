package model;


/**
 * 
 */
public class Material extends Resource {

	public Material(int idResource, String nameResource, String locationResource, String descriptionResource,
			String stateResource, float volumeResource, int quantityResource, float priceResource) {
		super(idResource, nameResource, locationResource, descriptionResource, stateResource, volumeResource, quantityResource,
				priceResource);
		// TODO Auto-generated constructor stub
	}
	
	/**
     * constructor Material as MaterialDTO
     */
	public Material(String nameResource, String locationResource, String descriptionResource, String stateResource,
			float volumeResource, int quantityResource, float priceResource) {
		super(nameResource, locationResource, descriptionResource, stateResource, volumeResource, quantityResource,
				priceResource);
		// TODO Auto-generated constructor stub
	}

}