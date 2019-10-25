package ufma.ecp.paradigmas.maven_projects;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameTable extends JFrame{
	
	public FrameTable() {
		JTable tm = new JTable(new ContatoTableModel());
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(tm);
		add(scroll);
		setSize(400,300);
		setLocationRelativeTo(null); //centraliza o JFrame
	}
	
}
