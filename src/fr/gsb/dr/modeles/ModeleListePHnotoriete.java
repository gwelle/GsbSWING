package fr.gsb.dr.modeles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.gsb.dr.entites.Praticien;

/**
 * @author eleve
 *
 */
public class ModeleListePHnotoriete  extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private List<Praticien> praticiens = ModelePrincipal.getModele().getPHNotoriete() ;
	
	private final String[] entetes = {"Numéro","Nom","Ville","C.Notoriete"} ;
	

	public ModeleListePHnotoriete() {
		super();
		System.out.println("ModeleListePHnotoriete::ModeleListePHnotoriete()") ;
	}
	
	@Override
	public int getRowCount() {
		System.out.println("ModeleListePHnotoriete::getRowCount())") ;
		return this.praticiens.size();
	}

	@Override
	public int getColumnCount() {
		System.out.println("ModeleListePHnotoriete::getColumnCount()") ;
		return this.entetes.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		System.out.println("ModeleListePHnotoriete::getColumnName()") ;
		return this.entetes[columnIndex];
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		System.out.println("ModeleListePHnotoriete::getValueAt("+rowIndex+","+columnIndex+")") ;
		
		switch(columnIndex){
		
		case 0 :
			return new Integer(this.praticiens.get(rowIndex).getNumeroPraticien());
		
		case 1 :
			return this.praticiens.get(rowIndex).getNomPraticien();
		
		case 2 :
			return this.praticiens.get(rowIndex).getVillePraticien();

		case 3 :
			return new Float(this.praticiens.get(rowIndex).getCoefNotoriete());
			
		default :
			return null ;
		}
	}
	/**
	 * Mettre à jour la vue de la liste des Praticiens Hésitants pour le Coefficient de Confiance
	 */
	public void actualiser(){
		System.out.println("ModeleListePHnotoriete::actualiser()") ;
		this.fireTableDataChanged();
	}
}