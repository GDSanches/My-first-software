
package model.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class QueryVenda {
	public static void consultaVenda(Connection conecta) {
		Statement st = null;
		ResultSet rs = null;
		try {
		st = conecta.createStatement();
		rs = st.executeQuery("Select * from VENDA");
				while (rs.next()) {
					System.out.println(rs.getInt("Codigo")+rs.getFloat("Preco_total") + rs.getString("Forma_de_pagamento") 
					 +  rs.getString("FK_CLIENTE_Cpf_Cnpj")  + rs.getString("FK_VENDEDOR_User"));
					System.out.println(rs.getDate("Data"));
					System.out.println(rs.getBoolean("Situacao"));
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
	public static void consultaItensvendidos(Connection conecta) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conecta.createStatement();
			rs= st.executeQuery("Select * from ItensVendidos");
			while(rs.next()){
				System.out.println(rs.getInt("fk_PRODUTO_Codigo" + rs.getInt("fk_VENDA_Codigo")));
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
	public static void insereVenda (Connection conecta){
		
		PreparedStatement st = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		
			st=conecta.prepareStatement("INSERT INTO venda" + "(Preco_total, Forma_de_pagamento, Data, FK_VENDEDOR_User, FK_CLIENTE_Cpf_Cnpj, Situacao)" + "VALUES" + "(?,?,?,?,?,?)");
			
			//st.setInt(1, 01);
			st.setFloat(1,10000);  
			st.setString(2, "avista");
			st.setDate(3, new java.sql.Date(sdf.parse("19/11/2022").getTime()));
			st.setString(4, "edegmar");
			st.setString(5, "850.076.171-72");
			st.setBoolean(6, false);
			
			st.executeUpdate();
			
			System.out.println(" \n A venda foi adicionada");
		}
		catch(SQLException e ) {
			
			e.printStackTrace();	
		} 
		catch (ParseException e) {
			
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

	public static void atualizaPrecoVista(Connection conecta) {
	//tabela produto preco_vista
	PreparedStatement st =null;
	
	try {
		st = conecta.prepareStatement("UPDATE PRODUTO" + "set Preco_a_vista = ?" + "WHERE" +"(Codigo = ?)");
		
		st.setDouble(1, 2.0000);
		st.setInt(1, 02);
		
		st.executeUpdate();
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	
	}

	public static void atualizaPrecoPrazo(Connection conecta) {
	//tabela produto preco_prazo
	PreparedStatement st =null;
	
	try {
		st = conecta.prepareStatement("UPDATE PRODUTO"+"set Preco_a_prazo = ?" + "WHERE" +"(Codigo = ?)");
		
		st.setDouble(1, 5.000);
		st.setInt(2, 1);
		
		st.executeUpdate();
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	}

	public static void atualizaQuantidadeEstoque(Connection conecta) {
	//tabela produto quantidade_estoque
	PreparedStatement st =null;
	
	try {
		st = conecta.prepareStatement("UPDATE PRODUTO" + "set Quantidade_em_estoque = ?" +"WHERE" +"(proNome = ?)");
		st.setInt(1, 10);
		st.setString(2, "grade");
		
		st.executeUpdate();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	}

	public static void atualizaPrecoTotal(Connection conecta) {
	//tabela venda preco_total
	PreparedStatement st =null;
	
	try {
		st = conecta.prepareStatement("UPDATE VENDA" + "set Preco_total = ?" +"WHERE" + "(Codigo = ?)");
		st.setString(1, "12345");
		st.setInt(2, 03);
		
		st.executeUpdate();
	
	}
	catch(SQLException e){
			e.printStackTrace();
		}
	}

	public static void atualizaFormaDepagamento(Connection conecta) {
	//tabela venda forma_de_pagamento
	PreparedStatement st =null;
	
	try {
		st = conecta.prepareStatement("UPDATE VENDA "+"set Forma_de_pagamento = ?" + "WHERE" + "(Codigo = ?)");
		st.setString(1, "2x no cartao");
		st.setInt(2, 01);
		
		st.executeUpdate();
	}
	catch(SQLException e){
			e.printStackTrace();
		}
	}

}
