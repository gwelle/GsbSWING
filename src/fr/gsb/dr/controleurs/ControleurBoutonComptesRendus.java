/**
 * 
 */
package fr.gsb.dr.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;



/**
 * @author eleve
 *
 */
public class ControleurBoutonComptesRendus implements ActionListener {
	
	private int row ;
	private int column ;
	private JTable table ;
	
	

	/**
	 * 
	 */
	public ControleurBoutonComptesRendus() {
		super();
		System.out.println("ControleurBoutonComptesRendus::ControleurBoutonComptesRendus");
	}
	
	



	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}





	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}





	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}





	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}





	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}





	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurBoutonComptesRendus::actionPerformed()");
		
	}

}
