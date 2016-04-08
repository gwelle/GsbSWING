package fr.gsb.dr.modeles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.gsb.dr.entites.Praticien;

/**
 * @author eleve
 */

public class ModeleListePHconfiance  extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private List<Praticien> praticiens = ModelePrincipal.getModele().getPHconfiance() ;
	
	private final String[] entetes = {"Numéro","Nom","Ville","C.Confiance"} ;
	

	public ModeleListePHconfiance() {
		super();
		System.out.println("ModeleListePHconfiance::ModeleListePHconfiance()") ;
	}
	
	@Override
	public int getRowCount() {
		System.out.println("ModeleListePHconfiance::getRowCount())") ;
		return this.praticiens.size();
	}

	@Override
	public int getColumnCount() {
		System.out.println("ModeleListePHconfiance::getColumnCount()") ;
		return this.entetes.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		System.out.println("ModeleListePHconfiance::getColumnName()") ;
		return this.entetes[columnIndex];
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		System.out.println("ModeleListePHconfiance::getValueAt("+rowIndex+","+columnIndex+")") ;
		
		switch(columnIndex){
		
		case 0 :
			return new Integer(this.praticiens.get(rowIndex).getNumeroPraticien());
		
		case 1 :
			return this.praticiens.get(rowIndex).getNomPraticien();
		
		case 2 :
			return this.praticiens.get(rowIndex).getVillePraticien();
			
		case 3 :
			return new Integer(this.praticiens.get(rowIndex).getCoefConfiance());

		default :
			return null ;
		}
	}
	
	/**
	 * Mettre à jour la vue de la liste des Praticiens Hésitants pour le Coefficient de Confiance
	 */
	public void actualiser(){
		System.out.println("ModeleListePHconfiance::actualiser()") ;
		this.fireTableDataChanged();
	}
}