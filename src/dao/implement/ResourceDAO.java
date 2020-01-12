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
    public abstract void createResource(Resource resource);
    public abstract Resource updateResource(Resource resource);
    public abstract void deleteResource(int idResource);
    public abstract Resource getResource(int id);
	public abstract List<Resource> getAllResource(int eventId);

}