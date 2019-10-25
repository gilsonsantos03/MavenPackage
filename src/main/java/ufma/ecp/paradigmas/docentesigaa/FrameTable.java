package ufma.ecp.paradigmas.docentesigaa;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameTable extends JFrame{
	
	public FrameTable() throws SQLException{
	super("Teste");
	final DocenteDAO dao = new DocenteDAO();
	JTable t = new JTable(new DocenteTableModel(dao));
	
	JScrollPane scroll = new JScrollPane(); //para permitir a rolagem
	scroll.setViewportView(t);
	add(scroll);
	setSize(400,300);
	setLocationRelativeTo(null); //centraliza o JFrame
	}
}