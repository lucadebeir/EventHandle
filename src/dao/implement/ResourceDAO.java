package dao.implement;

import java.util.*;

import model.Resource;

/**
 * 
 */
public abstract class ResourceDAO {

    /**
     * Default constructor
     */
    public ResourceDAO() {
    }

    /**
     * @param resource 
     * @return
     */
    public void createResource(Resource resource) {
        // TODO implement here
       
    }

    /**
     * @return
     */
    public Resource updateResource() {
        // TODO implement here
        return null;
    }

    /**
     * @param id 
     * @return
     */
    public boolean deleteResource(int id) {
        // TODO implement here
        return false;
    }

    /**
     * @param id 
     * @return
     */
    public Resource getResource(int id) {
        // TODO implement here
        return null;
    }

}