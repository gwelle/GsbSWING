package fr.gsb.dr.techniques;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connexion à la base de données MySQL
 * @author eleve
 */

public class ConnexionBD {
	
	private static String pilote = "com.mysql.jdbc.Driver";
	
	private static String url = "jdbc:mysql://localhost:3306/GsbCRv5?useUnicode=yes&characterEncoding=UTF-8";
	private static String user = "root";
	private static String mdp = "azerty";
    //private static String mdp = "mysql";
	
	private static Connection connexion = null ;
	
	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private ConnexionBD() throws ClassNotFoundException, SQLException{
		
		try{
	
		//Chargement du pilote	
		Class.forName(pilote);
		}
		
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		try{
			
		//Ouverture de la connexion
		connexion  = DriverManager.getConnection(url,user,mdp);
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Une Instance de connexion unique
	 * @return the connexion
	 */
	public static Connection getConnexion() {
		
		if(connexion == null){
			 try {
				new ConnexionBD();
			} 
			 
			 catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
			 
			 catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connexion;
	}
}
