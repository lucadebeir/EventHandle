package model;

/**
 * 
 */
public class Conservation {

    private int idConcervation;
    private String NameConcervation;
    private String descriptionConservation;
    private int storageTempConservation;
	
    
    public Conservation(int idConcervation, String nameConcervation, String descriptionConservation,
			int storageTempConservation) {
		super();
		this.idConcervation = idConcervation;
		NameConcervation = nameConcervation;
		this.descriptionConservation = descriptionConservation;
		this.storageTempConservation = storageTempConservation;
	}

    // conservation as DTO
	public Conservation(String nameConcervation, String descriptionConservation, int storageTempConservation) {
		super();
		NameConcervation = nameConcervation;
		this.descriptionConservation = descriptionConservation;
		this.storageTempConservation = storageTempConservation;
	}


	public int getIdConcervation() {
		return idConcervation;
	}


	public void setIdConcervation(int idConcervation) {
		this.idConcervation = idConcervation;
	}


	public String getNameConcervation() {
		return NameConcervation;
	}


	public void setNameConcervation(String nameConcervation) {
		NameConcervation = nameConcervation;
	}


	public String getDescriptionConservation() {
		return descriptionConservation;
	}


	public void setDescriptionConservation(String descriptionConservation) {
		this.descriptionConservation = descriptionConservation;
	}


	public int getStorageTempConservation() {
		return storageTempConservation;
	}


	public void setStorageTempConservation(int storageConservation) {
		this.storageTempConservation = storageConservation;
	}
	
    

}