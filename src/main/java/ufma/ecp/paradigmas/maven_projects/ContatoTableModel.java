package ufma.ecp.paradigmas.maven_projects;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class ContatoTableModel extends AbstractTableModel implements TableModelListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ContatoDAO dao;
	private List<String> colunas;
	private List<Contato> contatos;
	
	
	public ContatoTableModel(ContatoDAO dao) {
		try {
			this.dao = dao;
			this.contatos = dao.recuperaContato();
			colunas = Arrays.asList("Nome", "Email", "Telefone", "Grupo", "Ativo");
			this.addTableModelListener(this);
			this.dao.desconecta();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getColumnCount() {
		return colunas.size();
	}

	public String getColumnName(int i) {
		return colunas.get(i);
	}
	
	public int getRowCount() {
		return contatos.size();
	}

	public Object getValueAt(int l, int c) {
		
		Contato contato = contatos.get(l);
		switch (c) {
		case 0: return contato.getNome();
		case 1: return contato.getEmail();
		case 2: return contato.getPhone();
		case 3: return contato.getGrupo();
		case 4: return contato.getAtivo();
		}
		return null;
	}
	
	@Override
	public boolean isCellEditable(int l, int c) {
		return true;
	}
	
	//faz a JTable associar automaticamente um TableCellRenderer específico para campos booleanos 
	@Override
	public Class<? extends Object> getColumnClass(int c) {  //ele tava dando um warning que era pra parametrizar <? extends Object>
		return getValueAt(0,c).getClass(); 
	}
	
	public void setValueAt(Object aValue, int l, int c) {
		Contato contato = contatos.get(l); //pega o valor referente a linha especificada 
		
		switch (c) {
		case 0: 
			contato.setNome((String)aValue);
			break;
		case 1:
			contato.setEmail((String)aValue);
			break;
		case 2:
			contato.setPhone((String)aValue);
			break;
		case 3:
			contato.setGrupo((String)aValue);
			break;
		case 4:
			contato.setAtivo((Boolean)aValue); //duvida nessa linha
			break;
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
		fireTableCellUpdated(l,c); //notifica a atualização da célula
	}

	public void tableChanged(TableModelEvent ev) {
		try {
			int i = ev.getFirstRow();
			Contato contato = contatos.get(i);
			System.out.println(i);
			dao.atualizaContato(contato);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
