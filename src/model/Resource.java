package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */
public class Resource {
	
	//should refactor to enumeration
	private static final List<String> typeResourceList = Arrays.asList("Consomable", "Material", "Vehicle");
	private static final ArrayList<String> stateResourceList = new ArrayList<String>(Arrays.asList("Order", "Stock", "Use", "Finish"));
    

	private int idResource;
    private String nameResource;
    private String locationResource;
    private String descriptionResource;
    private String stateResource;
    private float volumeResource;
    private int quantityResource;
    private float priceResource;
    private int eventId;


    public Resource(int idResource, String nameResource, String locationResource, String descriptionResource,
			String stateResource, float volumeResource, int quantityResource, float priceResource, int eventId) {
		super();
		this.idResource = idResource;
		this.nameResource = nameResource;
		this.locationResource = locationResource;
		this.descriptionResource = descriptionResource;
		this.stateResource = stateResource;
		this.volumeResource = volumeResource;
		this.quantityResource = quantityResource;
		this.priceResource = priceResource;
		this.eventId = eventId;
	}
    
    /**
     * constructor Resource as resourceDTO
     */
    public Resource(String nameResource, String locationResource, String descriptionResource,
			String stateResource, float volumeResource, int quantityResource, float priceResource, int eventId) {
		super();
		this.nameResource = nameResource;
		this.locationResource = locationResource;
		this.descriptionResource = descriptionResource;
		this.stateResource = stateResource;
		this.volumeResource = volumeResource;
		this.quantityResource = quantityResource;
		this.priceResource = priceResource;
		this.eventId = eventId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getIdResource() {
		return idResource;
	}


	public String getNameResource() {
		return nameResource;
	}

	public void setNameResource(String nameResource) {
		this.nameResource = nameResource;
	}

	public String getLocationResource() {
		return locationResource;
	}

	public void setLocationResource(String locationResource) {
		this.locationResource = locationResource;
	}

	public String getDescriptionResource() {
		return descriptionResource;
	}

	public void setDescriptionResource(String descriptionResource) {
		this.descriptionResource = descriptionResource;
	}

	public String getStateResource() {
		return stateResource;
	}

	public void setStateResource(String stateResource) {
		this.stateResource = stateResource;
	}

	public float getVolumeResource() {
		return volumeResource;
	}

	public void setVolumeResource(float volumeResource) {
		this.volumeResource = volumeResource;
	}

	public int getQuantityResource() {
		return quantityResource;
	}

	public void setQuantityResource(int quantityResource) {
		this.quantityResource = quantityResource;
	}

	public float getPriceResource() {
		return priceResource;
	}

	public void setPriceResource(float priceResource) {
		this.priceResource = priceResource;
	}

	public static List<String> getTyperesourcelist() {
		return typeResourceList;
	}

	public static ArrayList<String> getStateresourcelist() {
		return stateResourceList;
	}
    


}