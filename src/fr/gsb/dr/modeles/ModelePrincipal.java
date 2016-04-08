package fr.gsb.dr.modeles ;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import fr.gsb.dr.entites.CompteRendu;
import fr.gsb.dr.entites.DelegueRegional;
import fr.gsb.dr.entites.Praticien;
import fr.gsb.dr.entites.Visiteur;

import fr.gsb.dr.techniques.ConnexionBD;
import fr.gsb.dr.techniques.Session;

/**
 * 
 * @author eleve
 *
 */

public class ModelePrincipal{

  private static ModelePrincipal modele ;

  private ArrayList<Praticien> praticiens = new ArrayList<Praticien>();
  private ArrayList<Visiteur> visiteurs = new ArrayList<Visiteur>();
  private ArrayList<CompteRendu> comptesRendus = new ArrayList<CompteRendu>() ;

  
    public ModelePrincipal(){
    	super();
    	System.out.println("ModelePrincipal::ModelePrincipal()") ;
    }
    
    /**
     * Se Connecter à l'application
     * @param matricule
     * @param mdp
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public DelegueRegional seConnecter(String matricule, String mdp) throws ClassNotFoundException, SQLException {
    	System.out.println("ModelePrincipal::seConnecter()") ;
    	System.out.println("ModelePrincipal::seConnecter() : " + matricule + " " + mdp) ;
    	 

		Connection connexion = ConnexionBD.getConnexion();
		System.out.println(matricule + " " + mdp) ;
		
		String requete = "SELECT TRAVAILLER.REG_CODE FROM VISITEUR "
				+ "INNER JOIN TRAVAILLER ON VISITEUR.VIS_MATRICULE = TRAVAILLER.VIS_MATRICULE "
				+ "WHERE TRAVAILLER.JJMMAA = ( SELECT MAX(JJMMAA)  "
				+ "FROM TRAVAILLER AS T2 WHERE TRAVAILLER.VIS_MATRICULE = T2.VIS_MATRICULE) "
				+ "AND TRA_ROLE = 'Delegue' "
				+ "AND VISITEUR.VIS_MATRICULE= ? AND VISITEUR.VIS_MDP= ? ;";

		
		PreparedStatement pstmt = (PreparedStatement) connexion.prepareStatement(requete) ;
		pstmt.setString(1,matricule);
		pstmt.setString(2,mdp);
		System.out.println("Requête : " + pstmt.toString()) ;
		
		ResultSet resultat = pstmt.executeQuery();
		System.out.println("Fin exécution requête") ;
		
		if(resultat.next()){
			 String codeRegion = resultat.getString("REG_CODE");
			 DelegueRegional dr = new DelegueRegional(matricule,codeRegion);
			 Session.ouvrirSession(dr);
			 System.out.println(Session.getSession().getDr());
			 
			 return dr ;
		}
		
		else {
			return null ;
		}
    }

    
    /**
     * Se Déconnecter de la session
     */
     public void seDeconnecter() {
    	 System.out.println("ModelePrincipal::seDeconnecter()") ;
    	 Session.fermerSession();
  	}
    /**
 	* @return the modele
 	* Design Pattern Singleton pour avoir un modèle unique
 	*/
      public static ModelePrincipal getModele() {
     	 System.out.println("ModelePrincipal::getModele()") ;
     	 if (modele == null){
     		 modele = new ModelePrincipal();
     	 }
     	 
 		return modele;
 	}
      
