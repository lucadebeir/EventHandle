package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * @author lucadebeir
 *
 */

public class BdConnector{

	//Objet Connection
	private static Connection connect;
	 
	//Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
	public static Connection getInstance(){
	    if(connect == null){
	      try {
	    	Properties props = new Properties();
			props.setProperty("ssl","false");
	        //connect = DriverManager.getConnection("jdbc:mysql://localhost:8889/eventhandle?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC","root","root");
			connect = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/eventhandle?user=eventhandle&password=eventhandle");
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }      
	    return connect;
	  }     
}

