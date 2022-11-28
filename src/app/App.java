package app;


import java.sql.Connection;

import model.conexao.Conexao;
import model.entidades.ModelProdutos;
import model.queries.QueryProduto;
import view.ViewCliente;
import view.ViewLogin;
import view.ViewProduto;

public class App {

	//private static Conexao conectar = null;
	
	public static void main(String[] args) {
		
		Connection con=Conexao.getConnection();
		ModelProdutos produto = new ModelProdutos();
		//FuncoesBanco.insereCliente(con);
	    //FuncoesBanco.insereVendedor(con);
		//FuncoesBanco.insereProduto(con,produto);
		//FuncoesBanco.insereVenda(con);
		//FuncoesBanco.consultaProduto(con);
		
		
		try {
			
			//ViewLogin frame = new ViewLogin();
			ViewProduto produtos = new ViewProduto();
		    produtos.setVisible(true);
			//frame.setVisible(true);
		} 
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
	
	}
	
}


	
	
