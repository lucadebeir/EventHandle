package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.Resource;
import model.Material;
import database.BdConnector;

/**
 * 
 */
public class MaterialDAOMySQL extends ResourceDAO {

    /**
     * Default constructor
     */
	public MaterialDAOMySQL(Connection conn) {
		this.connect = conn; 
    }

    /**
     * 
     */
    public Connection connect;


    /**
     * @return
     */
    public void createResource(Resource resource) {
    	try {
			this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO `material`(`idMaterial`, `nameMaterial`, `locationMaterial`, `descriptionMaterial`, `stateMaterial`, `volumeMaterial`, `quantityMaterial`, `priceMaterial`, `idEvent`) VALUES (NULL,'" 
			+ resource.getNameResource() + "','" + resource.getLocationResource() + "','" + resource.getDescriptionResource() + "','" 
			+ resource.getStateResource() + "','" + resource.getVolumeResource() + "','" + resource.getQuantityResource() + "','"
			+ resource.getPriceResource() + "','" + resource.getEventId() + "')" );
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error("insert into database error");
		}
    }

    @Override
	public void updateResource(Resource resource) {
    	try {
			this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE `material` SET `nameMaterial`='" + resource.getNameResource() + "',`locationMaterial`='" + resource.getLocationResource() + "',"
					+ "`descriptionMaterial`='"+ resource.getDescriptionResource() + "',`stateMaterial`='" + resource.getStateResource() + "',"
					+ "`volumeMaterial`="+ resource.getVolumeResource() + ",`quantityMaterial`=" + resource.getQuantityResource() 
					+ ",`priceMaterial`=" + resource.getPriceResource() + ",`idEvent`=" + resource.getEventId() + " WHERE `idMaterial`=" + resource.getIdResource());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error("insert into database error");
		}
	}

	@Override
	public void deleteResource(int idResource) {
		String sql = "DELETE FROM material WHERE idMaterial = ?";
		try {
			PreparedStatement preparedStatement = this.connect.prepareStatement(sql);
			preparedStatement.setInt(1, idResource);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public Resource getResource(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Resource> getAllResource(int eventId) {
		ArrayList<Resource> resources = new ArrayList<Resource>();
		Resource resource;

		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM `material` WHERE `idEvent`= " + eventId );
			while (result.next()) {
				resource = new Material(result.getInt("idMaterial"),result.getString("nameMaterial"),result.getString("locationMaterial"),
						result.getString("descriptionMaterial"), result.getString("stateMaterial"), result.getFloat("volumeMaterial"),
						result.getInt("quantityMaterial"), result.getFloat("priceMaterial"), result.getInt("idEvent"));
				resources.add(resource);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resources;
	}


	

}