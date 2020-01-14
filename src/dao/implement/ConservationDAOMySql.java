package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Conservation;

/**
 * 
 */
public class ConservationDAOMySql extends ConservationDAO {

    public Connection connect;
    
    
	public ConservationDAOMySql(Connection cnt) {
		this.connect = cnt;
    }

    
    public void createConservation(Conservation conservationDTO) {
    	try {
			this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO `conservation`(`idConservation`, `nameConservation`, `descriptionConservation`, `storageTemperature`)  VALUES (NULL,'" 
			+ conservationDTO.getNameConcervation() + "','" + conservationDTO.getDescriptionConservation() + "','" + conservationDTO.getStorageTempConservation() + "')" );
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error("insert into database error");
		}
        
    }

   
    public void updateConservation(Conservation conservationDTO) {
    	try {
			this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE `conservation` SET `nameConservation`='" + conservationDTO.getNameConcervation() + "',"
					+ "`descriptionConservation`='" + conservationDTO.getDescriptionConservation() + "',`storageTemperature`='" + conservationDTO.getStorageTempConservation()+"' WHERE `idConservation`='" + conservationDTO.getIdConcervation());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error("update into database error");
		}
    }

   
    public void deleteConservation(int idConservation) {
    	String sql = "DELETE FROM conservation WHERE idMaterial = ?";
		try {
			PreparedStatement preparedStatement = this.connect.prepareStatement(sql);
			preparedStatement.setInt(1, idConservation);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error("delete into database error");
		}
    }

    /**
     * @param id 
     * @return
     */
    public Conservation getConservation(int idConservation) {
    	String sql = "SELECT * FROM `conservation` WHERE `idConservation` = ?";
    	Conservation conservation;
		try {
			PreparedStatement preparedStatement = this.connect.prepareStatement(sql);
			preparedStatement.setInt(1, idConservation);
			ResultSet result = preparedStatement.executeQuery();
			conservation = new Conservation(result.getInt("idConservation"),result.getString("nameConservation"),result.getString("descriptionConservation"),result.getInt("storageTemperature"));
			return conservation;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error("get conservation into database error");
		}
    }

}