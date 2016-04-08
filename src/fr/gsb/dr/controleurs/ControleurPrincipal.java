package fr.gsb.dr.controleurs ;

import javax.swing.*;

import fr.gsb.dr.techniques.EtatTentativeConnexion;
import fr.gsb.dr.techniques.Session;
import fr.gsb.dr.vues.VueAuthentification;
import fr.gsb.dr.vues.VueComboCR;
import fr.gsb.dr.vues.VuePrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author eleve
 */
public class ControleurPrincipal implements ActionListener {

    public VuePrincipal vue;
    
	    /**
		* Constructeur
		* @param vue
		*/
	   public ControleurPrincipal(VuePrincipal vue) {
		super();
		System.out.println("ControleurPrincipal::ControleurPrincipal()") ;
		this.vue = vue;
		this.enregisterEcouteurs();
	    }
	   
		/**
		* On va faire écouter les Items de la vue Principale
		*/
	    private void enregisterEcouteurs() {
	    	System.out.println("ControleurPrincipal::enregisterEcouteurs()") ;
	    	this.vue.getItemQuitter().addActionListener(this);
			this.vue.getItemSeConnecter().addActionListener(this);
			this.vue.getItemSeDeconnecter().addActionListener(this);
			this.vue.getItemPHcoefConfiance().addActionListener(this);
			this.vue.getItemPHcoefNotoriete().addActionListener(this);
			this.vue.getItemPHdateVisite().addActionListener(this);
			this.vue.getItemConsulterCRVisiteur().addActionListener(this);
			}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurPrincipal::actionPerformed()") ;
		 Object evenement = e.getSource() ;
		 
		 //Item Quitter
		 if(evenement == this.vue.getItemQuitter()){
				int choix =  JOptionPane.showConfirmDialog(this.vue, "Voulez-vous  vraiment quittez l'application ?","Femerture de l'application",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				if(choix == JOptionPane.YES_OPTION){
					
					//On quitte l'application
					this.vue.setMenusQuitter();
				}
			}
		 
		 //Item Déconnecter
		 else if(evenement == this.vue.getItemSeDeconnecter()){
				int choix =  JOptionPane.showConfirmDialog(this.vue, "Voulez-vous vraiment vous déconnectez ?","Déconnexion de l'application", 
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				if(choix == JOptionPane.YES_OPTION){
					
					//On se déconnecte du compte du Délégué Régional courant
					this.vue.setMenusDeconnecter();
					
					//Fermeture de la Session du Délégué Régional courant
					Session.fermerSession();
					
					//On change de vue
					this.vue.changerDeVue("Accueil");
				}
			}
			
		 //Item Connecter
		 else if(evenement == this.vue.getItemSeConnecter()){
	
				VueAuthentification vueAuthentification = new VueAuthentification(this.vue);
				vueAuthentification.dispose() ;
				
				 //On récupère l'état de la tentative de connexion
				EtatTentativeConnexion etat = vueAuthentification.getEtatTentativeConnexion();
				
				if(etat == EtatTentativeConnexion.OK){
					
					//On se connecte au compte Délégué Régional courant
					this.vue.setMenusConnecter();
				}
			}
		 
		 //Vue d'accueil
		 else if(evenement == this.vue.getVueAccueil()){
			 
			 //On change de vue
			 this.vue.changerDeVue("Accueil");
		}
		 
		//Item Coefficient de Confiance
		else if(evenement == this.vue.getItemPHcoefConfiance()){
			
			 //On change de vue
			 this.vue.changerDeVue("ListePHconfiance");
		 }
		 
		//Item Coefficient de Notoriété
		else if(evenement == this.vue.getItemPHcoefNotoriete()){
			 this.vue.changerDeVue("ListePHNotoriete");
		 }
		 
		//Item Date de Visite
		else if(evenement == this.vue.getItemPHdateVisite()){
			 this.vue.changerDeVue("ListePHDateVisite");
		 }
		
		//Item Compte Rendu d'un Visiteur
		else if(evenement == this.vue.getItemConsulterCRVisiteur()){
			
			//On change de vue
			this.vue.changerDeVue("vueComboCR");
			
			//On affiche vue pour sélectionner le mois et l'année d'un compte rendu
			VueComboCR vueCombo = new VueComboCR(this.vue);
		}
	}
}