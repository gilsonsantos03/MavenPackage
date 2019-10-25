package ufma.ecp.paradigmas.maven_projects;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ContatoTableModel extends AbstractTableModel{

	private ContatoDAO dao = new ContatoDAO();
	private List<Contato> contatos = new ArrayList<Contato>();
	
	public ContatoTableModel() {
		try {
			contatos = dao.recuperaContato();
			//criar um metodo para desconectar e botar aqui
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return contatos.size();
	}

	public Object getValueAt(int l, int c) {
		// TODO Auto-generated method stub
		Contato contato = contatos.get(l);
		switch (c) {
		case 0: return contato.getNome();
		case 1: return contato.getEmail();
		case 2: return contato.getPhone();
		}
		
		return null;
	}

}
