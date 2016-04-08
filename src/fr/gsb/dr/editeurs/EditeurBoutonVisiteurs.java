package fr.gsb.dr.editeurs;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import fr.gsb.dr.controleurs.ControleurBoutonVisiteurs;

/**
 * @author eleve
 */

public class EditeurBoutonVisiteurs extends DefaultCellEditor{

	private static final long serialVersionUID = 1L;
	
	protected JButton bouton ;
	private ControleurBoutonVisiteurs controleur = new ControleurBoutonVisiteurs() ;
	
	/**
	 * Constructeur
	 * @param checkBox
	 */
	public EditeurBoutonVisiteurs(JCheckBox checkBox) {
		   super(checkBox);
		   System.out.println("EditeurBoutonVisiteurs::EditeurBoutonVisiteurs()");
			
		   this.bouton = new JButton();
		   this.bouton.setOpaque(true);
		   
		   //On fait écouter le bouton par son controleur
		   this.bouton.addActionListener(this.controleur);
	}
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
			System.out.println("EditeurBoutonVisiteurs::getTableCellEditorComponent()");
		
			this.controleur.setRow(row);
			this.controleur.setColumn(column);
			this.controleur.setTable(table);
		
		
		//Savoir si la valeur du bouton est null
		if(value == null){
			this.bouton.setText("") ;
		}
		
		else {
			this.bouton.setText(value.toString()) ;
		}
		
		return this.bouton ;
	}
}