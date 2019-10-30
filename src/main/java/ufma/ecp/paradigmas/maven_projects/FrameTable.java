package ufma.ecp.paradigmas.maven_projects;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameTable extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameTable() {
		super("Teste");
		final ContatoDAO dao = new ContatoDAO();
		JTable t = new JTable(new ContatoTableModel(dao));
		
		JComboBox<String> cb = new JComboBox<String>();
		cb.addItem("Familia");
		cb.addItem("Amigo");
		cb.addItem("Conhecido");
		t.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(cb));
		
		JScrollPane scroll = new JScrollPane(); //para permitir a rolagem
		scroll.setViewportView(t);
		add(scroll);
		setSize(400,300);
		setLocationRelativeTo(null); //centraliza o JFrame
	}
	
}
