package fr.gsb.dr.entites;

import java.sql.Date;

/**
 * @author eleve
 */
public class Praticien {

	private int numeroPraticien ;
	private String nomPraticien ;
	private String villePraticien ;
	
	private int coefConfiance ;
	private Date dateVisite ;
	private float coefNotoriete ;
	
	public Praticien() {
	 System.out.println("Praticien:Praticien()");
	}
	
	/**
	 * @param numeroPraticien
	 * @param nomPraticien
	 * @param villePraticien
	 * @param coefConfiance
	 * @param dateVisite
	 * @param coefNotoriete
	 */
	public Praticien(int numeroPraticien, String nomPraticien,
			String villePraticien, int coefConfiance, Date dateVisite,
			float coefNotoriete) {
		this.numeroPraticien = numeroPraticien;
		this.nomPraticien = nomPraticien;
		this.villePraticien = villePraticien;
		this.coefConfiance = coefConfiance;
		this.dateVisite = dateVisite;
		this.coefNotoriete = coefNotoriete;
	}

	/**
	 * @return the numeroPraticien
	 */
	public int getNumeroPraticien() {
		return numeroPraticien;
	}

	/**
	 * @return the nomPraticien
	 */
	public String getNomPraticien() {
		return nomPraticien;
	}

	/**
	 * @return the villePraticien
	 */
	public String getVillePraticien() {
		return villePraticien;
	}

	/**
	 * @return the coefConfiance
	 */
	public int getCoefConfiance() {
		return coefConfiance;
	}

	/**
	 * @return the dateVisite
	 */
	public Date getDateVisite() {
		return dateVisite;
	}

	/**
	 * @return the coefNotoriete
	 */
	public float getCoefNotoriete() {
		return coefNotoriete;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Praticien [numeroPraticien=" + numeroPraticien
				+ ", nomPraticien=" + nomPraticien + ", villePraticien="
				+ villePraticien + "]";
	}
}