	/**
	 * Retourne la liste des Praticiens Hésitants triée en Fonction du Coefficient de Confiance
	 * @return the praticiens
	 */
	public ArrayList<Praticien> getPHconfiance() {
		
		praticiens = new ArrayList<Praticien>() ;
		Connection connexion = ConnexionBD.getConnexion();
		Statement stmt;
		try {
			stmt = connexion.createStatement();
		
	
			String requete = "SELECT R1.PRA_NUM,PRA_NOM,PRA_VILLE,RAP_COEFCONFIANCE,RAP_DATE_VISITE,PRA_COEFNOTORIETE "
					+ " FROM RAPPORT_VISITE AS R1 INNER JOIN PRATICIEN "
					+ " ON R1.PRA_NUM = PRATICIEN.PRA_NUM "
					+ "WHERE RAP_DATE_VISITE = "
						+ "(SELECT MAX(RAP_DATE_VISITE) "
						+ "FROM RAPPORT_VISITE AS R2 "
						+ "WHERE R1.PRA_NUM = R2.PRA_NUM  "
						+ "GROUP BY R2.PRA_NUM ) "
					+ "AND RAP_COEFCONFIANCE <=3 "
					+ "ORDER BY RAP_COEFCONFIANCE ASC;";
		
			ResultSet resultat = stmt.executeQuery(requete);
			System.out.println("Requête : " + stmt.toString()) ;
			
			while(resultat.next()){

				Integer numPraticien = resultat.getInt("R1.PRA_NUM");
				String nomPraticien = resultat.getString("PRA_NOM");
				String villePraticien = resultat.getString("PRA_VILLE");
				Integer coefConfiance = resultat.getInt("RAP_COEFCONFIANCE");
				Date dateVisite = resultat.getDate("RAP_DATE_VISITE");
				Float coefNotoriete = resultat.getFloat("PRA_COEFNOTORIETE");
				
				praticiens.add(new Praticien(numPraticien, nomPraticien,villePraticien,coefConfiance,dateVisite,coefNotoriete));
				System.out.println( "Query 1" + " " + numPraticien + " " + nomPraticien  + " " + villePraticien + " "+ coefConfiance + " " +dateVisite + " " + " " +coefNotoriete) ;
				
			}
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getErrorCode());
			System.out.println(e.getSQLState());
		}
		return praticiens;
	}
	
	/**
	 * @return the praticiens
	 * Retourne la liste des Praticiens Hésitants triée en Fonction du Coefficient de Notoriété
	 */
	public ArrayList<Praticien> getPHNotoriete() {
		
		praticiens = new ArrayList<Praticien>() ;
		
		Connection connexion = ConnexionBD.getConnexion();
		Statement stmt;
		try {
			stmt = connexion.createStatement();
		
	
			String requete = "SELECT R1.PRA_NUM,PRA_NOM,PRA_VILLE,RAP_COEFCONFIANCE,RAP_DATE_VISITE,PRA_COEFNOTORIETE "
					+ " FROM RAPPORT_VISITE AS R1 INNER JOIN PRATICIEN "
					+ " ON R1.PRA_NUM = PRATICIEN.PRA_NUM "
					+ "WHERE RAP_DATE_VISITE = "
						+ "(SELECT MAX(RAP_DATE_VISITE) "
						+ "FROM RAPPORT_VISITE AS R2 "
						+ "WHERE R1.PRA_NUM = R2.PRA_NUM  "
						+ "GROUP BY R2.PRA_NUM ) "
					+ "AND RAP_COEFCONFIANCE <=3 "
					+ "ORDER BY PRA_COEFNOTORIETE DESC;";
		
			ResultSet resultat = stmt.executeQuery(requete);
			
			while(resultat.next()){

				Integer numPraticien = resultat.getInt("R1.PRA_NUM");
				String nomPraticien = resultat.getString("PRA_NOM");
				String villePraticien = resultat.getString("PRA_VILLE");
				Integer coefConfiance = resultat.getInt("RAP_COEFCONFIANCE");
				Date dateVisite = resultat.getDate("RAP_DATE_VISITE");
				Float coefNotoriete = resultat.getFloat("PRA_COEFNOTORIETE");
				
				praticiens.add(new Praticien(numPraticien, nomPraticien,villePraticien,coefConfiance,dateVisite,coefNotoriete));
				System.out.println("Query 2" + numPraticien + " " + nomPraticien  +  villePraticien + " "+ coefConfiance + " " +dateVisite + " " + " " +coefNotoriete) ;
				
			}
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
			e.getErrorCode();
			e.getSQLState();
		}
		return praticiens;
	}
	

	/**
	 * @return the praticiens
	 * Retourne la liste des Praticiens Hésitants triée en Fonction de la Date de Visite 
	 */
	public ArrayList<Praticien> getPHdateVisite() {
		
		praticiens = new ArrayList<Praticien>() ;
		
		Connection connexion = ConnexionBD.getConnexion();
		Statement stmt;
		try {
			stmt = connexion.createStatement();
		
	
			String requete = "SELECT R1.PRA_NUM,PRA_NOM,PRA_VILLE,RAP_COEFCONFIANCE,RAP_DATE_VISITE,PRA_COEFNOTORIETE "
					+ " FROM RAPPORT_VISITE AS R1 INNER JOIN PRATICIEN "
					+ " ON R1.PRA_NUM = PRATICIEN.PRA_NUM "
					+ "WHERE RAP_DATE_VISITE = "
						+ "(SELECT MAX(RAP_DATE_VISITE) "
						+ "FROM RAPPORT_VISITE AS R2 "
						+ "WHERE R1.PRA_NUM = R2.PRA_NUM  "
						+ "GROUP BY R2.PRA_NUM ) "
					+ "AND RAP_COEFCONFIANCE <=3 "
					+ "ORDER BY RAP_DATE_VISITE DESC;";
		
			ResultSet resultat = stmt.executeQuery(requete);
			
			while(resultat.next()){

				Integer numPraticien = resultat.getInt("R1.PRA_NUM");
				String nomPraticien = resultat.getString("PRA_NOM");
				String villePraticien = resultat.getString("PRA_VILLE");
				Integer coefConfiance = resultat.getInt("RAP_COEFCONFIANCE");
				Date dateVisite = resultat.getDate("RAP_DATE_VISITE");
				Float coefNotoriete = resultat.getFloat("PRA_COEFNOTORIETE");
				
				praticiens.add(new Praticien(numPraticien, nomPraticien,villePraticien,coefConfiance,dateVisite,coefNotoriete));
				System.out.println("Query 3" + numPraticien + " " + nomPraticien  +  villePraticien + " "+ coefConfiance + " " +dateVisite + " " + " " +coefNotoriete) ;
				
			}
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
			e.getErrorCode();
			e.getSQLState();
		}
		return praticiens;
	}

	/**
	 * Retourne la liste des Visiteurs en Fonction du Code de Région
	 * @param codeRegion
	 * @return the visiteurs
	 */
	public ArrayList<Visiteur> getVisiteurs(String codeRegion) {
	
		visiteurs = new ArrayList<Visiteur>() ;
	        
	        Connection connexion = ConnexionBD.getConnexion();
	        
	        try {
	    
	            String requete = "SELECT V1.VIS_MATRICULE , VIS_NOM , VIS_PRENOM, R1.REG_CODE "
	                    + "FROM TRAVAILLER INNER JOIN VISITEUR V1 ON TRAVAILLER.VIS_MATRICULE = V1.VIS_MATRICULE "
	                    + "INNER JOIN REGION R1 ON TRAVAILLER.REG_CODE = R1.REG_CODE WHERE TRA_ROLE != 'Delegue' "
	                    + "AND TRA_ROLE != 'Responsable' "
	                    + "AND TRA_ROLE = 'Visiteur'"
	                    + "AND R1.REG_CODE = ?;";
	            
	            PreparedStatement pstmt = (PreparedStatement) connexion.prepareStatement(requete) ;
	        
	            pstmt.setString(1,codeRegion);
	            System.out.println(codeRegion);
	            System.out.println("Requête : " + pstmt.toString()) ;
	            ResultSet resultat = pstmt.executeQuery();
	            
	            System.out.println("Fin exécution requête") ;
	            
	            while(resultat.next()){
	
	                String matricule = resultat.getString("V1.VIS_MATRICULE");
	                String nom = resultat.getString("VIS_NOM");
	                String prenom = resultat.getString("VIS_PRENOM");
	                String reg_code = resultat.getString("R1.REG_CODE");
	                
	                 visiteurs.add(new Visiteur(matricule, nom, prenom,reg_code));
	                
	                 System.out.println("Les Visiteurs" + matricule + " " + nom + " " + prenom + " " + reg_code);
	
	            }
	        } 
	        
	        catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getErrorCode());
	            System.out.println(e.getSQLState());
	            System.out.println(e.getMessage());
	        }
	        return visiteurs;
    }

	
	
	/**
	 * @return the comptesRendus
	 * Retourne le dernier Compte rendu en fonction
	 */
	public ArrayList<CompteRendu> getComptesRendus(String matricule,int mois, int annee) {
		
		comptesRendus = new ArrayList<CompteRendu>();
		
		Connection connexion = ConnexionBD.getConnexion();
		
		String requete = "SELECT RAP_NUM, PRA_NOM, PRA_PRENOM, PRA_VILLE, RAP_DATE_VISITE , RAP_DATE_CREATION, RAP_EST_LU "
				+ "FROM RAPPORT_VISITE INNER JOIN  PRATICIEN ON RAPPORT_VISITE.PRA_NUM = PRATICIEN.PRA_NUM "
				+ "WHERE RAP_DATE_VISITE = (SELECT MAX(RAP_DATE_VISITE) FROM RAPPORT_VISITE WHERE VIS_MATRICULE = ?); "
				+ "AND MONTH(RAP_DATE_VISITE) = ? AND YEAR(RAP_DATE_VISITE) = ?" ;
	
		try {
			PreparedStatement pstmt = (PreparedStatement) connexion.prepareStatement(requete) ;
			
			  pstmt.setString(1,matricule);
	          System.out.println("Requête : " + pstmt.toString()) ;
	          
	          ResultSet resultat = pstmt.executeQuery();
	          System.out.println("Fin exécution requête") ;
	          
	          while(resultat.next()){
	
	        	 
	              Integer numCR = resultat.getInt("RAP_NUM");
	              String nomPraticien = resultat.getString("PRA_NOM");
	              String prenomPraticien = resultat.getString("PRA_PRENOM");
	              String villePraticien = resultat.getString("PRA_VILLE");
	              Date dateVisite = resultat.getDate("RAP_DATE_VISITE");
	              Date dateCreation = resultat.getDate("RAP_DATE_CREATION");
	              String estLu = resultat.getString("RAP_EST_LU");
	              
	            comptesRendus.add(new CompteRendu(numCR, nomPraticien, prenomPraticien,villePraticien,dateVisite,dateCreation,estLu));
	
	              
	               System.out.println("Les Comptes Rendus" + numCR + " " + nomPraticien + " " + prenomPraticien 
	          		   + " " + villePraticien + " "+ dateVisite+ " "+ dateCreation + " "+estLu);
	          }
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
	        System.out.println(e.getErrorCode());
	        System.out.println(e.getSQLState());
	        System.out.println(e.getMessage());
		}
		
		return comptesRendus;
	   }
 }