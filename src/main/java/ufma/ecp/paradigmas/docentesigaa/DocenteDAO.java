package ufma.ecp.paradigmas.docentesigaa;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocenteDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private String url = "jdbc:mysql://localhost/sigaa?user=root&password=1234&useTimezone=true&serverTimezone=UTC";
	
	
	public DocenteDAO(){
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("Conectado!");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}	
	
	public void closeConnection () throws SQLException {
		try {
			conn.close();
			System.out.println("Desconectado!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void adicionaDocente(Docente d) {
		String sql = "insert into docente(professor, cadeira, id) values (?, ?, ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, d.getProfessor());
			stmt.setString(2, d.getCadeira());
			stmt.setInt(3, d.getId());
			stmt.execute();
			stmt.close();
						
			}catch(SQLException u) {
			throw new RuntimeException(u);
		}
	}
	
	public List<Docente> recuperaDocente() throws SQLException{
		
		List<Docente> lista = new ArrayList<Docente>();
		String sql = "select * from docente";
		stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
			
		while(rs.next()) {
			lista.add(new Docente(rs.getString("professor"), rs.getString("cadeira"), rs.getInt("id")));
		}
		return lista;
	}
	
	public void atualizaDocente(Docente d) throws SQLException{
		String sql = "update docente set professor = ?, cadeira = ? where id = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, d.getProfessor());
		stmt.setString(2, d.getCadeira());
		stmt.setInt(3, d.getId());
		stmt.execute();
		stmt.close();
	}
}
