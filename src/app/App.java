package app;


import java.sql.Connection;

import bancoDeDados.Conexao;
//import bancoDeDados.Conexao;
//import java.sql.Statement;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import bancoDeDados.FuncoesBanco;
import view.ViewCliente;
import view.ViewLogin;

public class App {

	//private static Conexao conectar = null;
	
	public static void main(String[] args) {
		
		Connection con=Conexao.getConnection();
		
		//FuncoesBanco.insereCliente(con);
		//FuncoesBanco.insereVendedor(con);
		//FuncoesBanco.insereProduto(con);
		//FuncoesBanco.insereVenda(con);
		
		FuncoesBanco.consultaCliente(con);
		FuncoesBanco.consultaVendedor(con);
		FuncoesBanco.consultaProduto(con);
		FuncoesBanco.consultaVenda(con);
		FuncoesBanco.consultaItensvendidos(con);
		
		Conexao.closeConnection();
		 
		try {
			
			ViewLogin frame = new ViewLogin();
			frame.setVisible(true);
		} 
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		try {
			ViewCliente frame = new ViewCliente();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
}


		 /*
		try
		{
			conectar = new Conexao();
			
			System.out.println("Usuario da Conexao: " + conectar.getConexao().getMetaData().getUserName());
			System.out.println("URL da Conexao: " + conectar.getConexao().getMetaData().getURL());
			Statement st = conectar;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			if(conectar != null)
				conectar.fecharConexao();
		}
		*/
	
