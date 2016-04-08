package fr.gsb.dr.vues;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.gsb.dr.modeles.ModeleListePHdateVisite;

/** Vue associée au cas d'utilisation "Consulter la liste des Praticiens Hésitants"
 * @author eleve
 */

public class VueListePHdateVisite extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ModeleListePHdateVisite modeleTabPraticiens = new ModeleListePHdateVisite()  ;
	private JTable tabPraticiens ;
	
	public VueListePHdateVisite(){
		super() ;
		System.out.println("VueListePHdateVisite::VueListePHdateVisite()") ;
		this.creerInterfaceUtilisateur() ;
	}
	
	/** Agencer les composants graphiques
	 * Créer Interface Utilisateur
	 */
	private void creerInterfaceUtilisateur(){
		System.out.println("VueListePHdateVisite::creerInterfaceUtilisateur()") ;
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;
		
		boxEtiquette.add(new JLabel("PH Date Visite"));
		boxPrincipale.add(boxEtiquette) ;
		boxPrincipale.add(boxTableau) ;

		/** 
		 * Créer le tableau
		 **/
		this.tabPraticiens = new JTable(this.modeleTabPraticiens);
		
		/** 
		 * Définir la hauteur des lignes du tableau
		 **/
		this.tabPraticiens.setRowHeight(50);
		
		/** 
		 * Créer le panneau avec ascenseur et y positionner le tableau
		 **/
		JScrollPane spPraticiens = new JScrollPane(this.tabPraticiens); 
		
		/** 
		 * Fixer les dimensions du panneau avec ascenseur
		 **/
		spPraticiens.setPreferredSize(new Dimension(1090,420));
		
		/** 
		 * Ajouter le panneau avec ascenseur dans la boite d'agencement
		 **/
		boxTableau.add(spPraticiens);
		
		this.add(boxPrincipale) ;
		
		this.MAJtable();
	}
	
	/** 
	 * Mettre à jour la JTable
	 */
	private void MAJtable(){
		System.out.println("VueListePHconfiance::appliquerRendu()") ;
		modeleTabPraticiens.actualiser();
	}
}