package dao.implement;

import database.BdConnector;
import model.Conservation;

/**
 * 
 */
public abstract class ConservationDAOMySql extends ConservationDAO {

    /**
     * Default constructor
     */
	public ConservationDAOMySql(BdConnector cnt) {
    }

    /**
     * 
     */
    public BdConnector connect;

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