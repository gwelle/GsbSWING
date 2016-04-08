package fr.gsb.dr.vues ;


import javax.swing.*;
import java.awt.*;

import fr.gsb.dr.controleurs.ControleurPrincipal;

/**
 * Vue Principal de l'application
 * @author eleve
 *
 */
public class VuePrincipal extends JFrame {


	private static final long serialVersionUID = 1L;
	private JMenu menuFichier = new JMenu("Fichier");
	private JMenu menuComptesRendus = new JMenu("Comptes-Rendus") ;
	private JMenu menuPraticiens = new JMenu("Praticiens") ;
	
	private JMenuItem itemSeConnecter = new JMenuItem("Se connecter") ;
	private JMenuItem itemSeDeconnecter  = new JMenuItem("Se déconnecter") ;
	private JMenuItem itemQuitter = new JMenuItem("Quitter") ;
	private JMenuItem itemConsulterCRVisiteur  = new JMenuItem("Consulter le Compte-Rendu d'un Visiteur") ;
	private JMenuItem itemPHcoefConfiance = new JMenuItem("Trier par Coefficient de Confiance");
	private JMenuItem itemPHcoefNotoriete = new JMenuItem("Trier par Coefficient de Notoriété");
	private JMenuItem itemPHdateVisite = new JMenuItem("Trier par Date de Visite");
	 
	private ControleurPrincipal controleur;
  
    private VueAccueil vueAccueil = new VueAccueil();
    private VueListePHconfiance vueListePHconfiance= new VueListePHconfiance();
    private VueListePHnotoriete vueListePHnotoriete = new VueListePHnotoriete();
    private VueListePHdateVisite vueListePHdateVisite = new VueListePHdateVisite();
    private VueListeVisiteurs vueListeVisiteurs =  new VueListeVisiteurs();
    private VueComboCR vueComboCR = new VueComboCR();

    private CardLayout clVues ;
  
    private Container conteneur ; 
  
 
  	public VuePrincipal(){
  		super();
		System.out.println("VuePrincipal::VueBarreMenu()") ;
		
		this.setTitle("Application GSB") ;
		this.setSize(1300,500) ; 
		this.setLocationRelativeTo(null) ;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		
		this.creerBarreMenus() ;
		this.setMenusDeconnecter();
		this.setVisible(true) ;
		
		this.controleur = new ControleurPrincipal(this) ;
		
		clVues = new CardLayout(5,5);
		
		conteneur = this.getContentPane();
		conteneur.setLayout(clVues);
		
		conteneur.add(vueAccueil, "Accueil");
		conteneur.add(vueListePHnotoriete,"ListePHNotoriete");
		conteneur.add(vueListePHdateVisite,"ListePHDateVisite");
		conteneur.add(vueListePHconfiance,"ListePHconfiance");
		conteneur.add(vueListeVisiteurs,"ListeVisiteurs");
		conteneur.add(vueComboCR,"vueComboCR");
  	}
  	
  	/**
  	 * Passer d'une vue à une autre
  	 * @param vue
  	 */
  	public void changerDeVue(String vue){
  		System.out.println("VuePrincipal::changerVue()") ;
  		if(vue.equals("Accueil")){
  			this.clVues.show(this.conteneur, "Accueil");
  		}
  		
  		else if(vue.equals("ListePHconfiance")){
  			this.clVues.show(this.conteneur, "ListePHconfiance");
  		}
  		
  		else if(vue.equals("ListePHNotoriete")){
  			this.clVues.show(this.conteneur, "ListePHNotoriete");
  		}
  		
  		else if(vue.equals("ListePHDateVisite")){
  			this.clVues.show(this.conteneur, "ListePHDateVisite");
  		}
  		
  		else if(vue.equals("ListeVisiteurs")){
  			this.clVues.show(this.conteneur, "ListeVisiteurs");
  		}
  		
  		else if(vue.equals("vueComboCR")){
  			this.clVues.show(this.conteneur, "vueComboCR");
  		}	
  	}
  	
