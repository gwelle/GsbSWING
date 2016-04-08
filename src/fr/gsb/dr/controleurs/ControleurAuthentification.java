package fr.gsb.dr.controleurs ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import fr.gsb.dr.entites.DelegueRegional;
import fr.gsb.dr.modeles.ModelePrincipal;
import fr.gsb.dr.techniques.EtatTentativeConnexion;
import fr.gsb.dr.techniques.Session;
import fr.gsb.dr.vues.VueAuthentification;

/**
 * 
 * @author eleve
 *
 */

public class ControleurAuthentification implements ActionListener {

   private ModelePrincipal modele;
   public EtatTentativeConnexion etatTentativeConnexion;
   public VueAuthentification vue;

  
   /**
    * Constructeur
    * @param modele
    * @param vue
    */
   public ControleurAuthentification( VueAuthentification vue) {
	  super();
	  this.vue = vue ;
	  System.out.println("ControleurAuthentification::ControleurAuthentification()") ;
	  this.enregistrerEcouteurs();
	  

   	  }
   	  /**
   	   * Ecouter les évenements des boutons Connecter et Annuler de la vue de Connexion
   	  */
	  private void enregistrerEcouteurs(){
		  System.out.println("ControleurAuthentification::enregistrerEcouteurs()") ;
		  this.vue.getbAnnuler().addActionListener(this);
		  this.vue.getbConnecter().addActionListener(this);
	  }

	/**
	 * @return the modele
	 */
	public ModelePrincipal getModele() {
		return modele;
	}

	/**
	 * @return the etatTentativeConnexion
	 */
	public EtatTentativeConnexion getEtatTentativeConnexion() {
		return etatTentativeConnexion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurAuthentification::actionPerformed()") ;
		Object evenement = e.getSource();
		
		if(evenement == this.vue.getbAnnuler()){
			
			 //modifie l'état de la tentative de connexion
			// Il passe à ABANDON(Il est utilisé par défaut)
			this.etatTentativeConnexion = EtatTentativeConnexion.ABANDON;
			
			//Fermeture de la boite de dialogue
			this.vue.dispose();
		}
		
		else if(evenement == this.vue.getbConnecter()){
			
			String matricule = this.vue.getTfMatricule().getText();
			String mdp = new String (this.vue.getPfMDP().getPassword());

			DelegueRegional dr = null;
			
			try {

			//On appelle la méthode d'authentification dans le modèle
			dr = ModelePrincipal.getModele().seConnecter(matricule, mdp);
			} 
			catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} 
			
			catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			if(dr != null){
				
				//On modifie l'état de la tentative de connexion
				//Il passe à OK
				this.etatTentativeConnexion = EtatTentativeConnexion.OK;

				Session.ouvrirSession(dr);
				
				JOptionPane.showMessageDialog(this.vue, "Bienvenue " + " " + matricule  ,"Authentification", JOptionPane.INFORMATION_MESSAGE, null);
				
				//Fermeture de la boite de dialogue
				this.vue.dispose();
			}
			
			else {
			
				JOptionPane.showMessageDialog(this.vue, "Délégué inconnu", "Authentification", JOptionPane.ERROR_MESSAGE);
		
				 //On modifie l'état de la tentative de connexion
				//Il passe à ECHEC
				this.etatTentativeConnexion = EtatTentativeConnexion.ECHEC;
			}
		}
	}
}