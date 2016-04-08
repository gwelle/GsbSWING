package fr.gsb.dr.modeles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.gsb.dr.entites.Praticien;

/**
 * @author eleve
 *
 */

public class ModeleListePHdateVisite  extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private List<Praticien> praticiens = ModelePrincipal.getModele().getPHdateVisite() ;
	
	private final String[] entetes = {"Numéro","Nom","Ville","Date de Visite"} ;
	

	public ModeleListePHdateVisite() {
		super();
		System.out.println("ModeleListePHdateVisite::ModeleListePHdateVisite()") ;
	}
	
	@Override
	public int getRowCount() {
		System.out.println("ModeleListePHdateVisite::getRowCount())") ;
		return this.praticiens.size();
	}

	@Override
	public int getColumnCount() {
		System.out.println("ModeleListePHdateVisite::getColumnCount()") ;
		return this.entetes.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		System.out.println("ModeleListePHdateVisite::getColumnName()") ;
		return this.entetes[columnIndex];
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		System.out.println("ModeleListePHdateVisite::getValueAt("+rowIndex+","+columnIndex+")") ;
		
		switch(columnIndex){
		
		case 0 :
			return new Integer(this.praticiens.get(rowIndex).getNumeroPraticien());
		
		case 1 :
			return this.praticiens.get(rowIndex).getNomPraticien();
		
		case 2 :
			return this.praticiens.get(rowIndex).getVillePraticien();
		
		case 3 :
			return this.praticiens.get(rowIndex).getDateVisite();

		default :
			return null ;
		}
	}
	
	/**
	 * Mettre à jour la vue de la liste des Praticiens Hésitants pour la Date de Visite
	 */
	public void actualiser(){
		System.out.println("ModeleListePHdateVisite::actualiser()") ;
		this.fireTableDataChanged();
	}
}