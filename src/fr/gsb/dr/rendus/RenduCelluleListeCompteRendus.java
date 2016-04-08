package fr.gsb.dr.rendus;

import java.awt.Component;


import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenduCelluleListeCompteRendus extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	public RenduCelluleListeCompteRendus(){
		super() ;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
	 */
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
			
		System.out.println("RenduCelluleListeCompteRendus::getTableCellRendererComponent()");
		
		DefaultTableCellRenderer composant = (DefaultTableCellRenderer) super.getTableCellRendererComponent(table, value, isSelected, hasFocus,	row, column);
		
		return composant;
	}
}