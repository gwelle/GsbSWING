package fr.gsb.dr.modeles;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import fr.gsb.dr.entites.Visiteur;
import fr.gsb.dr.techniques.Session;

/**
 * @author eleve
 *
 */

public class ModeleListeVisteurs extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private List<Visiteur> visiteurs = new ArrayList<Visiteur>() ;
	
	private final String[] entetes = {"Numéro","Nom","Prénom","Choisir"} ;
	

	public ModeleListeVisteurs() {
		super();
		System.out.println("ModeleListeVisteurs::ModeleListeVisteurs()") ;
	}
	
	@Override
	public int getRowCount() {
		System.out.println("ModeleListeVisteurs:getRowCount())") ;
		return this.visiteurs.size();
	}

	@Override
	public int getColumnCount() {
		System.out.println("ModeleListeVisteurs::getColumnCount()") ;
		return this.entetes.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		System.out.println("ModeleListeVisteurs::getColumnName()") ;
		return this.entetes[columnIndex];
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		System.out.println("ModeleListeVisteurs::getValueAt("+rowIndex+","+columnIndex+")") ;
		
		switch(columnIndex){
		
		case 0 :
			return this.visiteurs.get(rowIndex).getMatricule();
		
		case 1 :
			return this.visiteurs.get(rowIndex).getNom();
		
		case 2 :
			return this.visiteurs.get(rowIndex).getPrenom();
			
		case 3 :
			return "Choisir";
			
			
		default :
			return null ;
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex){
		System.out.println("ModeleListeVisteurs::getColumnClass("+ columnIndex +")") ;

		//Retourne la classe de la colonne d'indice "ColumnIndex"
		//Obtenir la classe d'une colonne
		switch(columnIndex){
		
		case 0 :
			return String.class ;
			
		case 1 :
			return String.class ;
			
		case 2 :
			return String.class ;
			
		case 3 :
			return JButton.class ;
			
		default :
			return Object.class ;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex){
		System.out.println("ModeleListeVisiteurs::isCellEditable("+rowIndex+","+columnIndex+")") ;
		
		//On veut éditer la colonne choisir qui référence le bouton de choix
		if(columnIndex == 3){
			return true ;
		}
		else{
			return false ;
	     }
	}
	/**
	 * Mettre à jour la liste des Visiteurs
	 */
	public void actualiser(){
		System.out.println("ModeleListeVisteurs::actualiser()") ;
		this.MAJvueListeVisiteurs();
		this.fireTableDataChanged();
	}
	
	public void MAJvueListeVisiteurs(){
		System.out.println("ModeleListeVisteurs::MAJvueListeVisiteurs()") ;
		visiteurs = ((ModelePrincipal) ModelePrincipal.getModele()).getVisiteurs(Session.getSession().getDr().getCodeRegion());
	}
}