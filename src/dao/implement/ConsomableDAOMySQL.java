package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.Conservation;
import model.Resource;
import model.Consomable;


/**
 * 
 */
public class ConsomableDAOMySQL extends ResourceDAO {

    /**
     * Default constructor
     */
	public ConsomableDAOMySQL(Connection conn) {
      this.connect = conn;
    }

    public Connection connect;
    public Conservation conservationType;

    
    /**
     * @param id 
     * @return
     */
    public Resource getResource(int id) {
        // TODO implement here
        return null;
    }

    
   
    public void createResource(Resource rsc) {
    	Consomable resource = (Consomable) rsc;
    	try {
			this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO `consomable`(`idconsomable`, `nameconsomable`, `locationconsomable`, `descriptionconsomable`, `stateconsomable`, `volumeconsomable`, `quantityconsomable`, `priceconsomable`, `idEvent`,`limiteDate`,`idConservation`) VALUES (NULL,'" 
			+ resource.getNameResource() + "','" + resource.getLocationResource() + "','" + resource.getDescriptionResource() + "','" 
			+ resource.getStateResource() + "','" + resource.getVolumeResource() + "','" + resource.getQuantityResource() + "','"
			+ resource.getPriceResource() + "','" + resource.getEventId() + "','" + resource.getLimiteDate() + "','" + resource.getidConservation() + "')" );
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error("insert into database error");
		}
    }


	public void updateResource(Resource rsc) {
		Consomable resource = (Consomable) rsc;
    	try {
			this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE `consomable` SET `nameconsomable`='" + resource.getNameResource() + "',`locationconsomable`='" + resource.getLocationResource() + "',"
					+ "`descriptionconsomable`='"+ resource.getDescriptionResource() + "',`stateconsomable`='" + resource.getStateResource() + "',"
					+ "`volumeconsomable`="+ resource.getVolumeResource() + ",`quantityconsomable`=" + resource.getQuantityResource() 
					+ ",`priceconsomable`=" + resource.getPriceResource() + ",`idEvent`=" + resource.getEventId() + "`limiteDate`='"+ resource.getLimiteDate()
					+ "',`idConservation`='"+ resource.getidConservation() + "' WHERE `idconsomable`=" + resource.getIdResource());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error("insert into database error");
		}
	}

	@Override
	public void deleteResource(int idResource) {
		String sql = "DELETE FROM consomable WHERE idconsomable = ?";
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
		Consomable resource;

		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM `consomable` WHERE `idEvent`= " + eventId );
			while (result.next()) {
				resource = new Consomable(result.getInt("idconsomable"),result.getString("nameconsomable"),result.getString("locationconsomable"),
						result.getString("descriptionconsomable"), result.getString("stateconsomable"), result.getFloat("volumeconsomable"),
						result.getInt("quantityconsomable"), result.getFloat("priceconsomable"), result.getInt("idEvent"), result.getDate("limiteDate"), result.getInt("idConservation"));
				resources.add(resource);
			}
			return resources;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error("get into database error");
		}
	}


}