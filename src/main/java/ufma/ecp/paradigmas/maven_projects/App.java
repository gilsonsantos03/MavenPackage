package ufma.ecp.paradigmas.maven_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

    	public static void recuperarDados() {
    		Connection conn;
    		String url = "jdbc:mysql://localhost/agenda?user=root&password=1234&useTimezone=true&serverTimezone=UTC";
    		try {
    			conn = DriverManager.getConnection(url);
    			String sql = "select * from contato";
    			PreparedStatement stmt = conn.prepareStatement(sql);
    		
    			ResultSet rs = stmt.executeQuery();
    			
    			while(rs.next()) {
    				System.out.println("nome:" + rs.getString("nome"));
    				System.out.println("email:" + rs.getString("email"));
    				System.out.println("telefone:" + rs.getString("telefone"));
    			}
    				
    			stmt.close();
    			
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    		
    	}
    	
    	public static void inserirDados() {
    		String url = "jdbc:mysql://localhost/agenda?user=root&password=1234&useTimezone=true&serverTimezone=UTC";
    		try {
    			Connection conn = DriverManager.getConnection(url);
    			System.out.println("Conectado com sucesso!");
    			String sql = "insert into contato (nome, email, telefone) values (?,?,?)";
    			PreparedStatement stmt = conn.prepareStatement(sql);
    			
    			stmt.setString(1, "Pedro");
    			stmt.setString(2, "pedrons@gmail");
    			stmt.setString(3, "981323929");
    			
    			stmt.execute();
    			stmt.close();
    			
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	
 
    	
        public static void main( String[] args )
        {
        		inserirDados();
    			recuperarDados();
    			
    		
        }
}
