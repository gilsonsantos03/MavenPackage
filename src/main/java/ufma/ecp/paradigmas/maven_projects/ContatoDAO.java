package ufma.ecp.paradigmas.maven_projects;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ufma.ecp.paradigmas.maven_projects.Contato;

public class ContatoDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private String url = "jdbc:mysql://localhost/agenda?user=root&password=1234&useTimezone=true&serverTimezone=UTC";
	
	public ContatoDAO(){
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("Conectado!");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}	
	
	public void adicionaContato(Contato c) {
		String sql = "insert into contato(nome, email, telefone) values (?, ?, ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEmail());
			stmt.setString(3, c.getPhone());
			stmt.execute();
			stmt.close();
						
			}catch(SQLException u) {
			throw new RuntimeException(u);
		}
	}
	
	public List<Contato> recuperaContato() throws SQLException{
	
		String sql = "select * from contato";
		List<Contato> lista = new ArrayList<Contato>();
		stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
			
		while (rs.next()) {
			Contato c = new Contato(rs.getString("nome"),rs.getString("email"), rs.getString("telefone"));
			lista.add(c);
		}
		
		stmt.close();
		return lista;
	}
	
	public void atualizaContato(Contato c) throws SQLException{
		String sql = "update contato set nome = ?, telefone = ? where email = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, c.getNome());
		stmt.setString(2, c.getPhone());
		stmt.setString(3, c.getEmail());
		stmt.execute();
		stmt.close();
	}
	
	public void desconecta() throws SQLException {
		stmt.close();
	}
	
	
}
