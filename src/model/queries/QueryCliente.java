package model.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class QueryCliente {
	public static void consultaCliente(Connection conecta) {
		//Connection conecta = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			//conecta = Conexao.getConnection();
			st = conecta.createStatement();
			rs = st.executeQuery("Select * from CLIENTE");
			while (rs.next()) {
				System.out.println(rs.getString("Cpf_Cnpj") +","+  rs.getString("Nome") + ", "
						+ rs.getInt("Inscricao_estadual") + ", " + rs.getString("Estado") + ", " + rs.getString("Email")
						+ ", " + rs.getString("CEP") + ", " + rs.getString("Nome_da_fazenda") + ", "
						+ rs.getString("Telefone") + ", " + rs.getString("Endereço")+rs.getInt("Id")+rs.getString("Cidade"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}

			//	Conexao.closeConnection();

			} catch (SQLException e) {

				e.printStackTrace();
			}
			
		
		}
	}
	public static void insereCliente(Connection conecta) {
		
		PreparedStatement st = null;
		
		try {
			
			st=conecta.prepareStatement("INSERT INTO cliente" +"(Cpf_Cnpj, Nome, Inscricao_estadual, Estado, Email, Endereço, Nome_da_fazenda ,Cidade,CEP,Telefone)" +"VALUES" + "(?,?,?,?,?,?,?,?,?,?)");
			
			st.setString(1, "850.076.171-72");
			st.setString(2, "Carlos Rodrigues Raimundo");
			st.setInt(3, 114274290 );
			st.setString(4, "Go");
			st.setString(5, "teste@gmail.com");
			st.setString(6, "Rua Pacifico Teixeira QRD.33 lot.05  nº1054 centro cep 75460000");
			st.setString(7, "Imbiro");
			//st.setString(8, "edegmar");
			st.setString(8, "Neropolis");
			st.setString(9, "75.460.000");
			st.setString(10, "62 9 99962081 / 62 9 99324447");
			
			st.executeUpdate();
			System.out.println("\n O cliente foi inserido");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			//Conexao.closeConnection();
			try {
				st.close();
			}
			catch(SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	public static void atualizaEnderecoCliente(Connection conecta) {
		PreparedStatement st =null;
		
		try {
			st = conecta.prepareStatement("UPDATE CLIENTE " + "set Endereço = ?" + "WHERE" + "(Cpf_Cnpj = ?)");
			
			st.setString(2,"novo endereco");
			st.setString(1, "706.496.981-50");
			
			st.executeUpdate();
			
			System.out.println("\n Foi alterado o endereço do cliente!!");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
