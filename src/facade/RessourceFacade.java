package facade;

import java.util.*;

import dao.AbstractDAOFactory;
import dao.implement.RessourceDAO;
import model.Ressource;

/**
 * 
 */
public class RessourceFacade {

    /**
     * Default constructor
     */
    public RessourceFacade() {
    }

    /**
     * 
     */
    private AbstractDAOFactory factory;

    /**
     * 
     */
    private RessourceDAO vehicleDAO;

    /**
     * 
     */
    private RessourceDAO materialDAO;

    /**
     * 
     */
    private RessourceDAO consomableDAO;







    /**
     * @return
     */
    public RessourceFacade getInstance() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Ressource addRessource() {
        // TODO implement here
        return null;
    }

    /**
     * @param r 
     * @param idEvent 
     * @return
     */
    public void updateRessource(Ressource r, int idEvent) {
        // TODO implement here
    }

    /**
     * @param r 
     * @param idEvent 
     * @return
     */
    public void deleteRessource(Ressource r, int idEvent) {
        // TODO implement here
    }

    /**
     * @param idEvent 
     * @return
     */
    public Set<Ressource> getAllRessources(int idEvent) {
        // TODO implement here
        return null;
    }

}