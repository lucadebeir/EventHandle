package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import model.Vehicle;
import model.Resource;

/**
 * 
 */
public class VehicleDAOMySQL extends ResourceDAO {

    /**
     * Default constructor
     * @param conn 
     */
    public VehicleDAOMySQL(Connection conn) {
    	this.connect = conn;
    }

    /**
     * 
     */
    public Connection connect;

   

   
    public Resource getResource(int id) {
        // TODO implement here
        return null;
    }

    public void createResource(Resource resource) {
    	try {
			this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO `Vehicle`(`idVehicle`, `nameVehicle`, `locationVehicle`, `descriptionVehicle`, `stateVehicle`, `volumeVehicle`, `quantityVehicle`, `priceVehicle`, `idEvent`) VALUES (NULL,'" 
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
			ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE `Vehicle` SET `nameVehicle`='" + resource.getNameResource() + "',`locationVehicle`='" + resource.getLocationResource() + "',"
					+ "`descriptionVehicle`='"+ resource.getDescriptionResource() + "',`stateVehicle`='" + resource.getStateResource() + "',"
					+ "`volumeVehicle`="+ resource.getVolumeResource() + ",`quantityVehicle`=" + resource.getQuantityResource() 
					+ ",`priceVehicle`=" + resource.getPriceResource() + ",`idEvent`=" + resource.getEventId() + " WHERE `idVehicle`=" + resource.getIdResource());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error("insert into database error");
		}
	}

	@Override
	public void deleteResource(int idResource) {
		String sql = "DELETE FROM Vehicle WHERE idVehicle = ?";
		try {
			PreparedStatement preparedStatement = this.connect.prepareStatement(sql);
			preparedStatement.setInt(1, idResource);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Resource> getAllResource(int eventId) {
		ArrayList<Resource> resources = new ArrayList<Resource>();
		Resource resource;

		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM `Vehicle` WHERE `idEvent`= " + eventId );
			while (result.next()) {
				resource = new Vehicle(result.getInt("idVehicle"),result.getString("nameVehicle"),result.getString("locationVehicle"),
						result.getString("descriptionVehicle"), result.getString("stateVehicle"), result.getFloat("volumeVehicle"),
						result.getInt("quantityVehicle"), result.getFloat("priceVehicle"), result.getInt("idEvent"));
				resources.add(resource);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resources;
	}

}