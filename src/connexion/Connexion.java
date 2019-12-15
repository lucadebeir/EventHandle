package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * @author lucadebeir
 *
 */

public class Connexion{

	//Objet Connection
	private static Connection connect;
	 
	//Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
	public static Connection getInstance(){
	    if(connect == null){
	      try {
	    	Properties props = new Properties();
			props.setProperty("ssl","false");
	        connect = DriverManager.getConnection("jdbc:mysql://localhost:8889/eventhandle?autoReconnect=true","root","root");
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }      
	    return connect;
	  }     
}

