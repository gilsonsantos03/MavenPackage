package ufma.ecp.paradigmas.docentesigaa;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class DocenteTableModel extends AbstractTableModel implements TableModelListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DocenteDAO dao;
	private List<String> colunas;
	private List<Docente> docentes;
	
	
	public DocenteTableModel(DocenteDAO dao) throws SQLException {
		this.dao = dao;
		this.docentes = dao.recuperaDocente();
		colunas = Arrays.asList("Professor", "Cadeira", "Id");
		this.addTableModelListener(this);
	}
	
	public int getColumnCount() {
		return colunas.size();
	}

	public int getRowCount() {
		return docentes.size();
	}

	public Object getValueAt(int l, int c) {
		
		Docente docente = docentes.get(l);
		switch (c) {
		case 0: return docente.getProfessor();
		case 1: return docente.getCadeira();
		case 2: return docente.getId();
		
		}
		return null;
	}
	
	@Override
	public boolean isCellEditable(int l, int c) {
		return true;
	}
	
	
	public void setValueAt(Object aValue, int l, int c) {
		Docente docente = docentes.get(l); //pega o valor referente a linha especificada 
		
		switch (c) {
		case 0: 
			docente.setProfessor((String)aValue);
			break;
		case 1:
			docente.setCadeira((String)aValue);
			break;
		case 2:
			docente.setId((Integer)aValue);
			break;
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
		fireTableCellUpdated(l,c); //notifica a atualização da célula
	}

	public void tableChanged(TableModelEvent ev) {
		try {
			int i = ev.getFirstRow();
			Docente docente = docentes.get(i);
			System.out.println(i);
			dao.atualizaDocente(docente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
