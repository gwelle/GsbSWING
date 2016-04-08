package fr.gsb.dr.modeles;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import fr.gsb.dr.entites.CompteRendu;

/**
 * @author eleve
 */
public class ModeleListeComptesRendus extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private List<CompteRendu> comptesRendus = new ArrayList<CompteRendu>() ;
	
	private final String[] entetes = {"Numéro","Nom","Prénom","Ville","Date de Visite","Date de Création","Situation","Consulter"} ;
	

	public ModeleListeComptesRendus() {
		super();
		System.out.println("ModeleListeComptesRendus::ModeleListeComptesRendus()") ;
	}
	
	@Override
	public int getRowCount() {
		System.out.println("ModeleListeComptesRendus:getRowCount())") ;
		return this.comptesRendus.size();
	}

	@Override
	public int getColumnCount() {
		System.out.println("ModeleListeComptesRendus::getColumnCount()") ;
		return this.entetes.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		System.out.println("ModeleListeComptesRendus::getColumnName()") ;
		return this.entetes[columnIndex];
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		System.out.println("ModeleListeComptesRendus::getValueAt("+rowIndex+","+columnIndex+")") ;
		
		switch(columnIndex){
		
		case 0 :
			return new Integer(this.comptesRendus.get(rowIndex).getNumeroCR());
		
		case 1 :
			return this.comptesRendus.get(rowIndex).getNomPraticien();
		
		case 2 :
			return this.comptesRendus.get(rowIndex).getPrenomPraticien();
			
		case 3 :
			return this.comptesRendus.get(rowIndex).getVillePraticien();
		
		case 4 :
			return this.comptesRendus.get(rowIndex).getDateVisiteCR();
		
		case 5 :
			return this.comptesRendus.get(rowIndex).getDateCréationCR();
			
		case 6 :
			return this.comptesRendus.get(rowIndex).getEstLu();
			
			
		case 7 :
			return "Consulter";
			
		default :
			return null ;
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex){
		System.out.println("ModeleListeComptesRendus::getColumnClass("+ columnIndex +")") ;
		
		 //Retourne la classe de la colonne d'indice "ColumnIndex"
		 //Obtenir la classe d'une colonne
		switch(columnIndex){
		
		case 0 :
			return Integer.class ;
			
		case 1 :
			return String.class ;
			
		case 2 :
			return String.class ;
			
		case 3 :
			return String.class ;
			
		case 4 :
			return Date.class ;
			
		case 5 :
			return Date.class ;
			
		case 6 :
			return String.class ;
			
		case 7 :
			return JButton.class ;
			
		default :
			return Object.class ;
		}
		
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex){
		System.out.println("ModeleListeComptesRendus::isCellEditable("+rowIndex+","+columnIndex+")") ;
		
		//On veut éditer la colonne choisir qui référence le bouton de choix
		if(columnIndex == 7){
			return true ;
		}
		else{
			return false ;
	     }
	}

	/**
	 * Mettre à jour de la vue de la liste des comptes rendus
	 * 
	 */
	public void actualiser(){
		System.out.println("ModeleListeComptesRendus::actualiser()") ;
		this.MAJvueListeComptesRendus();
		this.fireTableDataChanged();
	}
	
	public void MAJvueListeComptesRendus(){
		System.out.println("ModeleListeComptesRendus::MAJvueListeComptesRendus()") ;
		//comptesRendus = ((ModelePrincipal) ModelePrincipal.getModele()).getComptesRendus();
	}
}