package model.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryVendedor {
	public static void consultaVendedor (Connection conecta) {
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conecta.createStatement();
			rs = st.executeQuery("Select * from VENDEDOR");
					while (rs.next()) {
						System.out.println(rs.getString("Username") + rs.getString("Senha")+ rs.getInt("Id"));
					}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
			
		}
	}
	public static void insereVendedor(Connection conecta) {
		PreparedStatement st = null;
	try {
		st=conecta.prepareStatement("INSERT INTO VENDEDOR" + "(Username, Senha)" + "VALUES" + "(?,?)");
		
		st.setString(1, "edegmar");
		st.setString(2,"esmg1967");
		
		st.executeUpdate();
		
		System.out.println("\n O vendedor foi inserido");
	}
	catch(SQLException e ) {
		
		e.printStackTrace();
	}
	finally {
		
		try {
			st.close();
		}
		catch(SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	}
	public static void atualizaSenha(Connection conecta) {
		//tabela vendedor senha
		PreparedStatement st =null;
		
		try {
			st = conecta.prepareStatement("UPDATE vendedor" +"set Senha = ?" +"WHERE" + "(Username = ?)");
			st.setString(1, "nova senha");
			st.setString(2,"guilherme");
			
			st.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
