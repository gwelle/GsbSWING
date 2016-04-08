package fr.gsb.dr.vues;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.gsb.dr.editeurs.EditeurBoutonVisiteurs;
import fr.gsb.dr.modeles.ModeleListeVisteurs;
import fr.gsb.dr.rendus.RenduBoutonVisiteurs;
import fr.gsb.dr.rendus.RenduCelluleListeVisiteurs;


/**
 * Vue associée au cas d'utilisation "Consulter un compte rendu"
 * @author eleve
 */
public class VueListeVisiteurs extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ModeleListeVisteurs modeleTabVisiteurs = new ModeleListeVisteurs()  ;
	private JTable tabVisiteurs ;
	
	public VueListeVisiteurs(){
		super() ;
		System.out.println("VueListeVisiteurs::VueListeVisiteurs()") ;
		this.creerInterfaceUtilisateur() ;
	
	}
	
	/** Agencer les composants graphiques
	 * Créer Interface Utilisateur
	 */
	private void creerInterfaceUtilisateur(){
		System.out.println("VueListeVisiteurs::creerInterfaceUtilisateur()") ;
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;
		
		boxEtiquette.add(new JLabel("Liste des Visiteurs"));
		boxPrincipale.add(boxEtiquette) ;
		boxPrincipale.add(boxTableau) ;

		/** 
		 * Créer le tableau
		 **/
		this.tabVisiteurs = new JTable(this.modeleTabVisiteurs);
		
		/** 
		 * Définir la hauteur des lignes du tableau
		 **/
		this.tabVisiteurs.setRowHeight(40);
		
		/** 
		 * Créer le panneau avec ascenseur et y positionner le tableau
		 **/
		JScrollPane spVisiteurs = new JScrollPane(this.tabVisiteurs); 
		
		/** 
		 * Fixer les dimensions du panneau avec ascenseur
		 **/
		spVisiteurs.setPreferredSize(new Dimension(1090,420));
		
		/** 
		 * Ajouter le panneau avec ascenseur dans la boite d'agencement
		 **/
		boxTableau.add(spVisiteurs);
		
		this.add(boxPrincipale) ;
	
		this.appliquerRendu();
	}
	
	/** Appliquer le "rendu" au tableau
	 * 
	 */
	private void appliquerRendu(){
		System.out.println("VueListeVisiteurs::appliquerRendu()") ;
		this.tabVisiteurs.setDefaultRenderer(Object.class,new RenduCelluleListeVisiteurs()) ;
		this.tabVisiteurs.getColumn("Choisir").setCellRenderer(new RenduBoutonVisiteurs());
		this.tabVisiteurs.getColumn("Choisir").setCellEditor(new EditeurBoutonVisiteurs(new JCheckBox()));
		//this.modeleTabVisiteurs.actualiser();

	}
	
	/**
	 * @return the modeleTabVisiteurs
	 */
	public ModeleListeVisteurs getModeleTabVisiteurs() {
		return modeleTabVisiteurs;
	}

	/**
	 * @return the tabVisiteurs
	 */
	public JTable getTabVisiteurs() {
		return tabVisiteurs;
	}	
}