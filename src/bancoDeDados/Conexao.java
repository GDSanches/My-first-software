package bancoDeDados;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import Excecao.DbException;

public class Conexao {

	private static Connection conecta =null;
	
	public static Connection getConnection() {
		if(conecta==null) {
			try {
			Properties props = loadProperties();
			String url = props.getProperty("dburl");
			conecta= DriverManager.getConnection(url, props);
			}
			catch(SQLException e) {
				
				throw new DbException(e.getMessage());
			}
		}
		return conecta;
	}
	
	public static void closeConnection() {
		if(conecta!=null) {
			try {
				conecta.close();
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
private static Properties loadProperties() {
	try(FileInputStream fs = new FileInputStream("db.properties")) {
		Properties props = new Properties();
		props.load(fs);
		return props;
	}
	catch(IOException e) {
		throw new DbException(e.getMessage());
	}

}




}	
/*
	private String driver = "org.postgresql.Driver";
	private String user = "postgres";
	private String senha = "3002gds";
	private String url = "jdbc:postgresql://localhost:5432/agrosanches";
	private static Connection con = null;

	public Conexao() {
		try
		{
			Class.forName(driver);
			//Connection con = null;
			this.con = (Connection) DriverManager.getConnection(url, user, senha);
			System.out.println("Conex�o realizada com sucesso.");
		}
		catch (ClassNotFoundException ex)
		{
			System.err.print(ex.getMessage());
		} 
		catch (SQLException e)
		{
			System.err.print(e.getMessage());
		}
	}
	
	public static Connection getConexao(){
		return con;
	}

	public void fecharConexao(){
		try{
			if(con != null)
				con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/


