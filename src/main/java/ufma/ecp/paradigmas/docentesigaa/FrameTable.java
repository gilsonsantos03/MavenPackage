package ufma.ecp.paradigmas.docentesigaa;

import java.sql.SQLException;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ufma.ecp.paradigmas.docentesigaa_reflexao.GenericTableModel;
import ufma.ecp.paradigmas.docentesigaa_reflexao.ReflexaoDocenteDAO;


public class FrameTable extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameTable() throws SQLException{
		super("Docente");
		final DocenteDAO dao = new DocenteDAO();
		
		JTable t = new JTable(new GenericTableModel<Docente>(new ReflexaoDocenteDAO()));
		
		JScrollPane scroll = new JScrollPane(); //para permitir a rolagem
		scroll.setViewportView(t);
		add(scroll);
		setSize(400,300);
		setLocationRelativeTo(null); //centraliza o JFrame
	}
}