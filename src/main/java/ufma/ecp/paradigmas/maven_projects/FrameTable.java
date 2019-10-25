package ufma.ecp.paradigmas.maven_projects;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameTable extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameTable() {
		super("Contatos");
		ContatoDAO dao = new ContatoDAO();
		JTable t = new JTable(new ContatoTableModel(dao));
		JScrollPane scroll = new JScrollPane(); //para permitir a rolagem
		scroll.setViewportView(t);
		add(scroll);
		setSize(400,300);
		setLocationRelativeTo(null); //centraliza o JFrame
	}
	
}
