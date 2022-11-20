package model.consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FuncoesBanco {

	//CONSULTAS NO BANCO
	
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
	
	public static void consultaProduto(Connection conecta) {
		Statement st = null;
		ResultSet rs = null;
		
		try {
			
				st = conecta.createStatement();
				rs = st.executeQuery("Select * from PRODUTO");
						while (rs.next()) {
							System.out.println(rs.getString("proNome")+rs.getInt("Codigo") + rs.getFloat("Preco_a_vista") + rs.getFloat("Preco_a_prazo") 
							+ rs.getString("Especificacoes") + rs.getInt("Quantidade_em_estoque"));
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
	
	
	
	//INSERINDO NO BANCO
	
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
	
	
	public static void insereProduto(Connection conecta) {
		PreparedStatement st = null;
		try {
			
			st= conecta.prepareStatement("INSERT INTO PRODUTO" + "(Preco_a_vista, Preco_a_prazo, Especificacoes, Quantidade_em_estoque, proNome)"+ "VALUES" + "(?,?,?,?,?)");
			

			st.setFloat (1, 10000);
			st.setFloat(2, 15000);
			st.setString(3, "garde aradora 16x28 marca:baldam nova");
			st.setInt(4, 2);
			st.setString(5, "grade aradora");
			
			
			st.executeUpdate();
			System.out.println("\n Produto foi inserido");
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
	
//ATUALIZA O BANCO DE DADOS
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
		catch(SQLException e)
		{
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
		catch(SQLException e)
		{
			e.printStackTrace();
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
