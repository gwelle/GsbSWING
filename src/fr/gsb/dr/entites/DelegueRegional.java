package fr.gsb.dr.entites ;

/**
 * @author eleve
 */

public class DelegueRegional {

	  private String matricule;
	  private String codeRegion;

		/**
		 * @param numero
		 * @param code
		 */
		public DelegueRegional(String matricule, String codeRegion) {
			super();
			System.out.println("DelegueRegional::DelegueRegional()") ;
			this.matricule = matricule;
			this.codeRegion = codeRegion;
		}
		
		/**
		 * @return the matricule
		 */
		public String getMatricule() {
			return matricule;
		}

		/**
		 * @return the codeRegion
		 */
		public String getCodeRegion() {
			return codeRegion;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "DelegueRegional [matricule=" + matricule + ", codeRegion="
					+ codeRegion + "]";
		}
	}