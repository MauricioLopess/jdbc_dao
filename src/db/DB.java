package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			if(conn == null) {
				Properties props = loadProperties();  // carrega as propriedades
				String url = props.getProperty("dburl"); // captura a url da conexão
				conn = DriverManager.getConnection(url, props);
			}
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		return conn;
	}
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			
			}
		}
	}
	
	
	public static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")){ // cria um leitor do arquivo .properties
			Properties props = new Properties();
			props.load(fs); // o método load faz a leitura do arquivo apontado pelo InputStream, guardado os dados 
			return props;
		}catch(IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
}