	/**
	 * Créer la Barre de Menu
	 */
	private void  creerBarreMenus() {

		System.out.println("VuePrincipal::creerBarreMenus()") ;
		
		JMenuBar barreMenus = new JMenuBar() ;
		
		menuFichier.add(this.itemSeConnecter) ;
		menuFichier.add(this.itemSeDeconnecter) ;
		menuFichier.addSeparator() ;
		menuFichier.add(this.itemQuitter) ;

		menuComptesRendus.add(this.itemConsulterCRVisiteur) ;

		menuPraticiens.add(itemPHcoefConfiance);
		menuPraticiens.add(itemPHcoefNotoriete);
		menuPraticiens.add(itemPHdateVisite);
		
		
		barreMenus.add(menuFichier) ;
		barreMenus.add(menuComptesRendus) ;
		barreMenus.add(menuPraticiens);

		this.setJMenuBar(barreMenus) ;
		
		JDialog.setDefaultLookAndFeelDecorated(true);
  }

	/**
	 * On désactive l'item de connexion
	 * On active l'item de déconnexion
	 * On active tous les menus
	 */
	 public void  setMenusConnecter() {
	    	System.out.println("VuePrincipal::setMenusConnecter()") ;
			this.itemSeConnecter.setEnabled(false);
			this.itemSeDeconnecter.setEnabled(true);
			
			this.menuComptesRendus.setEnabled(true);
			this.menuPraticiens.setEnabled(true);
	  }
	 
	 /**
		 * On active l'item de connexion
		 * On désactive l'item de déconnexion
		 * On désactive tous les menus
		 */
	 public void  setMenusDeconnecter() {
	    	System.out.println("VuePrincipal::setMenusDeconnecter()") ;
			
	    	this.itemSeConnecter.setEnabled(true);
			this.itemSeDeconnecter.setEnabled(false);
			
			this.menuComptesRendus.setEnabled(false);
			this.menuPraticiens.setEnabled(false);
	  }
	
	 /**
	  * On quitte l'application
	  */
	 public void  setMenusQuitter() {
		 System.out.println("VuePrincipal::setMenusQuitter()") ;
		 System.exit(0);
	  }

	/**
	 * @return the itemSeConnecter
	 */
	public JMenuItem getItemSeConnecter() {
		return itemSeConnecter;
	}

	/**
	 * @return the itemSeDeconnecter
	 */
	public JMenuItem getItemSeDeconnecter() {
		return itemSeDeconnecter;
	}

	/**
	 * @return the itemQuitter
	 */
	public JMenuItem getItemQuitter() {
		return itemQuitter;
	}

	/**
	 * @return the itemConsulterCRVisiteur
	 */
	public JMenuItem getItemConsulterCRVisiteur() {
		return itemConsulterCRVisiteur;
	}

	/**
	 * @return the itemPHcoefConfiance
	 */
	public JMenuItem getItemPHcoefConfiance() {
		return itemPHcoefConfiance;
	}

	/**
	 * @return the itemPHcoefNotoriete
	 */
	public JMenuItem getItemPHcoefNotoriete() {
		return itemPHcoefNotoriete;
	}

	/**
	 * @return the itemPHdateVisite
	 */
	public JMenuItem getItemPHdateVisite() {
		return itemPHdateVisite;
	}

	/**
	 * @return the vueListePHconfiance
	 */
	public VueListePHconfiance getVueListePHconfiance() {
		return vueListePHconfiance;
	}

	/**
	 * @return the vueListePHnotoriete
	 */
	public VueListePHnotoriete getVueListePHnotoriete() {
		return vueListePHnotoriete;
	}

	/**
	 * @return the vueListePHdateVisite
	 */
	public VueListePHdateVisite getVueListePHdateVisite() {
		return vueListePHdateVisite;
	}

	/**
	 * @return the vueListeVisiteurs
	 */
	public VueListeVisiteurs getVueListeVisiteurs() {
		return vueListeVisiteurs;
	}

	/**
	 * @return the vueComboCR
	 */
	public VueComboCR getVueComboCR() {
		return vueComboCR;
	}

	/**
	 * @return the vueAccueil
	 */
	public VueAccueil getVueAccueil() {
		return vueAccueil;
	}

	/**
	 * @return the controleur
	 */
	public ControleurPrincipal getControleur() {
		return controleur;
	}
}