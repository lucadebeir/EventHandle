package dao.implement;

import database.BdConnector;
import model.Sponsor;

/**
 * 
 */
public class SponsorDAOMySQL extends SponsorDAO {

    /**
     * Default constructor
     */
    public SponsorDAOMySQL() {
    }

    /**
     * 
     */
    public BdConnector connect;

    /**
     * @param connect
     */
    public void SponsorDAOMySQL(BdConnector connect) {
        // TODO implement here
    }

    /**
     * @param obj 
     * @return
     */
    public void createSponsor(Sponsor obj) {
        // TODO implement here
    }

    /**
     * @param id 
     * @return
     */
    public Sponsor findSponsor(int id) {
        // TODO implement here
        return null;
    }

    /**
     * @param obj 
     * @return
     */
    public void updateSponsor(Sponsor obj) {
        // TODO implement here
    }

    /**
     * @param obj 
     * @return
     */
    public void deleteSponsor(Sponsor obj) {
        // TODO implement here
    }

}