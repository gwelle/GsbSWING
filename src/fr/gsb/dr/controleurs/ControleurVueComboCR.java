package fr.gsb.dr.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import fr.gsb.dr.vues.VueComboCR;

import fr.gsb.dr.vues.VuePrincipal;


/**
 * @author eleve
 *
 */

public class ControleurVueComboCR implements ActionListener {
	
	private VuePrincipal vue ;
	private VueComboCR vueComboCR ;

	
	private JComboBox mois;
	private JComboBox annee;
	
	/**
	 * Constructeur
	 * @param vueComboCR
	 */
	public ControleurVueComboCR(VueComboCR vueComboCR) {
		super();
		System.out.println("ControleurVueComboCR::ControleurVueComboCR");
		this.vue = new VuePrincipal();
		this.vueComboCR = vueComboCR ;
		this.enregisterEcouteurs();
	 }

	/**
	* On va faire écouter les boutons Valider et Annuler de la vue de sélection du mois et de l'année pour consulter un CR
	*/
	private void enregisterEcouteurs() {
		System.out.println("ControleurVueComboCR::enregisterEcouteurs()") ;
	
		this.vueComboCR.getbValider().addActionListener(this);
		this.vueComboCR.getbAnnuler().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurVueComboCR::actionPerformed()") ;
		 Object evenement = e.getSource() ;
		 
		 if(evenement == this.vueComboCR.getbAnnuler()){
			 
			 //On ferme la vue
			 this.vueComboCR.dispose();
		 }
		 
		 else if(evenement == this.vueComboCR.getbValider()){
		 
			 mois = vueComboCR.getCbMois();
			 int moisInt = Integer.parseInt(mois.getSelectedItem().toString());
			
			 annee = vueComboCR.getCbAnnees();
			 int anneeInt = Integer.parseInt(annee.getSelectedItem().toString());
			 
			 System.out.println("Mois Selectionné:"+ " "+ moisInt +" "+ "Année Selectionnée : "+ anneeInt);
			 
			//On demande au modèle 'ModeleListeVisiteurs de mettre à jour la vue 'VueListeVisiteurs'
			//((ModeleListeVisteurs)this.vue.getVueListeVisiteurs().getTabVisiteurs().getModel().actualiser();
		
					
			 
			//On change de vue
			//this.vue.changerDeVue("ListeVisiteurs");
	    }	
	}
}