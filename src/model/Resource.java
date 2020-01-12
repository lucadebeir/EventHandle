package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */
public class Resource {
	
	//should refactor to enumeration
	public static final List<String> typeResourceList = Arrays.asList("Consomable", "Material", "Vehicle");
	public static final ArrayList<String> stateResourceList = new ArrayList<String>(Arrays.asList("Order", "Stock", "Use", "Finish"));
    

	private int idResource;
    private String nameResource;
    private String locationResource;
    private String descriptionResource;
    private String stateResource;
    private float volumeResource;
    private int quantityResource;
    private float priceResource;


    public Resource(int idResource, String nameResource, String locationResource, String descriptionResource,
			String stateResource, float volumeResource, int quantityResource, float priceResource) {
		super();
		this.idResource = idResource;
		this.nameResource = nameResource;
		this.locationResource = locationResource;
		this.descriptionResource = descriptionResource;
		this.stateResource = stateResource;
		this.volumeResource = volumeResource;
		this.quantityResource = quantityResource;
		this.priceResource = priceResource;
	}
    
    /**
     * constructor Resource as resourceDTO
     */
    public Resource(String nameResource, String locationResource, String descriptionResource,
			String stateResource, float volumeResource, int quantityResource, float priceResource) {
		super();
		this.nameResource = nameResource;
		this.locationResource = locationResource;
		this.descriptionResource = descriptionResource;
		this.stateResource = stateResource;
		this.volumeResource = volumeResource;
		this.quantityResource = quantityResource;
		this.priceResource = priceResource;
	}
    

    /**
     * @return
     */
    public int getIdResource() {
        // TODO implement here
        return 0;
    }

    /**
     * @param value
     */
    public void setIdResource(int value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getNameResource() {
        // TODO implement here
        return "";
    }

    /**
     * @param value
     */
    public void setNameResource(String value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getDescriptionResource() {
        // TODO implement here
        return "";
    }

    /**
     * @param value
     */
    public void setDescriptionResource(String value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getStateResource() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setStateResource(String value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public float getVolumeResource() {
        // TODO implement here
        return 0;
    }

    /**
     * @param value
     */
    public void setVolumeResource(float value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getQuantityResource() {
        // TODO implement here
        return 0;
    }

    /**
     * @param value
     */
    public void setQuantityResource(int value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getLocationResource() {
        // TODO implement here
        return "";
    }

    /**
     * @param value
     */
    public void setLocationResource(String value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public float getPriceResource() {
        // TODO implement here
        return 0;
    }

    /**
     * @param value
     */
    public void setPriceResource(float value) {
        // TODO implement here
    }

}