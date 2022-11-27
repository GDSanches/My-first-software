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

import model.entidades.ModelProdutos;

public class QueryProduto {

	/**
	 * FAZ UMA CONSULTA E BUSCA TODAS AS LINHAS DA TABELA PRODUTO
	 * @param conecta
	 */
		
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

	

	/**
	*RETORNA UM PRODUTO PELO CODIGO
	*RETORNA UM MODEL PRODUTO
	*/
		public static ModelProdutos retornaProduto(Connection conecta, int pId) {
			ModelProdutos modelProdutos = new ModelProdutos();
			Statement st = null;
			ResultSet rs = null;
			try {
				st = conecta.createStatement();
				rs = st.executeQuery("SELECT"
						+ "pronome,"
						+ "quantidade_em_estoque"
						+ "preco_a_vista"
						+ "preco_a_prazo"
						+ "especificacoes"
						+ "codigo"
						+ "FROM produto WHERE codigo ='"+ pId +"';"); 
				while(rs.next()) {
					modelProdutos.setProNome(rs.getString(1));
					modelProdutos.setQtdEstoque(rs.getInt(2));
					modelProdutos.setPrecoVista(rs.getDouble(3));
					modelProdutos.setPrecoPrazo(rs.getDouble(4));
					modelProdutos.setProEspecificacoes(rs.getString(5));
					modelProdutos.setCodProduto(rs.getInt(6));
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {
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
			return modelProdutos; 
		}
		/**
		 * 
		 * @param conecta
		 * uma lista de produtos 
		 */
		public static ArrayList<ModelProdutos> retornarListaProdutos(Connection conecta){
			ArrayList<ModelProdutos> listaModelProdutos = new ArrayList<>();
			ModelProdutos modelProdutos= new ModelProdutos();
			Statement st = null;
			ResultSet rs = null;
			try {
				st= conecta.createStatement();
				rs = st.executeQuery("SELECT pronome,quantidade_em_estoque,preco_a_vista,preco_a_prazo,especificacoes,codigo FROM produto;"); 
				while(rs.next()) {
					modelProdutos = new ModelProdutos(); 
					modelProdutos.setProNome(rs.getString(1));
					modelProdutos.setQtdEstoque(rs.getInt(2));
					modelProdutos.setPrecoVista(rs.getDouble(3));
					modelProdutos.setPrecoPrazo(rs.getDouble(4));
					modelProdutos.setProEspecificacoes(rs.getString(5));
					modelProdutos.setCodProduto(rs.getInt(6));
					listaModelProdutos.add(modelProdutos);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
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
			return listaModelProdutos;
		}
	/**
	 * 
	 * @param conecta
	 * @param modelProdutos
	 * INSERE UM PRODUTO NO BANCO 
	 */
		
	
	public static void insereProduto(Connection conecta, ModelProdutos modelProdutos) {
		PreparedStatement st = null;
		try {
			
			st= conecta.prepareStatement("INSERT INTO PRODUTO" + "(Preco_a_vista, Preco_a_prazo, Especificacoes, Quantidade_em_estoque, proNome)"+ "VALUES" + "(?,?,?,?,?)");
			

			st.setDouble(1, modelProdutos.getPrecoVista());
			st.setDouble(2, modelProdutos.getPrecoPrazo());
			st.setString(3, modelProdutos.getProEspecificacoes());
			st.setInt(4, modelProdutos.getQtdEstoque());
			st.setString(5, modelProdutos.getProNome());
			
			
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Produto inserido com sucesso.", "Inserido",JOptionPane.INFORMATION_MESSAGE);
		}
		catch(SQLException e ) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi possível inserir o produto.", "Erro",JOptionPane.ERROR_MESSAGE);
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
	

	
	
	/**
	 * 
	 * @param conecta
	 * @param produto
	 * ALTERA UM PRODUTO NO BANCO 
	 */
	public static void alteraProduto(Connection conecta, ModelProdutos produto) {
		PreparedStatement st =null;
		try {
			st = conecta.prepareStatement("UPDATE produto SET"
					+ "pronome = '" + produto.getProNome() + "',"
					+ "preco_a_vista = '" + produto.getPrecoVista()+"',"
					+ "preco_a_prazo= '" +  produto.getPrecoPrazo()+"',"
					+ "quantidade_em_estoque'"+ produto.getQtdEstoque()+"',"
							+ "especificacoes'"+ produto.getProEspecificacoes()+"'"
									+ "WHERE codigo = '"+ produto.getCodProduto() + "'");
			JOptionPane.showMessageDialog(null, "Produto alterado com sucesso.","Deletado",JOptionPane.INFORMATION_MESSAGE);
			
		}catch(SQLException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi possível alterar o produto","Erro",JOptionPane.ERROR_MESSAGE);
			
		}finally {
			
			try {
				st.close();
			}
			catch(SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	/**
	 * EXCLUIR UM PRODUTO NO BANCO
	 * @param conecta
	 * @param pId
	 */
	
	public static void excluirProduto(Connection conecta, int pId) {
		Statement st =null;
		
		try {
			st=conecta.createStatement();
			st.executeUpdate("DELETE FROM produto WHERE codigo = '"+ pId +"'");
			JOptionPane.showMessageDialog(null, "Produto deletado com sucesso","Deletado",JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi possível deletar o produto.","Erro",JOptionPane.ERROR_MESSAGE);
		}finally {
			
			try {
				st.close();
			}
			catch(SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

	
	

}
