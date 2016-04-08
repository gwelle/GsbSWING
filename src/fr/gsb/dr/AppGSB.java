package fr.gsb.dr ;

import fr.gsb.dr.vues.VuePrincipal;

/** Classe principale de l'application
 * 
 * @author eleve
 */
public class AppGSB {

	/** Lanceur
	 * @param args Arguments de la ligne de commande
	 */
	public static void main(String[] args) {

		System.out.println("AppGSB::main()") ;
		new VuePrincipal() ;
	}
}