package ufma.ecp.paradigmas.docentesigaa_reflexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ufma.ecp.paradigmas.docentesigaa.Docente;

public class ReflexaoDocenteDAO implements AbstractDAO<Docente>{
	
	//List<Docente> docentes = Arrays.asList(new Docente("Sergio Costa", "PP", 1));
	
	private Connection conn;
	private PreparedStatement stmt;
	private final String url = "jdbc:mysql://localhost/sigaa?user=root&password=1234&useTimezone=true&serverTimezone=UTC";
	
	
	public ReflexaoDocenteDAO(){
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("Conectado!");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void create(Docente docente) {
	}

	@Override
	public List<Docente> read() {
		//return docentes;
		
		List<Docente> lista = new ArrayList<Docente>();
		String sql = "select * from docente";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				lista.add(new Docente(rs.getString("professor"), rs.getString("cadeira"), rs.getInt("id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return lista;
	}
	
}
