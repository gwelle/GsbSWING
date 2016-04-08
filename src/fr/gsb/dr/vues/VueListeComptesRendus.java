package fr.gsb.dr.vues;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.gsb.dr.editeurs.EditeurBoutonComptesRendus;
import fr.gsb.dr.modeles.ModeleListeComptesRendus;
import fr.gsb.dr.rendus.RenduBoutonComptesRendus;
import fr.gsb.dr.rendus.RenduCelluleListeCompteRendus;

/** Vue associée au cas d'utilisation "Consulter un compte rendu"
 * @author eleve
 *
 */

public class VueListeComptesRendus extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ModeleListeComptesRendus modeleTabComptesRendus = new ModeleListeComptesRendus()  ;
	private JTable tabComptesRendus ;
	
	/** Constructeur
	 * 
	 */
	public VueListeComptesRendus(){
		super() ;
		System.out.println("VueListeComptesRendus::VueListeComptesRendus()") ;
		this.creerInterfaceUtilisateur() ;
	
	}
	
	/** Agencer les composants graphiques
	 * Créer Interface Utilisateur
	 */
	private void creerInterfaceUtilisateur(){
		System.out.println("VueListeComptesRendus::creerInterfaceUtilisateur()") ;
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;
		
		boxEtiquette.add(new JLabel("Compte Rendu"));
		boxPrincipale.add(boxEtiquette) ;
		boxPrincipale.add(boxTableau) ;

		/** 
		 * Créer le tableau
		 **/
		this.tabComptesRendus = new JTable(this.modeleTabComptesRendus);
		
		/** 
		 * Définir la hauteur des lignes du tableau
		 **/
		this.tabComptesRendus.setRowHeight(40);
		
		/** 
		 * Créer le panneau avec ascenseur et y positionner le tableau
		 **/
		JScrollPane spComptesRendus = new JScrollPane(this.tabComptesRendus); 
		
		/** 
		 * Fixer les dimensions du panneau avec ascenseur
		 **/
		spComptesRendus.setPreferredSize(new Dimension(1090,420));
		
		/** 
		 * Ajouter le panneau avec ascenseur dans la boite d'agencement
		 **/
		boxTableau.add(spComptesRendus);
		
		this.add(boxPrincipale) ;
	
		this.appliquerRendu();
	}
	
	/** Appliquer le "rendu" au tableau
	 * 
	 */
	private void appliquerRendu(){
		System.out.println("VueListeComptesRendus::appliquerRendu()") ;
		this.tabComptesRendus.setDefaultRenderer(Object.class,new RenduCelluleListeCompteRendus()) ;
		this.tabComptesRendus.getColumn("Consulter").setCellRenderer(new RenduBoutonComptesRendus());
		this.tabComptesRendus.getColumn("Consulter").setCellEditor(new EditeurBoutonComptesRendus(new JCheckBox()));
		this.modeleTabComptesRendus.actualiser();
	}
	
	/**
	 * @return the modeleTabComptesRendus
	 */
	public ModeleListeComptesRendus getModeleTabComptesRendus() {
		return modeleTabComptesRendus;
	}

	/**
	 * @return the tabComptesRendus
	 */
	public JTable getTabComptesRendus() {
		return tabComptesRendus;
	}
}