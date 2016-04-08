package fr.gsb.dr.entites;

/**
 * @author eleve
 *
 */

public class Region {
	
	private String codeRegion;
	private String nomRegion;
	
	/**
	 * @param codeRegion
	 * @param nomRegion
	 */
	public Region(String codeRegion, String nomRegion) {
		super();
		this.codeRegion = codeRegion;
		this.nomRegion = nomRegion;
	}

	/**
	 * @return the codeRegion
	 */
	public String getCodeRegion() {
		return codeRegion;
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
		return "Region [codeRegion=" + codeRegion + ", nomRegion=" + nomRegion
				+ "]";
	}
}