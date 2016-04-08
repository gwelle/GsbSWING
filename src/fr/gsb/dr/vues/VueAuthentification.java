package fr.gsb.dr.vues;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import fr.gsb.dr.controleurs.ControleurAuthentification;
import fr.gsb.dr.techniques.EtatTentativeConnexion;

/** Vue associée au cas d'utilisation "S'authentifier"
 * @author xilim
 *
 */
public class VueAuthentification extends JDialog {
	
	private static final long serialVersionUID = 1L;

	private ControleurAuthentification controleur ;
	
	private JTextField tfMatricule = new JTextField() ;
	private JPasswordField pfMDP = new JPasswordField() ;
	private JButton bConnecter = new JButton("Se connecter") ;
	private JButton bAnnuler = new JButton("Annuler") ;
	
	/** Controleur
	 * @param vueParente La fenetre principale de l'application
	 */
	public VueAuthentification(JFrame vueParente){
		super(vueParente,"Connexion",true) ;
		System.out.println("VueAuthentification::VueAuthentification()") ;
		this.creerInterfaceUtilisateur();
		this.controleur = new ControleurAuthentification(this) ;
		this.pack();
		this.setLocationRelativeTo(vueParente) ;
		this.setResizable(false) ;
		this.reInitialiser() ;
		this.setVisible(true) ;
	}
	
	/** ReInitialiser les deux champs de saisie avec une chaine de caractère vide
	 * 
	 */
	public void reInitialiser (){
		System.out.println("VueAuthentification::initialiser()") ;
		this.tfMatricule.setText("") ;
		this.pfMDP.setText("") ;
	}
	
	/** Créer l'interface utilisateur (agencer les composants graphiques)
	 * 
	 */
	private void creerInterfaceUtilisateur(){
		System.out.println("VueAuthentification::creerInterfaceUtilisateur()") ;
		Container conteneur = this.getContentPane() ;
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxChamps = Box.createHorizontalBox() ;
		Box boxSaisies = Box.createVerticalBox() ;
		Box boxEtiquettes = Box.createVerticalBox() ;
		Box boxLigne = Box.createHorizontalBox() ;
		Box boxActions = Box.createHorizontalBox() ;
		
		boxEtiquettes.add(new JLabel("Login : ")) ;
		boxEtiquettes.add(new JLabel("MDP : ")) ;
		
		boxSaisies.add(this.tfMatricule) ;
		boxSaisies.add(this.pfMDP) ;
		
		boxLigne.add(Box.createHorizontalStrut(5)) ;
		boxLigne.add(new JSeparator()) ;
		boxLigne.add(Box.createHorizontalStrut(5)) ;
		
		boxActions.add(Box.createHorizontalStrut(5)) ;
		boxActions.add(this.bConnecter) ;
		boxActions.add(Box.createHorizontalStrut(5)) ;
		boxActions.add(this.bAnnuler) ;
		boxActions.add(Box.createHorizontalStrut(5)) ;
		
		boxChamps.add(Box.createHorizontalStrut(5)) ;
		boxChamps.add(boxEtiquettes) ;
		boxChamps.add(Box.createHorizontalStrut(5)) ;
		boxChamps.add(boxSaisies) ;
		boxChamps.add(Box.createHorizontalStrut(5)) ;
		
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		boxPrincipale.add(boxChamps) ;
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		boxPrincipale.add(boxLigne) ;
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		boxPrincipale.add(boxActions) ;
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		
		conteneur.add(boxPrincipale) ;
		
		Dimension dimensionBouton = this.bConnecter.getPreferredSize() ;
		
		this.bAnnuler.setPreferredSize(dimensionBouton) ;
		this.bAnnuler.setMaximumSize(dimensionBouton) ;
		this.bAnnuler.setMinimumSize(dimensionBouton) ;
	}

	
	
	
	/**
	 * @return the controleur
	 */
	public ControleurAuthentification getControleur() {
		return controleur;
	}

	/**
	 * @return the tfMatricule
	 */
	public JTextField getTfMatricule() {
		return tfMatricule;
	}

	/**
	 * @return the pfMDP
	 */
	public JPasswordField getPfMDP() {
		return pfMDP;
	}

	/**
	 * @return the bConnecter
	 */
	public JButton getbConnecter() {
		return bConnecter;
	}

	/**
	 * @return the bAnnuler
	 */
	public JButton getbAnnuler() {
		return bAnnuler;
	}

	/** Obtenir le résultat de la tentative de connexion
	 * @return
	 */
	public EtatTentativeConnexion getEtatTentativeConnexion(){
		System.out.println("VueAuthentification::getEtatTentativeConnexion()") ;
		return this.controleur.getEtatTentativeConnexion() ;
	}
}