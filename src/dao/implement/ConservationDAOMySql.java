package src.dao.implement;

import java.util.*;

import src.database.BdConnector;
import src.model.Conservation;

/**
 * 
 */
public abstract class ConservationDAOMySql extends ConservationDAO {

    /**
     * Default constructor
     */
    public ConservationDAOMySql() {
    }

    /**
     * @param cnt 
     * @return
     */
    public ConservationDAOMySql ConservationDAOMySql(BdConnector cnt) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Conservation createConservation() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Conservation updateConservation() {
        // TODO implement here
        return null;
    }

    /**
     * @param id 
     * @return
     */
    public boolean deleteConservation(int id) {
        // TODO implement here
        return false;
    }

    /**
     * @param id 
     * @return
     */
    public Conservation getConservation(int id) {
        // TODO implement here
        return null;
    }

}