package src.facade;

import java.util.*;

import src.dao.AbstractDAOFactory;
import src.dao.implement.ConservationDAO;
import src.model.Conservation;

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