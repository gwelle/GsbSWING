package fr.gsb.dr.techniques;

import fr.gsb.dr.entites.DelegueRegional;

/**
 * @author eleve
 */

public class Session {

  private static Session session = null;

  private DelegueRegional dr;

	/**
	 * @param Délégué Régional
	 */
	private Session(DelegueRegional dr){
		super();
		System.out.println("Session::Session()") ;
		this.dr = dr;
	}

	/**
	 * Ouvrir une Session
	 * @param dr
	 */
	public  static void ouvrirSession(DelegueRegional dr){
		System.out.println("Session::ouvrirSession()") ;
		session = new Session(dr);
	}

	/**
	 * Fermer une Session
	 */
	public static void fermerSession(){
		System.out.println("Session::fermerSession()") ;
		session = null ;
	}

	/**
	 * @return Une Session
	 */
	public static Session getSession(){
		System.out.println("Session::getSession()") ;
		return Session.session;
	}

	/**
	 * @return Délégué Régional
	 */
	public DelegueRegional getDr() {
		return dr;
	}
}