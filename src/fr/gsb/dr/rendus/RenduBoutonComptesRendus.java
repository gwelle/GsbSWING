package fr.gsb.dr.rendus;

/**
 * @author eleve
 */

import java.awt.Component;

import javax.swing.*;
import javax.swing.table.*;

public class RenduBoutonComptesRendus  extends JButton implements TableCellRenderer{

	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		System.out.println("RenduBoutonComptesRendus::getTableCellRendererComponent()");
		
		//Savoir si la valeur du bouton est différente de  null
		if(value != null){
			this.setText(value.toString()) ;
			
		}
		
		else {
			this.setText("") ;
		}
		
		return this;
	}
}