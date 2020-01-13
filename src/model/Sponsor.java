package model;

public class Sponsor {


    public Sponsor() {
    }
    
    public int idSponsor;
    public int idEvent;
    public String nameSponsor;
    public int numSiretSponsor;
    public String numTelContactSponsor;
    public String lastNameContactSponsor;
    public String firstNameContactSponsor;
    public String emailContactSponsor;
	
    public Sponsor(int idSponsor,int numSiretSponsor, String nameSponsor, String numTelContactSponsor,
			String lastNameContactSponsor, String firstNameContactSponsor, String emailContactSponsor) {
		super();
		this.idSponsor = idSponsor;
		this.nameSponsor = nameSponsor;
		this.numSiretSponsor = numSiretSponsor;
		this.numTelContactSponsor = numTelContactSponsor;
		this.lastNameContactSponsor = lastNameContactSponsor;
		this.firstNameContactSponsor = firstNameContactSponsor;
		this.emailContactSponsor = emailContactSponsor;
	}

	public int getIdSponsor() {
		return idSponsor;
	}

	public void setIdSponsor(int idSponsor) {
		this.idSponsor = idSponsor;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public String getNameSponsor() {
		return nameSponsor;
	}

	public void setNameSponsor(String nameSponsor) {
		this.nameSponsor = nameSponsor;
	}

	public int getNumSiretSponsor() {
		return numSiretSponsor;
	}

	public void setNumSiretSponsor(int numSiretSponsor) {
		this.numSiretSponsor = numSiretSponsor;
	}

	public String getNumTelContactSponsor() {
		return numTelContactSponsor;
	}

	public void setNumTelContactSponsor(String numTelContactSponsor) {
		this.numTelContactSponsor = numTelContactSponsor;
	}

	public String getLastNameContactSponsor() {
		return lastNameContactSponsor;
	}

	public void setLastNameContactSponsor(String lastNameContactSponsor) {
		this.lastNameContactSponsor = lastNameContactSponsor;
	}

	public String getFirstNameContactSponsor() {
		return firstNameContactSponsor;
	}

	public void setFirstNameContactSponsor(String firstNameContactSponsor) {
		this.firstNameContactSponsor = firstNameContactSponsor;
	}

	public String getEmailContactSponsor() {
		return emailContactSponsor;
	}

	public void setEmailContactSponsor(String emailContactSponsor) {
		this.emailContactSponsor = emailContactSponsor;
	}
    
    
    

}