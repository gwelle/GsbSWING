package fr.gsb.dr.entites;

/**
 * @author eleve
 */

public class Visiteur {
	
	private String matricule ;
	private String nom ;
	private String prenom ;
	private String nomRegion;

	/**
	 * @param matricule
	 * @param nom
	 * @param prenom
	 * @param nomRegion
	 */
	public Visiteur(String matricule, String nom, String prenom,
			String nomRegion) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.nomRegion = nomRegion;
	}

	/**
	 * @param matricule
	 * @param nom
	 * @param prenom
	 */
	public Visiteur(String matricule, String nom, String prenom) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @return the nomRegion
	 */
	public String getNomRegion() {
		return nomRegion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Visiteur [matricule=" + matricule + ", nom=" + nom
				+ ", prenom=" + prenom + ", nomRegion=" + nomRegion + "]";
	}
}