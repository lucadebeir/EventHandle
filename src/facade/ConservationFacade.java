package facade;

import java.util.*;

import dao.AbstractDAOFactory;
import dao.implement.ConservationDAO;
import model.Conservation;

/**
 * 
 */
public class ConservationFacade {

    /**
     * Default constructor
     */
    public ConservationFacade() {
    }

    /**
     * 
     */
    public Set<Conservation> conservations;

    /**
     * 
     */
    public ConservationDAO conservationDAO;

    /**
     * 
     */
    public AbstractDAOFactory factory;




}