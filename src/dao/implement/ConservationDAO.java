package dao.implement;

import model.Conservation;


public abstract class ConservationDAO {


    public abstract void createConservation(Conservation conservationDTO); 
    public abstract void updateConservation(Conservation conservationDTO);
    public abstract void deleteConservation(int idConservation);
    public abstract Conservation getConservation(int idConservation);

}