package fr.gsb.dr.entites;

import java.sql.Date;

/**
 * @author eleve
 */

public class CompteRendu {

	private int numeroCR ;
	private String nomPraticien ;
	private String prenomPraticien ;
	private String villePraticien ;
	private Date dateVisiteCR ;
	private Date dateCréationCR ;
	private String estLu ;
	
	public CompteRendu() {
		super();
		System.out.println("CompteRendu::CompteRendu()");
	}

	/**
	 * @param numeroCR
	 * @param nomPraticien
	 * @param prenomPraticien
	 * @param villePraticien
	 * @param dateVisiteCR
	 * @param dateCréationCR
	 * @param estLu
	 */
	public CompteRendu(int numeroCR, String nomPraticien,
			String prenomPraticien, String villePraticien, Date dateVisiteCR,
			Date dateCréationCR, String estLu) {
		super();
		System.out.println("CompteRendu::CompteRendu(int,String,String,String;String,Date,Date,String)");
		this.numeroCR = numeroCR;
		this.nomPraticien = nomPraticien;
		this.prenomPraticien = prenomPraticien;
		this.villePraticien = villePraticien;
		this.dateVisiteCR = dateVisiteCR;
		this.dateCréationCR = dateCréationCR;
		this.estLu = estLu;
	}

	
	/**
	 * @return the numeroCR
	 */
	public int getNumeroCR() {
		return numeroCR;
	}

	/**
	 * @return the nomPraticien
	 */
	public String getNomPraticien() {
		return nomPraticien;
	}

	/**
	 * @return the prenomPraticien
	 */
	public String getPrenomPraticien() {
		return prenomPraticien;
	}

	/**
	 * @return the villePraticien
	 */
	public String getVillePraticien() {
		return villePraticien;
	}

	/**
	 * @return the dateVisiteCR
	 */
	public Date getDateVisiteCR() {
		return dateVisiteCR;
	}

	/**
	 * @return the dateCréationCR
	 */
	public Date getDateCréationCR() {
		return dateCréationCR;
	}

	/**
	 * @return the estLu
	 */
	public String getEstLu() {
		return estLu;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompteRendu [numeroCR=" + numeroCR + ", nomPraticien="
				+ nomPraticien + ", prenomPraticien=" + prenomPraticien
				+ ", villePraticien=" + villePraticien + ", dateVisiteCR="
				+ dateVisiteCR + ", dateCréationCR=" + dateCréationCR
				+ ", estLu=" + estLu + "]";
	}
}